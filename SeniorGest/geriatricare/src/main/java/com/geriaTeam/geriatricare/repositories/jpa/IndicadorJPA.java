package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.Indicador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicadorJPA extends JpaRepository<Indicador, Integer> {
}
