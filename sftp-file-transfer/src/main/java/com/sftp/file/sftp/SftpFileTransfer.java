package com.sftp.file.sftp;


import com.sftp.file.model.CustSearchByPanNum;
import com.sftp.file.model.CustomerDetails;
import com.sftp.file.proxy.ProxyFeign;
import com.sftp.file.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.ArrayList;

@Service
public class SftpFileTransfer
{
   // SftpFileTransfer sftpFileTransfer = new SftpFileTransfer();
    @Autowired
    private ProxyFeign proxyFeign;
     static ArrayList<String> arr=new ArrayList<>();

    public static void findAllFilesInFolder(File folder)
    {
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                System.out.println(file.getName());
                String a[] = file.getName().split("\\.");
                System.out.println(a[0]);
                arr.add(a[0]);
            } else {
                findAllFilesInFolder(file);
            }
        }
    }

    public static void main(String[] args) throws Exception
    {

        File file= new File("D:\\sftp-test");
       // BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        findAllFilesInFolder(file);
        String st;

//        while ((st= bufferedReader.readLine())!=null)
//            System.out.println(st);


        String s="PAN_2022_07.pdf";
        String a[]=s.split("\\.");
        System.out.println(a[0]);
    }






   public Response getDetails (CustSearchByPanNum custSearchByPanNum)
   {
       String reqXml= "<input Operation=\"getCustDetailsByPAN(SessionContext,String)\">\n" +
               "    <SessionContext>\n" +
               "        <BranchCode>10032</BranchCode>\n" +
               "        <Channel>IEXCEED</Channel>\n" +
               "        <ExternalReferenceNo>2017122917071234</ExternalReferenceNo>\n" +
               "        <SupervisorContext>\n" +
               "            <UserId>IEXCEED</UserId>\n" +
               "            <PrimaryPassword>V2VsY29tZUAxMjM=</PrimaryPassword>\n" +
               "        </SupervisorContext>\n" +
               "    </SessionContext>\n" +
               "    <PanNumber>"+custSearchByPanNum.getPanNumber()+"</PanNumber>\n" +
               "</input>";

       Response response= new Response();

       ArrayList<CustomerDetails> customerList = new ArrayList<>();
       String resXml = null;

       try {
           resXml = proxyFeign.getCustomerIdPan(reqXml);
       }
       catch (Exception ex) {
           response.setMessage("service unavailable -- unable to cal this request at this moment");
           response.setStatus("Failed");
   }
       try {
           InputStream inputStream = new ByteArrayInputStream(resXml.getBytes(StandardCharsets.UTF_8));
           DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
           Document document = documentBuilder.parse(inputStream);

           if (document.getElementsByTagName("ErrorCode") != null && document.getElementsByTagName("ErrorCode").item(0).getTextContent().equals("0")) {
               int len = document.getElementsByTagName("Record").getLength();
               for (int i = 0; i < len; i++) {
                   CustomerDetails customerDetails = new CustomerDetails();

                   if ((document.getElementsByTagName("CustomerNumber").item(i) != null))
                   {
                       customerDetails.setCustomerNumber(document.getElementsByTagName("CustomerNumber").item(i).getTextContent());
                   }
                   customerList.add(customerDetails);
               }
               response.setStatus("Success");
               response.setMessage("details retrived sucessfully");
               response.setCustomerDetails(customerList);
           } else {
               response.setStatus("OK");
               response.setMessage("Failed");
               response.setCustomerDetails(customerList);
           }
       } catch (Exception ex) {
           ex.printStackTrace();
       }

       return response;
   }

   public void  feignCli()
   {
       SftpFileTransfer sftpFileTransfer = new SftpFileTransfer();
        CustSearchByPanNum custSearchByPanNum = new CustSearchByPanNum();
       String  pan ="KYBPS1578C";
        custSearchByPanNum.setPanNumber(pan);
        Response response = sftpFileTransfer.getDetails(custSearchByPanNum);
       System.out.println(response.toString());
       System.out.println("------------------");
   }

}
