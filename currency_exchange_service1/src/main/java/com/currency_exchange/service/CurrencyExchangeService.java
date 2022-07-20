package com.currency_exchange.service;

import com.currency_exchange.model.CurrencyExchange;
import com.currency_exchange.repository.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService
{


    @Autowired
    private MyRepo repo;

    public  CurrencyExchange addCurrency(CurrencyExchange currencyExchange)
    {
        CurrencyExchange currencyExchange1 = repo.save(currencyExchange);
        return  currencyExchange1;
    }

    public  CurrencyExchange getCurrency(String from, String to)
    {
            CurrencyExchange currencyExchange=  null;

            currencyExchange =this.repo.findByFromAndTo(from, to);

            if (currencyExchange==null)
            {
                throw new RuntimeException("Unable to Find data for "+from+" to "+to);
            }
            return  currencyExchange;
    }

}
