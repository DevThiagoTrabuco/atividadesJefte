package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    boolean existsByEmail(String email);
    FuncionarioEntity findByClienteAndEmail(ClienteEntity cliente, String email);
    FuncionarioEntity findByClienteAndCpf(ClienteEntity cliente, String cpf);
    FuncionarioEntity findByClienteAndNome(ClienteEntity cliente, String nome);
    List<FuncionarioEntity> findByClienteAndFuncao(ClienteEntity cliente, String funcao);
}
