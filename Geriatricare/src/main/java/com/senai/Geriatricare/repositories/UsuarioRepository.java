package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.UsuarioEntity;
import com.senai.Geriatricare.enums.Papel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    boolean existsByNomeUsuario(String nomeUsuario);
    UsuarioEntity findByNomeUsuario(String nomeUsuario);
    List<UsuarioEntity> findByPapeis_Papel(Papel papel);
}
