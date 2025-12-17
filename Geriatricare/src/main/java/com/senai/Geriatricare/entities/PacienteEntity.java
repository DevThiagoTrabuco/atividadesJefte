package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.entities.commons.CPF;
import com.senai.Geriatricare.entities.commons.Email;
import com.senai.Geriatricare.entities.commons.RG;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteEntity {
    private int id;
    private String nome;
    private CPF cpf;
    private RG rg;
    private Email email;
    private LocalDate dataNascimento;
    private Genero genero;
    private StatusPaciente statusPaciente;
    private Integer clienteId;
    private List<ObservacaoEntity> observacoes;
    private List<FamiliarEntity> familiares;

    public PacienteModel toModel(ClienteModel cliente) {
        PacienteModel paciente = new PacienteModel();
        paciente.setId(this.id);
        paciente.setNome(this.nome);
        paciente.setCpf(this.cpf.validaCPF() ? this.cpf.getCpf() : null);
        paciente.setRg(this.rg.validaRG() ? this.rg.getRg() : null);
        paciente.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        paciente.setDataNascimento(this.dataNascimento);
        paciente.setGenero(this.genero);
        paciente.setStatusPaciente(this.statusPaciente);
        if (this.observacoes != null) {
            paciente.setObservacoes(this.observacoes.stream().map(obs -> obs.toModel(cliente, paciente)).collect(Collectors.toList()));
        }
        paciente.setCliente(cliente);

        return paciente;
    }
}
