package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Integer> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    boolean existsByEmail(String email);
    FuncionarioModel findByClienteAndEmail(ClienteModel cliente, String email);
    FuncionarioModel findByClienteAndCpf(ClienteModel cliente, String cpf);
    FuncionarioModel findByClienteAndNome(ClienteModel cliente, String nome);
    List<FuncionarioModel> findByClienteAndFuncao(ClienteModel cliente, String funcao);
}
