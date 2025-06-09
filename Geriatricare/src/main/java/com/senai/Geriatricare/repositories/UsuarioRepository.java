package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    UsuarioEntity findByNomeUsuario(String nomeUsuario);
}
