package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.EstoqueGeralModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueGeralRepository extends JpaRepository<EstoqueGeralModel, Integer> {
}
