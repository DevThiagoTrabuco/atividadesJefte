package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}
