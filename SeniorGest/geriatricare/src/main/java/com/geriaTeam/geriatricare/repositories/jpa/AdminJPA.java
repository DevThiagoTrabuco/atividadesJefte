package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.AdminModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJPA extends JpaRepository<AdminModels, Integer> {
}
