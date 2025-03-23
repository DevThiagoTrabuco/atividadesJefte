package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.Historico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoJPA extends JpaRepository<Historico, Integer> {
}
