package com.validation.controller;

import com.validation.dto.UserRequset;
import com.validation.entity.User;
import com.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController
{

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequset userRequset)
    {
        return new  ResponseEntity<>(userService.saveUser(userRequset), HttpStatus.CREATED);
    }


    @GetMapping("/fetchAll")
    public ResponseEntity<List<User>> getAllUser()
    {
        return  ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/fetchUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id)
    {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
