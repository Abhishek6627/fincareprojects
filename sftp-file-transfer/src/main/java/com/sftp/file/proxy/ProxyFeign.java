package com.sftp.file.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "GetCustomerDetailsbyPANumber",url = "https://fisesb.fincarebank.com")
public interface ProxyFeign
{

    @PostMapping("/bankservices/process")
    public String getCustomerIdPan(@RequestBody String xml);
}
