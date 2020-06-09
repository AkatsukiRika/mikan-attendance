package com.example.mikanattendance.controller;

import com.example.mikanattendance.entity.BasicResponse;
import com.example.mikanattendance.entity.ProductOrder;
import com.example.mikanattendance.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductOrderController {
    @Autowired
    private IProductOrderService productOrderService;
    private final BaseController baseController = new BaseController();

    @ExceptionHandler(value = Exception.class)
    private BasicResponse exceptionHandler(Exception e) {
        return baseController.exceptionHandler(e);
    }

    private BasicResponse createResponse(Object result) {
        return baseController.createResponse(true, result, null);
    }

    @PostMapping(value = "/productOrder/")
    public BasicResponse insert(@RequestBody ProductOrder productOrder) {
        BasicResponse response = null;
        int result = productOrderService.insert(productOrder);
        response = createResponse(result);
        return response;
    }

    @DeleteMapping(value = "/productOrder/")
    public BasicResponse delete(@RequestBody ProductOrder productOrder) {
        int result = productOrderService.delete(productOrder);
        return createResponse(result);
    }

    // 必须传ID
    @PatchMapping(value = "/productOrder/")
    public BasicResponse updateByPrimaryKeySelective(@RequestBody ProductOrder productOrder) {
        int result = productOrderService.updateByPrimaryKeySelective(productOrder);
        return createResponse(result);
    }

    @GetMapping(value = "/productOrder/")
    public BasicResponse select(@RequestBody ProductOrder productOrder) {
        if(productOrder == null) {
            List<ProductOrder> result = productOrderService.selectAll();
        }
        List<ProductOrder> result = productOrderService.select(productOrder);
        return createResponse(result);
    }
}
