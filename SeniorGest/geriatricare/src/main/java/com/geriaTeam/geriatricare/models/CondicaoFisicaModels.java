package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "condicoes_fisicas")
public class CondicaoFisicaModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condicoes_fisicas_id")
    private int id;

    @Column(name = "condicoes_fisicas_nome")
    private String nome;

    @Column(name = "condicoes_fisicas_descricao")
    private String descricao;
}
