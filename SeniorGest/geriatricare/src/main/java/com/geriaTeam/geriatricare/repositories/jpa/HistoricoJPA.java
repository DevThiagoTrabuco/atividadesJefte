package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.HistoricoModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoJPA extends JpaRepository<HistoricoModels, Integer> {
}
