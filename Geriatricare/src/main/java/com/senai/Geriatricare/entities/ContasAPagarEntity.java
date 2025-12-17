package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.StatusConta;
import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAPagarModel;
import com.senai.Geriatricare.models.PacienteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContasAPagarEntity {

    private int id;
    private String descricao;
    private String tipoConta;
    private double valor;
    private LocalDate dataVencimento;
    private LocalDate dataEmissao;
    private StatusConta statusConta;
    private Integer pacienteId;
    private Integer clienteId;

    public ContasAPagarModel toModel(PacienteModel paciente, ClienteModel cliente) {
        ContasAPagarModel model = new ContasAPagarModel();
        model.setId(this.id);
        model.setDescricao(this.descricao);
        model.setTipoConta(this.tipoConta);
        model.setValor(this.valor);
        model.setDataVencimento(this.dataVencimento);
        model.setDataEmissao(this.dataEmissao);
        model.setStatusConta(this.statusConta);
        model.setPaciente(paciente);
        model.setCliente(cliente);
        return model;
    }
}
