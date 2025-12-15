package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.AgendamentoModel;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.PacienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoEntity {
    private Integer clienteId;
    private Integer pacienteId;
    private LocalDateTime data;
    private String procedimento;

    public AgendamentoModel toEntity(ClienteModel cliente, PacienteModel paciente) {
        AgendamentoModel agendamento = new AgendamentoModel();
        agendamento.setCliente(cliente);
        agendamento.setPaciente(paciente);
        agendamento.setData(this.data);
        agendamento.setProcedimento(this.procedimento);
        return agendamento;
    }
}
