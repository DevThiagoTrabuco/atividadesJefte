package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import com.senai.Geriatricare.entities.commons.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private String plano;
    private Genero genero;
    private StatusPaciente statusPaciente;
    private int clienteId;
    private List<PrescricaoEntity> prescricoes;
    private List<FamiliarEntity> familiares;

    public PacienteModel toEntity(ClienteModel cliente) {
        PacienteModel paciente = new PacienteModel();
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
