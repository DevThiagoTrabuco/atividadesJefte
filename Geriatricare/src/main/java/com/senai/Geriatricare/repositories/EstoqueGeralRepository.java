package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.EstoqueGeralModel;
import com.senai.Geriatricare.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueGeralRepository extends JpaRepository<EstoqueGeralModel, Integer> {

    Optional<EstoqueGeralModel> findByCliente(ClienteModel cliente);

    @Query("SELECT eg FROM EstoqueGeralModel eg JOIN eg.itensEstoque ie WHERE ie.produto = :produto")
    List<EstoqueGeralModel> findByProduto(@Param("produto") ProdutoModel produto);

    @Query("SELECT eg FROM EstoqueGeralModel eg JOIN eg.itensEstoque ie WHERE eg.cliente = :cliente AND ie.produto = :produto")
    List<EstoqueGeralModel> findByClienteAndProduto(@Param("cliente") ClienteModel cliente, @Param("produto") ProdutoModel produto);
}
