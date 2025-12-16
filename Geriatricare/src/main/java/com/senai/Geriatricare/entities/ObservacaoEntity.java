package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ObservacaoModel;
import com.senai.Geriatricare.models.PacienteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservacaoEntity {

    private Integer id;
    private String observacao;
    private LocalDateTime dataCriacao;
    private Integer clienteId;
    private Integer pacienteId;

    public ObservacaoModel toModel(ClienteModel cliente, PacienteModel paciente) {
        ObservacaoModel observacaoModel = new ObservacaoModel();
        observacaoModel.setId(this.id);
        observacaoModel.setObservacao(this.observacao);
        observacaoModel.setDataCriacao(this.dataCriacao);
        observacaoModel.setCliente(cliente);
        observacaoModel.setPaciente(paciente);
        return observacaoModel;
    }
}
