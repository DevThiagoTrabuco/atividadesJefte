package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PacienteFamiliarJPA extends JpaRepository<PacienteFamiliarModels, Integer> {

    @Query("SELECT p FROM PacienteFamiliarModels p WHERE p.pacienteId = :pacienteId AND p.familiarId = :familiarId")
    PacienteFamiliarModels buscarPorPacienteIdEFamiliarId(@Param("pacienteId") int pacienteId, @Param("familiarId") int familiarId);
}