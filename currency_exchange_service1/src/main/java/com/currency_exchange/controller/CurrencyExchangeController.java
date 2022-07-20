package com.currency_exchange.controller;

import com.currency_exchange.model.CurrencyExchange;
import com.currency_exchange.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController
{
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

//    @GetMapping("/currency-exchange/from/{from}/to/{to}")
//    public CurrencyExchange retrieveExchangeVal(@PathVariable String from, @PathVariable String  to)
//    {
//
//        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,
//                BigDecimal.valueOf(50));
//       String port = environment.getProperty("local.server.port");
//        currencyExchange.setEnvironment(port);
//        return currencyExchange;
//    }

    @PostMapping("/currency_add")
    public CurrencyExchange addCurrency(@RequestBody CurrencyExchange exchange)
    {
        return this.currencyExchangeService.addCurrency(exchange);
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getCurrency(@PathVariable String  from, @PathVariable String to)
    {
        CurrencyExchange currencyExchange = currencyExchangeService.getCurrency(from,to);
        String port =environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
