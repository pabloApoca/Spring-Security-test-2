package com.jwt.SpringSecuritytest2.repository;

import com.jwt.SpringSecuritytest2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
