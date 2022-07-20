package com.customer_data.controller;


import com.customer_data.custbycif.CustDetailsByCif;
import com.customer_data.custbycif.GetCustByCif;
import com.customer_data.custbycif.Response1;
import com.customer_data.model.CustomerDetailsProxy;
import com.customer_data.model.CustomerSearchByPanRequest;
import com.customer_data.model.GetCustDataByCif;
import com.customer_data.model.Response;
import com.customer_data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    CustomerDetailsProxy customerDetailsProxy;

    @Autowired
    GetCustDataByCif getCustDataByCif;

    @PostMapping("/getPan")
    public Response getDetails(@RequestBody CustomerSearchByPanRequest customerPan)
    {
       return  customerService.getDetails(customerPan);
        //return null;
    }

    @PostMapping("/getCif")
    public Response1 getCustDetailsByCif(@RequestBody GetCustByCif getCustByCif )
    {
        return  customerService.getDetailsByCif(getCustByCif);
    }

    @PostMapping("/addCust")
    public CustDetailsByCif addCustmoreByCif(@RequestBody CustDetailsByCif getCustByCif)
    {
        return  customerService.addCustomerInDb(getCustByCif);
    }
}

