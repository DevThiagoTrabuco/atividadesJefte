package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.FuncionarioModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FuncionarioJPA extends JpaRepository<FuncionarioModels, Integer >{
    @Query("SELECT f FROM FuncionarioModels f WHERE f.email = :email")
    List<FuncionarioModels> buscarPorEmail(@Param("email") String email);
}
