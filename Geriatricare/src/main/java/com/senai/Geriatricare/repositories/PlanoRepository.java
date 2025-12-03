package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.PlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoModel, Integer> {
}
