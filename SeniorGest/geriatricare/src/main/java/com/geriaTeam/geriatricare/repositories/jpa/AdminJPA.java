package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.AdminModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminJPA extends JpaRepository<AdminModels, Integer> {
    @Query("SELECT a FROM AdminModels a WHERE a.email = :email")
    List<AdminModels> buscarPorEmail(@Param("email") String email);
}
