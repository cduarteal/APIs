package com.services.api.controller;

import com.services.api.dto.PriceOutPut;
import com.services.api.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/price")
public class PriceController {

    private final PriceService priceService;

    @GetMapping
    public ResponseEntity<PriceOutPut> getAllCurrency(@PathParam(value = "product_id") Integer product_id,
                                                      @PathParam(value = "brand_id") Integer brand_id,
                                                      @PathParam(value = "start_date") String start_date){
        return ResponseEntity.ok(priceService.findPrice(product_id, brand_id, start_date));
    }

}
