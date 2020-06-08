package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.ProductOrder;
import com.example.mikanattendance.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductOrderController {
    @Autowired
    private IProductOrderService productOrderService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    public BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    public BasicResponse createResponse(boolean succeed, Object result, String errorMessage) {
        return baseController.createResponse(succeed, result, errorMessage);
    }

    @PostMapping(value = "/productOrder/")
    public BasicResponse insert(@RequestBody ProductOrder productOrder) {
        BasicResponse response = null;
        int result = productOrderService.insert(productOrder);
        response = createResponse(true, result, null);
        return response;
    }

    @DeleteMapping(value = "/productOrder/")
    public BasicResponse delete(@RequestBody ProductOrder productOrder) {
        int result = productOrderService.delete(productOrder);
        return createResponse(true, result, null);
    }

    // 必须传ID
    @PatchMapping(value = "/productOrder/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody ProductOrder productOrder) {
        int result = productOrderService.updateByPrimaryKeySelective(productOrder);
        return createResponse(true, result, null);
    }

    @GetMapping(value = "/productOrder/")
    public BasicResponse selectOne(@RequestBody ProductOrder productOrder) {
        ProductOrder result = productOrderService.selectOne(productOrder);
        return createResponse(true, result, null);
    }
}
