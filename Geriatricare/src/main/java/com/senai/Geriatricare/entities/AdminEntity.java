package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.entities.commons.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {
    private int id;
    private String nome;
    private Email email;
    private List<ClienteModel> clientes;

    public AdminModel toEntity(){
        AdminModel admin = new AdminModel();
        admin.setId(this.id);
        admin.setNome(this.nome);
        admin.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        return admin;
    }
}
