package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
