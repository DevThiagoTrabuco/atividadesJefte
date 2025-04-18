package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteFamiliarJPA extends JpaRepository<PacienteFamiliarModels, Integer> {
}
