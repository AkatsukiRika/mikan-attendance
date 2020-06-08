package com.example.mikanattendance.entity;

import lombok.Data;

@Data
public class BasicResponse {
    // 基本的返回类型
    private Integer code;
    private String message;
    private Object data;
}
