package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.FamiliarModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FamiliarJPA extends JpaRepository<FamiliarModels, Integer> {
    FamiliarModels findByCpf(String cpf);
    List<FamiliarModels> findByNomeContaining(String nome);

    @Query("SELECT f FROM FamiliarModels f WHERE CONCAT(f.nome, ' ', f.sobrenome) LIKE %:nomeCompleto%")
    List<FamiliarModels> findByNomeCompleto(@Param("nomeCompleto") String nomeCompleto);
}
