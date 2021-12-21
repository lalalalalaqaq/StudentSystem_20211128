package com.edu.studentsystem_20211128.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Attendance {

    private Integer id;
    private Integer courseId;
    private Integer studentId;
    private String type;
    private String date;

}
