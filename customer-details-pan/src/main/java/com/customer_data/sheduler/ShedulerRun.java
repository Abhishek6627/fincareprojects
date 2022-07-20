package com.customer_data.sheduler;

import com.customer_data.custbycif.CustDetailsByCif;
import com.customer_data.custbycif.GetCustByCif;
import com.customer_data.custbycif.Response1;
import com.customer_data.model.*;
import com.customer_data.repo.CustomerRepo;
import com.customer_data.service.CustomerService;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTextArray;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Component
public class ShedulerRun {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerDetailsProxy detailsProxy;

    @Autowired
    private GetCustDataByCif getCustDataByCif;


    @Autowired
    private  DmsServerApi dmsServerApi;

    @Scheduled(initialDelay = 100, fixedDelay = 30000)
    public void markShed() throws IOException {
        //ArrayList<String> arr = new ArrayList<>();
        File files = new File("D:\\sftp-test");

        for (File file : files.listFiles()) {
            if (!file.isDirectory()) {
                System.out.println(file.getName());
                String a[] = file.getName().split("\\.");
                System.out.println(a[0]);
                //arr.add(a[0]);
                // System.out.println("after arr");
                byte[] bytes = Files.readAllBytes(file.toPath());
                String base64String = Base64.getEncoder().encodeToString(bytes);
             //   System.out.println(base64String);
                //Customer serarch pan



                CustomerSearchByPanRequest customerSearchByPanRequest = new CustomerSearchByPanRequest();
                //System.out.println("after cust search");
                //int i = arr.size();
                String pan = a[0];
                //System.out.println("after pan");
                customerSearchByPanRequest.setPanNumber(pan);
                // System.out.println("set pan");
                Response response = customerService.getDetails(customerSearchByPanRequest);
                System.out.println(response.toString());
                System.out.println("---------------------------------------");
                GetCustByCif getCustByCif = new GetCustByCif();
                getCustByCif.setCifNumber(response.getCustomerDetails());
                Response1 response1 = customerService.getDetailsByCif(getCustByCif);
                System.out.println(response1.toString());
                System.out.println("------------------------");

                dmsServerApi.saveInDms(base64String);

//                if (file.delete()) {
//                    System.out.println("deleted ");
//                } else {
//                    System.out.println("not deleted");
//                }
            }
        }
    }
}

