package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ConsultaModel;
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
    private int consultaId; // Adicionado
    private String medicamento;
    private Posologia posologia;
    private LocalDate dataInicio;
    private int quantidade;

    public PrescricaoModel toModel(ClienteModel cliente, PacienteModel paciente, ConsultaModel consulta) { // Modificado
        PrescricaoModel prescricao = new PrescricaoModel();
        prescricao.setId(this.id);
        prescricao.setCliente(cliente);
        prescricao.setPaciente(paciente);
        prescricao.setConsulta(consulta); // Adicionado
        prescricao.setMedicamento(this.medicamento);
        prescricao.setPosologia(this.posologia);
        prescricao.setDataInicio(this.dataInicio);
        prescricao.setQuantidade(this.quantidade);

        return prescricao;
    }
}
