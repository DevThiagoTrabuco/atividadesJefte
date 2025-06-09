package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepositoryJPA extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByNomeUsuario(String nomeUsuario);
}
