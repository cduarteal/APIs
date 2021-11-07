package com.services.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PriceInput implements Serializable {

    protected Integer product_id;
    protected Integer brand_id;
    protected String start_date;
    protected String end_date;

}
