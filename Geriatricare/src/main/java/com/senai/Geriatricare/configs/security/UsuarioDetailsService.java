package com.senai.Geriatricare.configs.security;

import com.senai.Geriatricare.entities.UsuarioEntity;
import com.senai.Geriatricare.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuarioEntity = usuarioRepository.findByNomeUsuario(username);
        if (usuarioEntity == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
        return new User(
                usuarioEntity.getNomeUsuario(),
                usuarioEntity.getSenha(),
                true,
                true,
                true,
                true,
                usuarioEntity.getAuthorities()
        );
    }
}
