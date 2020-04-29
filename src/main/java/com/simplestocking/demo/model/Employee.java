package com.simplestocking.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "employee")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private int employee_id;

    @Column(name = "name")
    private String name;

    private String division;

    private String position;

    @Column(name = "created_date")
    private Date createdDate;

}
