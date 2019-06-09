package com.example.demomapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Employee {
    private int id;
    private String name;
    private Division division;
    private Date startDt;
}
