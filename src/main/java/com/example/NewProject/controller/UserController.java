package com.example.NewProject.controller;

import com.example.NewProject.repository.UserRepository;
import com.example.NewProject.schema.UserInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("api/user/register")
    public UserInfo registerUser(
            @RequestBody UserInfo user
    ){
       return userRepository.save(user);
    }
    @PostMapping("api/user/login")
    public UserInfo login(
            @RequestBody UserInfo user
            )
    {
        UserInfo oldUserInfo = userRepository.findByUserName(user.getUsername());
        if (oldUserInfo != null && oldUserInfo.getPassword().equals(user.getPassword())){
            return oldUserInfo;
        }
        throw new RuntimeException("Your username and password doesn't match any record");
    }
}
