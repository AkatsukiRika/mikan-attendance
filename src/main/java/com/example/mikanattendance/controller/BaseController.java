package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.regex.*;

public class BaseController {
    public BasicResponse exceptionHandler(Exception e) {
        return createResponse(false, null, e.getMessage());
    }

    public BasicResponse createResponse(boolean succeed, Object result, String errorMessage) {
        BasicResponse basicResponse = new BasicResponse();
        if (succeed) {
            basicResponse.setCode(0);
            basicResponse.setMessage("Operation succeeded");
            basicResponse.setData(result);
        } else  {
            basicResponse.setCode(-1);
            basicResponse.setMessage(errorMessage);
            basicResponse.setData(null);
        }
        return basicResponse;
    }

    public boolean isIllegalEmail(String email) {
        String pattern = "^([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4})$";
        return !Pattern.matches(pattern, email);
    }

    public boolean isIllegalPhone(String phone) {
        String pattern = "^1[34578]\\d{9}$";
        return !Pattern.matches(pattern, phone);
    }
}
