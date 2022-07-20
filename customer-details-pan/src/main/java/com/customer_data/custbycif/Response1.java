package com.customer_data.custbycif;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Response1
{
    private  String status;
    private  String message;
    private List<CustDetailsByCif> custDetailsByCifs;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CustDetailsByCif> getCustDetailsByCifs() {
        return custDetailsByCifs;
    }

    public void setCustDetailsByCifs(List<CustDetailsByCif> custDetailsByCifs) {
        this.custDetailsByCifs = custDetailsByCifs;
    }

    @Override
    public String toString() {
        return "Response1{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", custDetailsByCifs=" + custDetailsByCifs +
                '}';
    }
}
