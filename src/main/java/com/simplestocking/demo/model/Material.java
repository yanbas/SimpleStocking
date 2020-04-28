package com.simplestocking.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "materials")
public class Material {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "material_name")
    @JsonProperty("material_name")
    private String materialName;

    @Column(name = "qty")
    private int qty;

    @Column(name = "status")
    private String status;

    @Column(name = "material_aliase")
    @JsonProperty("aliase")
    private String materialAliase;

    @Column(name = "created_date")
    @JsonProperty("created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

}
