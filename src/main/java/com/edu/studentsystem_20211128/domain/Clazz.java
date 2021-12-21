package com.edu.studentsystem_20211128.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Clazz {

    private Integer id;
    private String name;
    private String info;

}
