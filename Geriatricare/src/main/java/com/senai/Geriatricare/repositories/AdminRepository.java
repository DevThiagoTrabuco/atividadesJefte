package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Integer> {
    boolean existsByEmail(String email);
    AdminModel findByEmail(String email);
    AdminModel findByNome(String nome);
}