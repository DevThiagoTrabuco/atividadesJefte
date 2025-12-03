package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.EstoqueMedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueMedicamentoRepository extends JpaRepository<EstoqueMedicamentoModel, Integer> {
}
