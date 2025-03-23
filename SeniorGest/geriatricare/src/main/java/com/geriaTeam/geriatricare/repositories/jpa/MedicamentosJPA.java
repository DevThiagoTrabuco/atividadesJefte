package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.Medicamentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentosJPA extends JpaRepository<Medicamentos, Integer> {
}
