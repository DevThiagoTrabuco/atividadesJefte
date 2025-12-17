package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAPagarModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.models.PlanoModel;
import com.senai.Geriatricare.enums.Genero;
import com.senai.Geriatricare.enums.StatusPaciente;
import com.senai.Geriatricare.entities.commons.*;
import lombok.*;

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
    private String plano; // Desnecessário
    private PlanoModel planoAssociado; // Desnecessário
    private Genero genero;
    private StatusPaciente statusPaciente;
    private ClienteModel cliente; // Pq não clienteId como FK?
    private List<ObservacaoEntity> observacoes;
    private List<ContasAPagarModel> contasAPagar; // Desnecessário
    private List<PrescricaoEntity> prescricoes;
    private List<FamiliarEntity> familiares;

    public PacienteModel toModel(ClienteModel cliente) {
        PacienteModel paciente = new PacienteModel();
        paciente.setId(this.id);
        paciente.setNome(this.nome);
        paciente.setCpf(this.cpf.validaCPF() ? this.cpf.getCpf() : null);
        paciente.setRg(this.rg.validaRG() ? this.rg.getRg() : null);
        paciente.setEmail(this.email.validaEmail() ? this.email.getEmail() : null);
        paciente.setDataNascimento(this.dataNascimento);
        paciente.setPlano(this.plano);
        paciente.setPlanoAssociado(this.planoAssociado);
        paciente.setGenero(this.genero);
        paciente.setStatusPaciente(this.statusPaciente);
        if (this.observacoes != null) {
            paciente.setObservacoes(this.observacoes.stream().map(obs -> obs.toModel(cliente, paciente)).collect(Collectors.toList()));
        }
        if (this.contasAPagar != null) {
            this.contasAPagar.forEach(c -> c.setPaciente(paciente));
            paciente.setContasAPagar(this.contasAPagar);
        }
        paciente.setCliente(cliente);

        return paciente;
    }
}
