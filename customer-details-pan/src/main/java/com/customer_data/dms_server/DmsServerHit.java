package com.customer_data.dms_server;

public class DmsServerHit
{
    private  String customerReferenceNumber;
    private  String base64String;

    public String getCustomerReferenceNumber()
    {
        return customerReferenceNumber;
    }

    public void setCustomerReferenceNumber(String customerReferenceNumber)
    {
        this.customerReferenceNumber = customerReferenceNumber;
    }

    public String getBase64String() {
        return base64String;
    }

    public void setBase64String(String base64String) {
        this.base64String = base64String;
    }

    @Override
    public String toString() {
        return "DmsServerHit{" +
                "customerReferenceNumber='" + customerReferenceNumber + '\'' +
                ", base64String='" + base64String + '\'' +
                '}';
    }
}
