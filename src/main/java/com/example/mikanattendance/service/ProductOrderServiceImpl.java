package com.example.mikanattendance.service;

import com.example.mikanattendance.dao.IProductOrderDao;
import com.example.mikanattendance.entity.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderServiceImpl implements IProductOrderService {
    @Autowired
    private IProductOrderDao productOrderDao;

    @Override
    public int insert(ProductOrder productOrder) {
        return productOrderDao.insert(productOrder);
    }

    @Override
    public int delete(ProductOrder productOrder) {
        return productOrderDao.delete(productOrder);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductOrder productOrder) {
        return productOrderDao.updateByPrimaryKeySelective(productOrder);
    }

    @Override
    public List<ProductOrder> select(ProductOrder productOrder) {
        return productOrderDao.select(productOrder);
    }

    @Override
    public List<ProductOrder> selectAll() {
        return productOrderDao.selectAll();
    }
}
