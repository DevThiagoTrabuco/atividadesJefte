package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="funcoes")
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcoes_id")
    private int id;

    @Column(name = "nome")
    private String nome;
}
