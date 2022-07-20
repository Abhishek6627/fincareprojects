package com.currency_exchange.repository;

import com.currency_exchange.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MyRepo extends JpaRepository<CurrencyExchange , Long>
{
   //CurrencyExchange findById(String from, String to);

    CurrencyExchange findByFromAndTo(String from, String to);
}
