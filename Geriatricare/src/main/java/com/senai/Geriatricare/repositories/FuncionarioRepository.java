package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
}
