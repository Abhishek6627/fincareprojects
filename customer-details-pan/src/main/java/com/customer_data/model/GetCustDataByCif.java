package com.customer_data.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CustomerDetailsInquiry", url = "https://fisesb.fincarebank.com")
public interface GetCustDataByCif
{
        @PostMapping("/bankservices/process")
        public String getCustDataByPan(@RequestBody String xml);

}
