package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.Suggestion;
import com.example.mikanattendance.service.ISuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SuggestionController {
    @Autowired
    private ISuggestionService suggestionService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    private BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    private BasicResponse createResponse(Object result) {
        return baseController.createResponse(true, result, null);
    }

    @PostMapping(value = "/suggestion/")
    public BasicResponse insert(@RequestBody Suggestion suggestion) {
        BasicResponse response = null;
        int result = suggestionService.insert(suggestion);
        response = createResponse(result);
        return response;
    }

    @DeleteMapping(value = "/suggestion/")
    public BasicResponse delete(@RequestBody Suggestion suggestion) {
        int result = suggestionService.delete(suggestion);
        return createResponse(result);
    }

    // 必须传ID
    @PatchMapping(value = "/suggestion/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody Suggestion suggestion) {
        int result = suggestionService.updateByPrimaryKeySelective(suggestion);
        return createResponse(result);
    }

    @GetMapping(value = "/suggestion/")
    public BasicResponse select(@RequestBody Suggestion suggestion) {
        if(suggestion == null) {
            List<Suggestion> result = suggestionService.selectAll();
        }
        List<Suggestion> result = suggestionService.select(suggestion);
        return createResponse(result);
    }
}
