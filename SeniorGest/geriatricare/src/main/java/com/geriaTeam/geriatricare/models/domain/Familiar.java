package com.geriaTeam.geriatricare.models.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Familiar")
public class Familiar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "nomeFamiliar")
    private String name;

    @Column(name = "telefoneFamiliar")
    private String phone;

    @Column(name = "emailFamiliar")
    private String email;

    @ManyToMany(mappedBy = "familiares")
    private List<Paciente> pacients;


}
