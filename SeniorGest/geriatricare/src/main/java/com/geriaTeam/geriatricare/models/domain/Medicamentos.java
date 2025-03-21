package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicamentos")
public class Medicamentos {
    @Id
    @Column(name = "medicamentos_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicamentosId;

    @Column(name = "medicamentos_nome")
    private String nome;

    @Column(name = "medicamentos_qtd")
    private int qtdMedicamentos;
}
