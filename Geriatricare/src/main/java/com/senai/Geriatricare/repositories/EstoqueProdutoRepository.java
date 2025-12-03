package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.EstoqueProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProdutoModel, Integer> {
}
