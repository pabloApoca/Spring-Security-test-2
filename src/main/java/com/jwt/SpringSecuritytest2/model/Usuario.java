package com.jwt.SpringSecuritytest2.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;

    private String nombre;
    private String apellido;
    private int dni;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "{" +
                "\"nombre\":" +"\""+ getNombre() +"\""+ "," +
                "\"apellido\":" + "\""+ getApellido() +"\""+ "," +
                "\"email\":" + "\""+ getEmail() +"\""+ "," +
                "\"dni\":" + getDni() +
                "}";
    }
}
