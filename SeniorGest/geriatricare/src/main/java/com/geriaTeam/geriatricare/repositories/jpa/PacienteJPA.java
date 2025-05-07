package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.PacienteModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PacienteJPA extends JpaRepository<PacienteModels, Integer>{
    List<PacienteModels> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT p FROM PacienteModels p WHERE CONCAT(p.nome, ' ', p.sobrenome) LIKE %:nomeCompleto%")
    List<PacienteModels> findByNomeCompleto(@Param("nomeCompleto") String nomeCompleto);
}