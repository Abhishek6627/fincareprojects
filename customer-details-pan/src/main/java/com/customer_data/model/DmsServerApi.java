package com.customer_data.model;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name =  "random",url = "https://uat-apps04.fincarebank.in")
public interface DmsServerApi
{
    @PostMapping("/DMS/image_operations_direct.php")
    public String saveInDms(@RequestBody String  dmsServer);
}
