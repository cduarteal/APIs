package com.services.api.service;

import com.services.api.dto.PriceOutPut;
import com.services.api.entity.Price;
import com.services.api.exception.NotFoundException;
import com.services.api.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository  priceRepository;

    @Transactional(readOnly = true)
    public PriceOutPut findPrice(Integer product_id, Integer brand_id, String start_date){
        try {
            Price price = priceRepository
                    .getPriceFinal(product_id, brand_id, Timestamp.valueOf(start_date))
                    .max(Comparator.comparing(p -> p))
                    .orElseThrow(NoSuchElementException::new);

            return new PriceOutPut(price, start_date);

        }catch (Exception e){
            throw new NotFoundException("No prices data found");
        }

    }
}
