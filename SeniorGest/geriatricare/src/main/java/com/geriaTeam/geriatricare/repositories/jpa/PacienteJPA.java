package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteJPA extends JpaRepository<Paciente, Integer>{

}