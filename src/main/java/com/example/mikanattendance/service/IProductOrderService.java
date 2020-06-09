package com.example.mikanattendance.service;

import com.example.mikanattendance.entity.ProductOrder;

import java.util.List;

public interface IProductOrderService {
    int insert(ProductOrder productOrder);

    int delete(ProductOrder productOrder);
    
    int updateByPrimaryKeySelective(ProductOrder productOrder);

    List<ProductOrder> select(ProductOrder productOrder);

    List<ProductOrder> selectAll();
}
