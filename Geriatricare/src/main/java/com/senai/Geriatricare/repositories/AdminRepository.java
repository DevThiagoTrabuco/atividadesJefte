package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    boolean existsByEmail(String email);
}