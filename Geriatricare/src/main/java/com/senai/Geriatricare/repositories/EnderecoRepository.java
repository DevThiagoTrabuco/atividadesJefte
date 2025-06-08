package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    EnderecoEntity findByCliente(int clienteId);
    EnderecoEntity findByFamiliar(int clienteId, int familiarId);
    EnderecoEntity findByFuncionario(int clienteId, int funcionarioId);
    List<EnderecoEntity> findByUF(String uf);
    List<EnderecoEntity> findByCidade(String cidade);
}
