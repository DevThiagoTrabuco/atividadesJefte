package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FamiliarModel;
import com.senai.Geriatricare.models.FuncionarioModel;
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
    private Integer cliente_id;
    private Integer funcionario_id;
    private Integer admin_id;
    private Integer familiar_id;

    public UsuarioModel toModel() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setId(this.id);
        usuario.setNomeUsuario(this.nomeUsuario);
        usuario.setSenha(this.senha.validaSenha() ? new BCryptPasswordEncoder().encode(this.senha.getSenha()) : null);

        if (this.cliente_id != null) {
            ClienteModel cliente = new ClienteModel();
            cliente.setId(this.cliente_id);
            usuario.setCliente(cliente);
        }

        if (this.funcionario_id != null) {
            FuncionarioModel funcionario = new FuncionarioModel();
            funcionario.setId(this.funcionario_id);
            usuario.setFuncionario(funcionario);
        }

        if (this.admin_id != null) {
            AdminModel admin = new AdminModel();
            admin.setId(this.admin_id);
            usuario.setAdmin(admin);
        }

        if (this.familiar_id != null) {
            FamiliarModel familiar = new FamiliarModel();
            familiar.setId(this.familiar_id);
            usuario.setFamiliar(familiar);
        }

        return usuario;
    }
}
