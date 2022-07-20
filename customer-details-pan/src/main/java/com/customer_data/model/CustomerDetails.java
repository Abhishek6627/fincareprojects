package com.customer_data.model;

public class CustomerDetails {

    private String customerNumber;


//    public CustomerDetails() {
//    }
//
//    public CustomerDetails(String customerNumber)
//    {
//        this.customerNumber = customerNumber;
//    }

    public String getCustomerNumber()
    {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "customerNumber='" + customerNumber + '\'' +
                '}';
    }
}