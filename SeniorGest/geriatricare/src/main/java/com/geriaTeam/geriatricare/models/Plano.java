package com.geriaTeam.geriatricare.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table (name = "Plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipoPlano")
    private String name;

    @Column(name = "descricaoPlano")
    private String description;

    @Column(name = "valorPlano")
    private double value;

    @OneToMany(mappedBy = "plano")
    private List<PlanoHasPaciente> pacients;
}
