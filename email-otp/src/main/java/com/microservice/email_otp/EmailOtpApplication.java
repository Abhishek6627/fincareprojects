package com.microservice.email_otp;

import com.microservice.email_otp.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailOtpApplication {

	@Autowired
	private MailService mailService;

	public static void main(String[] args)
	{
		SpringApplication.run(EmailOtpApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public  void sendEmail()
	{
		mailService.sendEmail("akaushik6627@gmail.com","this is subject","this is body");
	}

}
