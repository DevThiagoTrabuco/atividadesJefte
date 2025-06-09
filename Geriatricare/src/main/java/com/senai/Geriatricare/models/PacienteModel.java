package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import com.senai.Geriatricare.models.commons.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModel {
    private int id;
    private String nome;
    private CPF cpf;
    private RG rg;
    private Email email;
    private String dataNascimento;
    private String plano;
    private Genero genero;
    private StatusPaciente statusPaciente;
    private int clienteId;
    private List<PrescricaoModel> prescricoes;
    private List<FamiliarModel> familiares;

    public PacienteEntity toEntity(ClienteEntity cliente) {
        PacienteEntity paciente = new PacienteEntity();
        paciente.setId(this.id);
        paciente.setNome(this.nome);
        paciente.setCpf(this.cpf.validaCPF() ? this.cpf.getCpf() : null);
        paciente.setRg(this.rg.validaRG() ? this.rg.getRg() : null);
        paciente.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        paciente.setDataNascimento(this.dataNascimento);
        paciente.setPlano(this.plano);
        paciente.setGenero(this.genero);
        paciente.setStatusPaciente(this.statusPaciente);
        paciente.setCliente(cliente);

        return paciente;
    }
}
