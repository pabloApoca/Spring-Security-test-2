package com.jwt.SpringSecuritytest2.controller;

import com.jwt.SpringSecuritytest2.model.Usuario;
import com.jwt.SpringSecuritytest2.repository.IUsuarioRepository;
import com.jwt.SpringSecuritytest2.security.AuthCredentials;
import com.jwt.SpringSecuritytest2.security.JWTAuthenticationFilter;
import com.jwt.SpringSecuritytest2.security.UserDetailServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

@RestController
@RequestMapping("register")
@AllArgsConstructor
public class UserController {
    
    @Autowired
    private final IUsuarioRepository iUsuarioRepository;

    @Autowired
    UserDetailServiceImpl service;

    @Autowired
    LoginController loginController;
    
    @PostMapping
    void saveUser(@RequestBody Usuario usuario){

        String passEncode = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(passEncode);
        iUsuarioRepository.save(usuario);

        AuthCredentials authCredentials = new AuthCredentials();
        authCredentials.setEmail(usuario.getEmail());
        authCredentials.setPassword(usuario.getPassword());
        loginController.login(authCredentials);

    }
}
