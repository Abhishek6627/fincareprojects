package com.microservice.email_otp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController
{
    @GetMapping("/mail")
    public  String mail()
    {
        return  "abhi";
    }
}
