package com.services.api.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "prices")
@Entity
@Setter
@Getter
@ToString
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer price_id;
    private Integer brand_id;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private Integer product_id;
    private Integer priority;
    private Float price;
    @Column(length = 3)
    private String curr;

}
