package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.entities.RegistroEntity;
import com.senai.Geriatricare.enums.Entidade;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroModel {
    private int id;
    private int clienteId;
    private int funcionarioId;
    private int entidadeId;
    private Entidade entidade;
    private String campo;
    private String valorAntigo;
    private String valorNovo;
    private LocalDateTime dataHora;

    public RegistroEntity toEntity(ClienteEntity cliente, FuncionarioEntity funcionario) {
        RegistroEntity registro = new RegistroEntity();
        registro.setId(this.id);
        registro.setCliente(cliente);
        registro.setFuncionario(funcionario);
        registro.setEntidade(this.entidade);
        registro.setEntidadeId(this.entidadeId);
        registro.setCampo(this.campo);
        registro.setValorAntigo(this.valorAntigo);
        registro.setValorNovo(this.valorNovo);
        registro.setDataHora(this.dataHora);

        return registro;
    }
}
