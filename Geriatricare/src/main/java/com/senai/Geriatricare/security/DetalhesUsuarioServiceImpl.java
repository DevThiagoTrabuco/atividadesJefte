package com.geriaTeam.geriatricare.security;

import com.geriaTeam.geriatricare.models.UsuarioModel;
import com.geriaTeam.geriatricare.repositories.jpa.UsuarioRepositoryJPA;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DetalhesUsuarioServiceImpl implements UserDetailsService {

    final UsuarioRepositoryJPA userRepository;

    public DetalhesUsuarioServiceImpl(UsuarioRepositoryJPA userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel userModel = userRepository.findByNomeUsuario(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true, true, userModel.getAuthorities());
    }
}
