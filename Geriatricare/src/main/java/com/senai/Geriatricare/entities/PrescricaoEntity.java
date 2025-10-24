package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.MedicamentoModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.models.PrescricaoModel;
import com.senai.Geriatricare.enums.Posologia;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrescricaoEntity {
    private int id;
    private int clienteId;
    private int pacienteId;
    private int medicamentoId;
    private Posologia posologia;
    private LocalDate dataInicio;
    private int quantidade;

    public PrescricaoModel toEntity(ClienteModelModel cliente, PacienteModel paciente, MedicamentoModel medicamento) {
        PrescricaoModel prescricao = new PrescricaoModel();
        prescricao.setId(this.id);
        prescricao.setCliente(cliente);
        prescricao.setPaciente(paciente);
        prescricao.setMedicamento(medicamento);
        prescricao.setPosologia(this.posologia);
        prescricao.setDataInicio(this.dataInicio);
        prescricao.setQuantidade(this.quantidade);

        return prescricao;
    }
}
