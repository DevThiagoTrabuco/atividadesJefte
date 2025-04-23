package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "condicoes_mentais")
public class CondicaoMentalModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condicoes_mentais_id")
    private int id;

    @Column(name = "condicoes_mentais_nome")
    private String nome;

    @Column(name = "condicoes_mentais_descricao")
    private String descricao;
}
