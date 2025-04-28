package com.geriaTeam.geriatricare.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "familiares")
public class FamiliarModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "familiares_id")
    private int id;

    @Column(name = "familiares_nome")
    private String nome;

    @Column(name = "familiares_sobrenome")
    private String sobrenome;

    @Column(name = "familiares_CPF")
    private String cpf;

    @Column(name = "familiares_RG")
    private String rg;

    @Column(name = "familiares_email")
    private String email;

    @Column(name = "familiares_telefone")
    private String telefone;

    @OneToMany(mappedBy = "familiarModels", cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    private List<PacienteFamiliarModels> pacienteFamiliarModels;
}
