package com.senai.Geriatricare.models;

import com.senai.Geriatricare.enums.StatusMedicamento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medicamentos")
@Getter
@Setter
public class MedicamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicamento_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @Column(name = "nome_comercial")
    private String nomeComercial;

    @Column(name = "nome_generico", nullable = false)
    private String nomeGenerico;

    @Column(name = "dosagem", nullable = false)
    private String dosagem;

    @Column(name = "lote", nullable = false)
    private  String lote;

    @Column(name = "data_validade", nullable = false)
    private LocalDate dataValidade;

    //@Enumerated(EnumType.STRING)
    //private StatusMedicamento statusMedicamento;

    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL)
    private List<PrescricaoModel> prescricoes;
}
