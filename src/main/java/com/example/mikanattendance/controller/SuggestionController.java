package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.Suggestion;
import com.example.mikanattendance.service.ISuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SuggestionController {
    @Autowired
    private ISuggestionService suggestionService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    public BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    public BasicResponse createResponse(boolean succeed, Object result, String errorMessage) {
        return baseController.createResponse(succeed, result, errorMessage);
    }

    @PostMapping(value = "/suggestion/")
    public BasicResponse insert(@RequestBody Suggestion suggestion) {
        BasicResponse response = null;
        int result = suggestionService.insert(suggestion);
        response = createResponse(true, result, null);
        return response;
    }

    @DeleteMapping(value = "/suggestion/")
    public BasicResponse delete(@RequestBody Suggestion suggestion) {
        int result = suggestionService.delete(suggestion);
        return createResponse(true, result, null);
    }

    // 必须传ID
    @PatchMapping(value = "/suggestion/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody Suggestion suggestion) {
        int result = suggestionService.updateByPrimaryKeySelective(suggestion);
        return createResponse(true, result, null);
    }

    @GetMapping(value = "/suggestion/")
    public BasicResponse selectOne(@RequestBody Suggestion suggestion) {
        Suggestion result = suggestionService.selectOne(suggestion);
        return createResponse(true, result, null);
    }
}
