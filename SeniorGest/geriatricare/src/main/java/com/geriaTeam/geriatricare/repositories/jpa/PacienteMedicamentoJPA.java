package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.PacienteMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteMedicamentoJPA extends JpaRepository<PacienteMedicamento, Integer> {
}
