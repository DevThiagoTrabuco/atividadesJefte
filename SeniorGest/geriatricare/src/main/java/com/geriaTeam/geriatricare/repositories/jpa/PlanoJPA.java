package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoJPA extends JpaRepository<PlanoModels, Integer> {
}
