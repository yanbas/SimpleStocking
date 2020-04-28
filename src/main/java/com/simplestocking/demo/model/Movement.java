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
@Entity(name = "movement")
public class Movement {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "material_id")
    @JsonProperty("material_id")
    private String materialId;

    @Column(name = "transaction_date")
    @JsonProperty("transaction_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;

    @Column(name = "status")
    private String status;

    @Column(name = "qty")
    private int qty;

    @Column(name = "pic")
    private String pic;

}
