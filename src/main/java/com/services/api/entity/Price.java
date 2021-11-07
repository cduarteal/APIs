package com.services.api.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@EqualsAndHashCode
public class Price implements Serializable, Comparable<Price> {

    @EmbeddedId
    private Product product;
    private Integer brand_id;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private Integer priority;
    private Float price;
    @Column(length = 3)
    private String curr;

    @Override
    public int compareTo(Price other) {
        return this.priority.compareTo(other.getPriority());
    }
}
