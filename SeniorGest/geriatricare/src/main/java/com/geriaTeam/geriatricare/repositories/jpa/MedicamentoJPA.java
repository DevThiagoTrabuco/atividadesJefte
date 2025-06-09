package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoJPA extends JpaRepository<Medicamento, Integer> {
}
