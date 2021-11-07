package com.services.api.repository;

import com.services.api.entity.Price;
import com.services.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public interface PriceRepository extends JpaRepository<Price, Product> {
    @Query("SELECT p FROM Price p WHERE p.product.product_id=:product_id AND p.brand_id=:brand_id " +
            "AND :start_date BETWEEN p.start_date AND p.end_date")
    Stream<Price> getPriceFinal (Integer product_id, Integer brand_id, LocalDateTime start_date);
}
