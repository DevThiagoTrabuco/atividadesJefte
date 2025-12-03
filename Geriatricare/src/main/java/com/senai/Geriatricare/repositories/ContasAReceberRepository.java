package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ContasAReceberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAReceberRepository extends JpaRepository<ContasAReceberModel, Integer> {
}
