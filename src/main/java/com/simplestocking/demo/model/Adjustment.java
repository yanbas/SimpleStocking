package com.simplestocking.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity(name = "adjustment")
public class Adjustment {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "material_id")
    @JsonProperty("material_id")
    private String materialId;

    @Column(name = "movement_id")
    @JsonProperty("movement_id")
    private String movementId;

    @Column(name = "reason")
    private String reason;

    @Column(name = "adjustment_date")
    @JsonProperty("adjustment_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String adjustmentDate;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "created_date")
    @JsonProperty("created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    private String pic;

}
