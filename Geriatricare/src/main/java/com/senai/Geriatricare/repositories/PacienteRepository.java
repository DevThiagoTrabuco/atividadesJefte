package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Integer> {
}
