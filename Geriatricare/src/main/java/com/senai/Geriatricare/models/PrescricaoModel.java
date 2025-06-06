package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.MedicamentoEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.entities.PrescricaoEntity;
import com.senai.Geriatricare.enums.Posologia;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescricaoModel {
    private int id;
    private int clienteId;
    private int pacienteId;
    private int medicamentoId;
    private Posologia posologia;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public PrescricaoEntity toEntity(ClienteEntity cliente, PacienteEntity paciente, MedicamentoEntity medicamento) {
        PrescricaoEntity prescricao = new PrescricaoEntity();
        prescricao.setId(this.id);
        prescricao.setCliente(cliente);
        prescricao.setPaciente(paciente);
        prescricao.setMedicamento(medicamento);
        prescricao.setPosologia(this.posologia);
        prescricao.setDataInicio(this.dataInicio);
        prescricao.setDataFim(this.dataFim);

        return prescricao;
    }
}
