package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.CondicaoFisicaModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CondicaoFisicaJPA extends JpaRepository<CondicaoFisicaModels, Integer> {
    @Query("SELECT c FROM CondicaoFisicaModels c WHERE c.nome = :nome")
    List<CondicaoFisicaModels> findByNome(@Param("nome") String nome);
}
