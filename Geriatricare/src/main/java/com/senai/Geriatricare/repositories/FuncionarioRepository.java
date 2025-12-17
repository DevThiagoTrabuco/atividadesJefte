package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.enums.Funcao;
import com.senai.Geriatricare.enums.StatusFuncionario;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    boolean existsByEmail(String email);
    FuncionarioModel findByClienteAndEmail(ClienteModel cliente, String email);
    FuncionarioModel findByClienteAndCpf(ClienteModel cliente, String cpf);
    List<FuncionarioModel> findByClienteAndNomeContaining(ClienteModel cliente, String nome);
    List<FuncionarioModel> findByClienteAndFuncao(ClienteModel cliente, Funcao funcao);
    List<FuncionarioModel> findAllByCliente(ClienteModel cliente);
    @Query("SELECT f FROM FuncionarioModel f WHERE f.id = :funcionarioId AND f.cliente.id = :clienteId")
    Optional<FuncionarioModel> findByIdAndClienteId(@Param("funcionarioId") Integer funcionarioId, @Param("clienteId") Integer clienteId);
    List<FuncionarioModel> findAllByClienteAndStatusFuncionario(ClienteModel cliente, StatusFuncionario status);

    @Transactional
    @Modifying
    @Query("UPDATE FuncionarioModel f SET f.statusFuncionario = 'INATIVO' WHERE f.id = :funcionarioId AND f.cliente.id = :clienteId")
    void inativarFuncionario(@Param("funcionarioId") Integer funcionarioId, @Param("clienteId") Integer clienteId);

    @Transactional
    @Modifying
    @Query("UPDATE FuncionarioModel f SET f.statusFuncionario = 'ATIVO' WHERE f.id = :funcionarioId AND f.cliente.id = :clienteId")
    void ativarFuncionario(@Param("funcionarioId") Integer funcionarioId, @Param("clienteId") Integer clienteId);
}
