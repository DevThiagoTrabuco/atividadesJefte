package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    boolean existsByEmail(String email);
}