package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "familiares")
public class Familiar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "familiares_id")
    private int id;

    @Column(name = "familiares_nome")
    private String nome;

    @Column(name = "familiares_email")
    private String email;

    @Column(name = "familiares_telefone")
    private String telefone;
}
