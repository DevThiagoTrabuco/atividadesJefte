package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ConsultaModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.models.PacienteModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaEntity {
    private Integer clienteId;
    private Integer pacienteId;
    private Integer funcionarioId;
    private LocalDateTime dataConsulta;
    private String observacoes;

    public ConsultaModel toEntity(ClienteModel cliente, PacienteModel paciente, FuncionarioModel funcionario) {
        ConsultaModel consulta = new ConsultaModel();
        consulta.setCliente(cliente);
        consulta.setPaciente(paciente);
        consulta.setFuncionario(funcionario);
        consulta.setDataConsulta(this.dataConsulta);
        consulta.setObservacoes(this.observacoes);
        return consulta;
    }
}
