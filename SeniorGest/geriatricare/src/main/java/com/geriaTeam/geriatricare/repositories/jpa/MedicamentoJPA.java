package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.MedicamentoModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoJPA extends JpaRepository<MedicamentoModels, Integer> {
}
