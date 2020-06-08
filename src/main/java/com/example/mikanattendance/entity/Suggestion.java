package com.example.mikanattendance.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "Suggestion")
public class Suggestion {
    @Id
    @Column(name = "ID")
    private Integer ID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;
}
