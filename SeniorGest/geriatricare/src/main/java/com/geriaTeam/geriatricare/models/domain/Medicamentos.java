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
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "medicamentos_id")
    private int medicamentos_id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "qtdMedicamentos")
    private int qtdMedicamentos;
}
