package com.example.mikanattendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "Salary")
public class Salary {
    @Id
    @Column(name = "ID")
    private Integer ID;

    // 外键，指向User表
    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "PayDay")
    private Integer payDay;

    @Column(name = "Salary")
    private Integer salary;

    @Column(name = "Remark")
    private String remark;
}
