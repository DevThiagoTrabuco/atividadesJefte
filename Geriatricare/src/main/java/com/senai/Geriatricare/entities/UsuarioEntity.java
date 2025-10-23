package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.UsuarioModel;
import com.senai.Geriatricare.enums.Papel;
import com.senai.Geriatricare.entities.commons.Senha;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {
    private int id;
    private String nomeUsuario;
    private Senha senha;
    private List<Papel> papel;

    public UsuarioModel toEntity() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setId(this.id);
        usuario.setNomeUsuario(this.nomeUsuario);
        usuario.setSenha(this.senha.validaSenha() ? new BCryptPasswordEncoder().encode(this.senha.getSenha()) : null);
        return usuario;
    }
}
