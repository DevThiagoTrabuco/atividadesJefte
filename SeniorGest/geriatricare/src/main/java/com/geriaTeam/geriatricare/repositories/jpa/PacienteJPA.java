package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.PacienteModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteJPA extends JpaRepository<PacienteModels, Integer>{

}