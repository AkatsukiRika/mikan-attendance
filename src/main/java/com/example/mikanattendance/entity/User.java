package com.example.mikanattendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Table(name = "User")
public class User implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "RealName")
    private String realName;

    @Column(name = "UserPass")
    private String userPass;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;

    // 枚举类型，可取"PM", "HR", "SALES", "OTHERS"
    @Column(name = "UserType")
    private String userType;
}
