package com.jwt.SpringSecuritytest2.controller;

import com.jwt.SpringSecuritytest2.model.Usuario;
import com.jwt.SpringSecuritytest2.repository.IUsuarioRepository;
import com.jwt.SpringSecuritytest2.security.TokenUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("register")
@AllArgsConstructor
public class UserController {
    
    @Autowired
    private final IUsuarioRepository iUsuarioRepository;

    @PostMapping
    void saveUser(@RequestBody Usuario usuario, HttpServletResponse response) {

        String passEncode = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(passEncode);
        iUsuarioRepository.save(usuario);

        String token = TokenUtils.createToken(usuario.getNombre(), usuario.getEmail());

        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("name", usuario.getNombre());
        response.addHeader("email", usuario.getEmail());
        response.addHeader("user", usuario.toString());
    }

}
