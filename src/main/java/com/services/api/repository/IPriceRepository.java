package com.services.api.repository;

import com.services.api.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPriceRepository extends JpaRepository<Price, Long> {
    @Query(value = "SELECT * " +
            "FROM Prices " +
            "WHERE START_DATE IN (SELECT MAX(START_DATE) FROM Prices " +
            "WHERE END_DATE > TO_TIMESTAMP(?3, 'YYYY-MM-DD HH24:MI:SS')" +
            "AND START_DATE < TO_TIMESTAMP(?3, 'YYYY-MM-DD HH24:MI:SS')" +
            "AND PRODUCT_ID = ?1 AND BRAND_ID = ?2)", nativeQuery = true)
    Price getPriceFinal (Integer product_id, Integer brand_id, String start_date);
}
