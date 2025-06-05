package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.StatusMedicamento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medicamentos")
@Getter
@Setter
public class MedicamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicamento_id")
    private int id;

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

    @Enumerated(EnumType.STRING)
    private StatusMedicamento statusMedicamento;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL)
    private List<PrescricaoEntity> prescricoes;
}
