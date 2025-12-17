package com.senai.Geriatricare.configs.security;

import com.senai.Geriatricare.models.UsuarioModel;
import com.senai.Geriatricare.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
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
        UsuarioModel usuarioModel = usuarioRepository.findByNomeUsuario(username);
        if (usuarioModel == null) {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
        return new User(
                usuarioModel.getNomeUsuario(),
                usuarioModel.getSenha(),
                true,
                true,
                true,
                true,
                usuarioModel.getAuthorities()
        );
    }
}
