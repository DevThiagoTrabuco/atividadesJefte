package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.MedicamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<MedicamentoEntity, Integer> {
}
