package com.jwt.SpringSecuritytest2.controller;

import com.jwt.SpringSecuritytest2.model.Contacto;
import com.jwt.SpringSecuritytest2.repository.IContactoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contactos")
@AllArgsConstructor
public class ContactoController {

    private final IContactoRepository iContactoRepository;
    
    @GetMapping
    public List<Contacto> listContacto() {
        return iContactoRepository.findAll();
    }
}
