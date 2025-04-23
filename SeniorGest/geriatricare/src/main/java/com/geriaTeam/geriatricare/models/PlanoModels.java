package com.geriaTeam.geriatricare.models;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "planos")
public class PlanoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planos_id")
    private int id;

    @Column(name = "planos_nome")
    private String nome;

    @Column(name = "planos_tipo")
    private String tipoPlano;
}
