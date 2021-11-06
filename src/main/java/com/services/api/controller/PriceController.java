package com.services.api.controller;

import com.services.api.entity.Price;
import com.services.api.repository.IPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {

    @Autowired
    IPriceRepository priceRepository;

    @GetMapping("/v1/prices/{product_id}/{brand_id}/{start_date}")
    public ResponseEntity<Price> getAllCurrency(@PathVariable Integer product_id,
                                                      @PathVariable Integer brand_id,
                                                      @PathVariable String start_date){
        try {
            Price price = priceRepository.getPriceFinal(product_id, brand_id, start_date);
            if (price == null) {
                return new ResponseEntity<Price>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity(price, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
