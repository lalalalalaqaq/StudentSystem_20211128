package com.edu.studentsystem_20211128.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ScoreStats {
    private Double max_score;
    private Double avg_score;
    private Double min_score;
    private String courseName;//课程名称
}
