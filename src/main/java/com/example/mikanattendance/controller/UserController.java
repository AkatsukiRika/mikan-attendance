package com.example.mikanattendance.controller;

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

    private BasicResponse createResponse(Object result) {
        return baseController.createResponse(true, result, null);
    }

    @PostMapping(value = "/user/")
    public BasicResponse insert(@RequestBody User user) {
        String userPass = DigestUtils.md5DigestAsHex(user.getUserPass().getBytes());
        user.setUserPass(userPass);
        BasicResponse response = null;
        int result = userService.insert(user);
        response = createResponse(result);
        return response;
    }

    @DeleteMapping(value = "/user/")
    public BasicResponse delete(@RequestBody User user) {
        int result = userService.delete(user);
        return createResponse(result);
    }

    // 必须传ID
    @PatchMapping(value = "/user/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody User user) {
        int result = userService.updateByPrimaryKeySelective(user);
        return createResponse(result);
    }

    @GetMapping(value = "/user/")
    public BasicResponse select(@RequestBody User user) {
        if(user == null) {
            List<User> result = userService.selectAll();
        }
        List<User> result = userService.select(user);
        return createResponse(result);
    }
}
