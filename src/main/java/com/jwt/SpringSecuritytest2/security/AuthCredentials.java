package com.jwt.SpringSecuritytest2.security;

import lombok.Data;

@Data
public class AuthCredentials {

    private String email;
    private String password;
}
