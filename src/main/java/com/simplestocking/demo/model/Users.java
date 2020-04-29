package com.simplestocking.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "users")
public class Users {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id")
    private String userId;

    @Column(name = "employee_id")
    @JsonProperty("employee_id")
    private int employeeId;

    @Column(name = "level")
    private String level;

    @Column(name = "position")
    private String position;

    @Column(name = "created_date")
    private Date created_date;

    @Column(name = "last_login")
    @JsonProperty("last_login")
    private Date lastLogin;




}
