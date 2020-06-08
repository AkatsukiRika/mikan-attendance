package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.ProductOrder;

public interface IProductOrderService {
    int insert(ProductOrder productOrder);

    int delete(ProductOrder productOrder);
    
    int updateByPrimaryKeySelective(ProductOrder productOrder);

    ProductOrder selectOne(ProductOrder productOrder);
}
