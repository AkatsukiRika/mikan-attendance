package com.example.mikanattendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Table(name = "Attendance")
public class Attendance implements Serializable {
    @Id
    @Column(name = "ID")
    private Integer ID;

    // 外键，指向User表
    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "AttendanceTime")
    private Integer attendanceTime;

    // 枚举类型，可取"ON_TIME", "LATE", "OUT_OF_RANGE"
    @Column(name = "AttendanceStatus")
    private String attendanceStatus;

    // 0是上班，1是下班，不能出现其他值
    @Column(name = "AttendanceType")
    private Short attendanceType;

    @Column(name = "Remark")
    private String remark;
}
