package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteMedicamentoJPA extends JpaRepository<PacienteMedicamentoModels, Integer> {
}
