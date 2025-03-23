package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.Familiar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliarJPA extends JpaRepository<Familiar, Integer> {
}
