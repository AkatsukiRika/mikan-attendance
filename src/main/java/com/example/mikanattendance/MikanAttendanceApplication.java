package com.example.mikanattendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.mikanattendance.dao")
public class MikanAttendanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MikanAttendanceApplication.class, args);
    }

}
