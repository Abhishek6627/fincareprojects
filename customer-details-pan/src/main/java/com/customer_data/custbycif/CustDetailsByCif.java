package com.customer_data.custbycif;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustDetailsByCif
{

    @Id
    private String customerFullName;
    private String mobileNumber;
    private String emailId;


//    public CustDetailsByCif() {
//    }
//
//    public CustDetailsByCif(String customerFullName, String emailId, String mobileNumber) {
//        this.customerFullName = customerFullName;
//        this.emailId = emailId;
//        this.mobileNumber = mobileNumber;
//    }


    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    @Override
    public String toString() {
        return "CustDetailsByCif{" +
                "customerFullName='" + customerFullName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}

