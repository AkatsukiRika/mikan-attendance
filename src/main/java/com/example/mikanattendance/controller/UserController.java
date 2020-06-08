package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.User;
import com.example.mikanattendance.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    public BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    public BasicResponse createResponse(boolean succeed, Object result, String errorMessage) {
        return baseController.createResponse(succeed, result, errorMessage);
    }

    @PostMapping(value = "/user/")
    public BasicResponse insert(@RequestBody User user) {
        String userPass = DigestUtils.md5DigestAsHex(user.getUserPass().getBytes());
        user.setUserPass(userPass);
        BasicResponse response = null;
        int result = userService.insert(user);
        response = createResponse(true, result, null);
        return response;
    }

    @DeleteMapping(value = "/user/")
    public BasicResponse delete(@RequestBody User user) {
        int result = userService.delete(user);
        return createResponse(true, result, null);
    }

    // 必须传ID
    @PatchMapping(value = "/user/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody User user) {
        int result = userService.updateByPrimaryKeySelective(user);
        return createResponse(true, result, null);
    }

    @GetMapping(value = "/user/")
    public BasicResponse selectOne(@RequestBody User user) {
        User result = userService.selectOne(user);
        return createResponse(true, result, null);
    }
}
