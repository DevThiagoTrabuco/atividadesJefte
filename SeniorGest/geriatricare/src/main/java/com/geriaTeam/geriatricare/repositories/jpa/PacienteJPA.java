package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.PacienteModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PacienteJPA extends JpaRepository<PacienteModels, Integer>{
    List<PacienteModels> findByNomeContainingIgnoreCase(String nome);
}