package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.UsuarioModel;
import com.senai.Geriatricare.enums.Papel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    boolean existsByNomeUsuario(String nomeUsuario);
    UsuarioModel findByNomeUsuario(String nomeUsuario);
    List<UsuarioModel> findByPapeis_Papel(Papel papel);
    UsuarioModel findByIdAndPapeis_Papel(int id, Papel papel);
    Optional<UsuarioModel> findByFuncionarioId(Integer funcionarioId);
    Optional<UsuarioModel> findByAdminId(Integer adminId);
    Optional<UsuarioModel> findByClienteId(Integer clienteId);
    Optional<UsuarioModel> findByFamiliarId(Integer familiarId);
}
