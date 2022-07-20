package com.sftp.file.controller;

import com.sftp.file.model.CustSearchByPanNum;
import com.sftp.file.model.CustomerDetails;
import com.sftp.file.response.Response;
import com.sftp.file.sftp.SftpFileTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private SftpFileTransfer sftpFileTransfer;


    @PostMapping("/getPan")
    public Response getDetails(@RequestBody CustSearchByPanNum custSearchByPanNum)
    {
        return sftpFileTransfer.getDetails(custSearchByPanNum);
    }
}
