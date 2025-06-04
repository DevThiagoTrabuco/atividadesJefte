package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {
}
