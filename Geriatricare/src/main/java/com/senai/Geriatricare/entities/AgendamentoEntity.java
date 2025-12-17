package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.StatusAgendamento;
import com.senai.Geriatricare.models.AgendamentoModel;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.PacienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoEntity {
    private Integer clienteId;
    private Integer pacienteId;
    private LocalDate data;
    private LocalTime hora;
    private String procedimento;
    private StatusAgendamento statusAgendamento;

    public AgendamentoModel toModel(ClienteModel cliente, PacienteModel paciente) {
        AgendamentoModel agendamento = new AgendamentoModel();
        agendamento.setCliente(cliente);
        agendamento.setPaciente(paciente);
        agendamento.setData(this.data);
        agendamento.setHora(this.hora);
        agendamento.setProcedimento(this.procedimento);
        agendamento.setStatusAgendamento(this.statusAgendamento);
        return agendamento;
    }
}
