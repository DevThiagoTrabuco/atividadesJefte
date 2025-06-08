package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    boolean existsByEmail(String email);
    FuncionarioEntity findByEmail(int clienteId, String email);
    FuncionarioEntity findByCpf(int clienteId, String cpf);
    FuncionarioEntity findByNome(int clienteId, String nome);
    List<FuncionarioEntity> findByFuncao(int clienteId, String funcao);
}
