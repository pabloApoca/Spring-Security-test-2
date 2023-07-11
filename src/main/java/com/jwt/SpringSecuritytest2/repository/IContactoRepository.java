package com.jwt.SpringSecuritytest2.repository;

import com.jwt.SpringSecuritytest2.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactoRepository extends JpaRepository<Contacto, Integer> {
}
