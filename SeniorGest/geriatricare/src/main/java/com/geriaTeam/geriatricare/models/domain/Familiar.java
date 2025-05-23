package com.geriaTeam.geriatricare.models.domain;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "familiar", cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    private List<PacienteFamiliar> pacienteFamiliar;
}
