package com.jwt.SpringSecuritytest2.controller;

import com.jwt.SpringSecuritytest2.security.AuthCredentials;
import com.jwt.SpringSecuritytest2.security.UserDetailServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@AllArgsConstructor
public class LoginController {

    @Autowired
    UserDetailServiceImpl service;

    @PostMapping
    void login(@RequestBody AuthCredentials authCredentials){

    }
}
