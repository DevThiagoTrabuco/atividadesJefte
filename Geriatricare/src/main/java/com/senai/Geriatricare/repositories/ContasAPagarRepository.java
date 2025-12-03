package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ContasAPagarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAPagarRepository extends JpaRepository<ContasAPagarModel, Integer> {
}
