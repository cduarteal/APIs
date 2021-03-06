package com.services.api.dto;

import com.services.api.entity.Price;
import com.services.api.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class PriceOutPut extends PriceInput implements Serializable {

    private Integer rate_applied;
    private Float final_price;

    public PriceOutPut(Price price, String start_date) {
        super();
        super.input_date = start_date;
        super.brand_id = price.getBrand_id();
        Product product = price.getProduct();
        super.product_id = product.getProduct_id();
        this.rate_applied = product.getPrice_list();
        this.final_price = price.getPrice();
    }


}
