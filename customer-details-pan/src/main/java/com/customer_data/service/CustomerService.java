package com.customer_data.service;

import com.customer_data.custbycif.CustDetailsByCif;
import com.customer_data.custbycif.GetCustByCif;
import com.customer_data.custbycif.Response1;
import com.customer_data.model.*;

import com.customer_data.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Service
public class CustomerService
{
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    private CustomerDetailsProxy customerDetailsProxy;

    @Autowired
    private GetCustDataByCif getCustDataByCif;

    static  ArrayList<CustDetailsByCif> custDetailsByCifs = new ArrayList<>();

        public Response getDetails (CustomerSearchByPanRequest customerPan)
        {
            String reqXml =  "<input Operation=\"getCustDetailsByPAN(SessionContext,String)\">\n" +
                    "    <SessionContext>\n" +
                    "        <BranchCode>10032</BranchCode>\n" +
                    "        <Channel>IEXCEED</Channel>\n" +
                    "        <ExternalReferenceNo>2017122917071234</ExternalReferenceNo>\n" +
                    "        <SupervisorContext>\n" +
                    "            <UserId>IEXCEED</UserId>\n" +
                    "            <PrimaryPassword>V2VsY29tZUAxMjM=</PrimaryPassword>\n" +
                    "        </SupervisorContext>\n" +
                    "    </SessionContext>\n" +
                    "    <PanNumber>"+customerPan.getPanNumber()+"</PanNumber>\n" +
                    "</input>";
                Response response = new Response();
                ArrayList<CustomerDetails> customerList = new ArrayList<>();
            String resXml = null;
                try {
                     resXml = customerDetailsProxy.getCustomerIdPan(reqXml);
                } catch (Exception ex) {
                    response.setMessage("service unavailable -- unable to cal this request at this moment");
                    response.setStatus("Failed");
                    //response.setStatusCode("2");
                }
            try {
                InputStream inputStream = new ByteArrayInputStream(resXml.getBytes(StandardCharsets.UTF_8));
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(inputStream);
                CustomerDetails customerDetails = new CustomerDetails();

                if (document.getElementsByTagName("ErrorCode") != null && document.getElementsByTagName("ErrorCode").item(0).getTextContent().equals("0")) {
                    int len = document.getElementsByTagName("Record").getLength();

                    for (int i = 0; i < len; i++) {


                        if ((document.getElementsByTagName("CustomerNumber").item(i) != null))
                        {
                            customerDetails.setCustomerNumber(document.getElementsByTagName("CustomerNumber").item(i).getTextContent());
                        }
                       // customerList.add(customerDetails);
                    }
                    response.setStatus("Success");
                    response.setMessage("details retruved sucessfully");
                    response.setCustomerDetails(customerDetails.getCustomerNumber());
                } else {
                    response.setStatus("OK Responnse ");
                    response.setMessage("Failed  Response");
                    response.setCustomerDetails(customerDetails.getCustomerNumber());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            return response;
        }


        public Response1 getDetailsByCif(GetCustByCif custByCif)
        {
                String reqXml ="<input Operation=\"customerDetailsInquiry(SessionContext,String)\">\n" +
                        "    <SessionContext>\n" +
                        "        <BranchCode>10009</BranchCode>\n" +
                        "        <Channel>IEXCEED</Channel>\n" +
                        "        <ExternalReferenceNo>2017122917071234</ExternalReferenceNo>\n" +
                        "        <SupervisorContext>\n" +
                        "            <UserId>IEXCEED</UserId>\n" +
                        "            <PrimaryPassword>V2VsY29tZUAxMjM=</PrimaryPassword>\n" +
                        "        </SupervisorContext>\n" +
                        "    </SessionContext>\n" +
                        "    <Action>CUSTENQ</Action>\n" +
                        "    <Data>"+custByCif.getCifNumber()+"</Data>\n" +
                        "</input>";


                Response1 response1 =new Response1();


                String resXml1= null;

            try {
                resXml1 = getCustDataByCif.getCustDataByPan(reqXml);
            } catch (Exception ex) {
                response1.setMessage("service unavailable -- unable to cal this request at this moment");
                response1.setStatus("Failed");
                //response.setStatusCode("2");
            }

            try {
                CustDetailsByCif custDetailsByCif=new CustDetailsByCif();
                InputStream inputStream = new ByteArrayInputStream(resXml1.getBytes(StandardCharsets.UTF_8));
                DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(inputStream);

                if (document.getElementsByTagName("ErrorCode") != null && document.getElementsByTagName("ErrorCode").item(0).getTextContent().equals("0")) {
                    String details = document.getElementsByTagName("InquiredData").item(0).getTextContent();
                    String newDetails[]=details.split("\\|");
                    custDetailsByCif.setCustomerFullName(newDetails[3]);
                    custDetailsByCif.setMobileNumber(newDetails[10]);
                    custDetailsByCif.setEmailId(newDetails[11]);
                    customerRepo.save(custDetailsByCif);
                    custDetailsByCifs.add(custDetailsByCif);
                    response1.setStatus("Success");
                    response1.setMessage("details retruved sucessfully");
                    response1.setCustDetailsByCifs(custDetailsByCifs);
                } else {
                    response1.setStatus("OK  Response1 ");
                    response1.setMessage("Failed response1");
                    response1.setCustDetailsByCifs(custDetailsByCifs);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return response1;
        }
        public CustDetailsByCif addCustomerInDb(CustDetailsByCif byCif)
        {
            CustDetailsByCif custDetailsByCif =customerRepo.save(byCif);
            return custDetailsByCif;
        }
}
