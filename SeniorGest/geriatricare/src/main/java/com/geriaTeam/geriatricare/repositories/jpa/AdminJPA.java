package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminJPA extends JpaRepository<Admin, Integer> {
}
