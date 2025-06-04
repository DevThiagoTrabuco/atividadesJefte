package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteModel {
    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
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
        paciente.setCpf(this.cpf);
        paciente.setRg(this.rg);
        paciente.setEmail(this.email);
        paciente.setDataNascimento(this.dataNascimento);
        paciente.setPlano(this.plano);
        paciente.setGenero(this.genero);
        paciente.setStatusPaciente(this.statusPaciente);
        paciente.setCliente(cliente);

        return paciente;
    }
}
