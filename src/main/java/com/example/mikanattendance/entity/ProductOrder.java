package com.example.mikanattendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "ProductOrder")
public class ProductOrder {
    @Id
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "OrderSide")
    private String orderSide;

    @Column(name = "Product")
    private String product;

    @Column(name = "SubmitDate")
    private Integer submitDate;

    @Column(name = "EndDate")
    private Integer endDate;

    @Column(name = "Remark")
    private String remark;
}
