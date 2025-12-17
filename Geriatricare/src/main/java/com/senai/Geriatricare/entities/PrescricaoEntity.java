package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ObservacaoModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.models.PrescricaoModel;
import com.senai.Geriatricare.enums.Posologia;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescricaoEntity {
    private int id;
    private int clienteId;
    private int pacienteId;
    private String medicamento;
    private String descricao;
    private Posologia posologia;
    private LocalDate dataInicio;
    private int quantidade;
    private List<ObservacaoEntity> observacoes; // Vira String

    public PrescricaoModel toModel(ClienteModel cliente, PacienteModel paciente) {
        PrescricaoModel prescricao = new PrescricaoModel();
        prescricao.setId(this.id);
        prescricao.setCliente(cliente);
        prescricao.setPaciente(paciente);
        prescricao.setMedicamento(this.medicamento);
        prescricao.setDescricao(this.descricao);
        prescricao.setPosologia(this.posologia);
        prescricao.setDataInicio(this.dataInicio);
        prescricao.setQuantidade(this.quantidade);
        if (this.observacoes != null) {
            prescricao.setObservacoes(this.observacoes.stream().map(obs -> obs.toModel(cliente, paciente)).collect(Collectors.toList()));
        }

        return prescricao;
    }
}
