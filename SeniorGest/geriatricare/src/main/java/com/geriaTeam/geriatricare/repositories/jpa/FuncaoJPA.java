package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncaoJPA extends JpaRepository<Funcao, Integer> {
}
