package com.customer_data.model;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name ="GetCustomerDetailsbyPANumber",url = "https://fisesb.fincarebank.com")
public interface CustomerDetailsProxy
{
    @PostMapping("/bankservices/process")
    public String getCustomerIdPan(@RequestBody String xml);
}
