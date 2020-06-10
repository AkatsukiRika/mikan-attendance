package com.example.mikanattendance.controller;

import com.example.mikanattendance.annotation.UserLoginToken;
import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.User;
import com.example.mikanattendance.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    private BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    private BasicResponse createResponse(boolean succeed, Object result, String errorMessage) {
        return baseController.createResponse(succeed, result, errorMessage);
    }

    private String validator(String email, String phone) {
        // 允许没有email或者手机号
        if(email == null || phone == null) return "";
        if(baseController.isIllegalEmail(email) || baseController.isIllegalPhone(phone)) {
            return "illegal email or phone number";
        }
        return "";
    }

    @PostMapping(value = "/user/")
    @UserLoginToken
    public BasicResponse insert(@RequestBody User user) {
        BasicResponse response = null;

        // 检验email跟手机号
        String email = user.getEmail();
        String phone = user.getPhone();
        String errorMessage = validator(email, phone);
        if(!errorMessage.equals("")) {
            response = createResponse(false, null, errorMessage);
            return response;
        }

        String userPass = DigestUtils.md5DigestAsHex(user.getUserPass().getBytes());
        user.setUserPass(userPass);
        int result = userService.insert(user);
        response = createResponse(true, result, null);
        return response;
    }

    @DeleteMapping(value = "/user/")
    @UserLoginToken
    public BasicResponse delete(@RequestBody User user) {
        int result = userService.delete(user);
        return createResponse(true, result, null);
    }

    // 必须传ID
    @PatchMapping(value = "/user/")
    @UserLoginToken
    public BasicResponse updateByPrimaryKeySelective(@RequestBody User user) {
        // 检验email跟手机号
        String email = user.getEmail();
        String phone = user.getPhone();
        String errorMessage = validator(email, phone);
        if(!errorMessage.equals("")) {
            return createResponse(false, null, errorMessage);
        }

        int result = userService.updateByPrimaryKeySelective(user);
        return createResponse(true, result, null);
    }

    @GetMapping(value = "/user/")
    public BasicResponse select(@RequestBody User user) {
        if(user == null) {
            List<User> result = userService.selectAll();
        }
        List<User> result = userService.select(user);
        return createResponse(true, result, null);
    }

    @PostMapping(value = "/user/login")
    public BasicResponse login(@RequestBody User user) {
        String userPass = DigestUtils.md5DigestAsHex(user.getUserPass().getBytes());
        user.setUserPass(userPass);
        List<User> usersForLogin = userService.select(user);
        if(usersForLogin.size() == 0) {
            return createResponse(false, null, "login failed");
        }
        else {
            User userForLogin = usersForLogin.get(0);
            String token = baseController.getToken(userForLogin);
            return createResponse(true, token, "login succeeded");
        }
    }
}
