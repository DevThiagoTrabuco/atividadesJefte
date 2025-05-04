package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.FamiliarModels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamiliarJPA extends JpaRepository<FamiliarModels, Integer> {
    FamiliarModels findByCpf(String cpf);
    List<FamiliarModels> findByNomeContaining(String nome);
}
