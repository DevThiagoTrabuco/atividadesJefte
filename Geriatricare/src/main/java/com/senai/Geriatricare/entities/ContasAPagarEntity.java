package com.senai.Geriatricare.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.senai.Geriatricare.entities.commons.CNPJ;
import com.senai.Geriatricare.enums.StatusConta;
import com.senai.Geriatricare.enums.TipoConta;
import com.senai.Geriatricare.models.ContasAPagarModel;
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
    private TipoConta tipoConta;
    private String chaveNFE;
    private String serieNFE;
    @JsonProperty("CNPJ")
    private CNPJ cnpj;
    private double valor;
    private LocalDate dataVencimento;
    private LocalDate dataEmissao;
    private StatusConta statusConta;

    public ContasAPagarModel toModel() {
        if (this.cnpj == null || !this.cnpj.validaCNPJ()) {
            throw new IllegalArgumentException("CNPJ inválido");
        }
        ContasAPagarModel model = new ContasAPagarModel();
        model.setId(this.id);
        model.setDescricao(this.descricao);
        model.setTipoConta(this.tipoConta);
        model.setChaveNFE(this.chaveNFE);
        model.setSerieNFE(this.serieNFE);
        model.setCNPJ(this.cnpj.getCnpj());
        model.setValor(this.valor);
        model.setDataVencimento(this.dataVencimento);
        model.setDataEmissao(this.dataEmissao);
        model.setStatusConta(this.statusConta);
        return model;
    }
}
