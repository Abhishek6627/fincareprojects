package com.in28min.microserviceV2.controller;

import com.in28min.microserviceV2.limitsservice.config.Configration;
import com.in28min.microserviceV2.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController
{
    @Autowired
    private Configration configration;
    @GetMapping("/limits")
    public Limits retrieveLimits()
    {
        return  new Limits(configration.getMinimum(),configration.getMaximum());
      //  return new Limits(1,1000);
    }
}
