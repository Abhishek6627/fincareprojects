package com.validation.service;

import com.validation.dto.UserRequset;
import com.validation.entity.User;
import com.validation.exception.UserNotFoundException;
import com.validation.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(UserRequset userRequset) {
        User user = User.build(0, userRequset.getName(), userRequset.getEmail(), userRequset.getMobile(), userRequset.getGender(), userRequset.getAge(), userRequset.getNationality());
        return userRepository.save(user);
    }

    public List<User> getAllUser()
    {
        return  userRepository.findAll();
    }

    public User getUser(int id)
    {
       User user= userRepository.findByUserId(id);
       if (user!=null)
       {
           return  user;
       }
       else
           throw  new UserNotFoundException("user not found with id "+id);
    }

}
