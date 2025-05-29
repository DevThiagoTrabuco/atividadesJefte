package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="funcoes")
public class FuncaoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcoes_id")
    private int id;

    @Column(name = "funcoes_nome")
    private String nome;
}
