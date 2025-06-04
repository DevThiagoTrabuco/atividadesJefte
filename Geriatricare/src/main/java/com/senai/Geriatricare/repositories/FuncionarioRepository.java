package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
}
