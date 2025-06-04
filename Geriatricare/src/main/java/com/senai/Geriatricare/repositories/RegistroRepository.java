package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {
}
