package com.sftp.file.model;


public class CustomerDetails
{
    private  String customerNumber;


    public CustomerDetails()
    {
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
