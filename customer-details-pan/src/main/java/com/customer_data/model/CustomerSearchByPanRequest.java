package com.customer_data.model;

import javax.validation.constraints.Pattern;

public class CustomerSearchByPanRequest
{
    @Pattern(regexp = "|[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "Invalid pan number")
    private  String panNumber;

//    public CustomerPan()
//    {
//
//    }
//
//    public CustomerPan(String panNumber)
//    {
//        this.panNumber = panNumber;
//    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }
}
