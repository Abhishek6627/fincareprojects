package com.sftp.file.response;

import com.sftp.file.model.CustomerDetails;

import java.util.List;

public class Response
{
    private  String Status;
    private  String message;
    private List<CustomerDetails> customerDetails;


    public String getStatus()
    {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CustomerDetails> getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(List<CustomerDetails> customerDetails) {
        this.customerDetails = customerDetails;
    }

    @Override
    public String toString() {
        return "Response{" +
                "Status='" + Status + '\'' +
                ", message='" + message + '\'' +
                ", customerDetails=" + customerDetails +
                '}';
    }
}
