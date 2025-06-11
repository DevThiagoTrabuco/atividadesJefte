package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.AdminEntity;
import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.models.commons.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminModel {
    private int id;
    private String nome;
    private Email email;
    private List<ClienteEntity> clientes;

    public AdminEntity toEntity(){
        AdminEntity admin = new AdminEntity();
        admin.setId(this.id);
        admin.setNome(this.nome);
        admin.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        return admin;
    }
}
