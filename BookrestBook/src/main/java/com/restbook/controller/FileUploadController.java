package com.restbook.controller;

import com.restbook.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;

@RestController
public class FileUploadController
{
    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file)
    {
//        System.out.println("orginal file name"+file.getOriginalFilename());
//       System.out.println("file size"+file.getSize());
//       System.out.println("file content type"+file.getContentType());
//System.out.println("file name"+file.getName());
       try {


           if (file.isEmpty()) {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must content file");
           }
           //content type

           if (!file.getContentType().equals("image/png")) {
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only png type content are allow");
           }

           //file upload code..
           boolean f = fileUploadHelper.uploadFile(file);
            if (f)
            {
                // return ResponseEntity.ok("file is success uploaded");

                return  ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong try again");
    }
}
