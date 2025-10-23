package com.senai.Geriatricare.models;

import com.senai.Geriatricare.enums.TipoConta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "contas_a_pagar")
@Getter
@Setter
public class ContasAPagar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contas_a_pagar_id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    private TipoConta tipoConta;

    @Column(name = "chave_NFE")
    private String chaveNFE;

    @Column(name = "serie_NFE")
    private String serieNFE;

    @Column(name = "valor")
    private double valor;

    @Column(name = "data_vencimento")
    private Date dataVencimento;

}
