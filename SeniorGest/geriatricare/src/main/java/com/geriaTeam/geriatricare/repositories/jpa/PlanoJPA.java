package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanoJPA extends JpaRepository<PlanoModels, Integer> {
    List<PlanoModels> findByNome(String nome);
}
