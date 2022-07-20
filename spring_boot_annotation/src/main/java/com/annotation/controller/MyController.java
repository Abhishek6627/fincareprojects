package com.annotation.controller;

import com.annotation.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//@RestController
@Controller
public class MyController
{

    @Autowired
    @Qualifier("student1")
    private Student student;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @ResponseBody
    //@GetMapping("/home")
    public  Student home(@RequestBody Student sd)
    {
        sd.studying();
        System.out.println("this is home ");
        this.student.setName("Abhishek Kaushik");

        return sd;
    }
}
