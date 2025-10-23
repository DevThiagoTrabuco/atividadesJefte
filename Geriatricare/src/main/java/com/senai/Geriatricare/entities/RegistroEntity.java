package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.models.RegistroModel;
import com.senai.Geriatricare.enums.Entidade;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroEntity {
    private int id;
    private int clienteId;
    private int funcionarioId;
    private int entidadeId;
    private Entidade entidade;
    private String campo;
    private String valorAntigo;
    private String valorNovo;
    private LocalDateTime dataHora;

    public RegistroModel toEntity(ClienteModel cliente, FuncionarioModel funcionario) {
        RegistroModel registro = new RegistroModel();
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
