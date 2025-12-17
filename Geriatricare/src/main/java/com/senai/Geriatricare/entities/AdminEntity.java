package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.AdminModel;
import com.senai.Geriatricare.entities.commons.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminEntity {
    private int id;
    private String nome;
    private Email email;
    //Acho que falta senha, mas fica no TODO

    public AdminModel toModel(){
        AdminModel admin = new AdminModel();
        admin.setId(this.id);
        admin.setNome(this.nome);
        admin.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        return admin;
    }
}
