package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.UsuarioEntity;
import com.senai.Geriatricare.enums.Papel;
import com.senai.Geriatricare.models.commons.Senha;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioModel {
    private int id;
    private String nomeUsuario;
    private Senha senha;
    private List<Papel> papel;

    public UsuarioEntity toEntity() {
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setId(this.id);
        usuario.setNomeUsuario(this.nomeUsuario);
        usuario.setSenha(this.senha.validaSenha() ? new BCryptPasswordEncoder().encode(this.senha.getSenha()) : null);
        return usuario;
    }
}
