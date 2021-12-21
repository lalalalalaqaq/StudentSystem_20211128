package com.edu.studentsystem_20211128.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Score {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private double score;
    private String remark;
}
