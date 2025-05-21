package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "administradores")
public class AdminModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "administradores_id")
    private int id;

    @Column(name = "administradores_nome")
    private String nome;

    @Column(name = "administradores_senha")
    private String senha;
}
