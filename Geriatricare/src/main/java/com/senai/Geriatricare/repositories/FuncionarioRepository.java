package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    boolean existsByEmail(String email);
    FuncionarioModel findByClienteAndEmail(ClienteModelModel cliente, String email);
    FuncionarioModel findByClienteAndCpf(ClienteModelModel cliente, String cpf);
    FuncionarioModel findByClienteAndNome(ClienteModelModel cliente, String nome);
    List<FuncionarioModel> findByClienteAndFuncao(ClienteModelModel cliente, String funcao);
}
