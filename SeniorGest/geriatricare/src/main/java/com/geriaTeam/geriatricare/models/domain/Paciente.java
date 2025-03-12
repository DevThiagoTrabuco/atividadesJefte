package com.geriaTeam.geriatricare.models.domain;

import java.util.Date;
import java.util.List;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "nomePaciente")
    private String name;

    @Column(name = "nascPaciente")
    private Date birthDate;

    @Column(name = "entradaPaciente")
    private Date entryDate;

    @Column(name = "condMentalPaciente")
    private String mentalCondition;

    @Column(name = "condFisicaPaciente")
    private String physicalCondition;

    @OneToMany(mappedBy = "paciente")
    private List<PlanoHasPaciente> plans;

    @ManyToMany
    @JoinTable(name = "Paciente_has_Familiar",
            joinColumns = @JoinColumn(name = "Paciente_idPaciente"),
            inverseJoinColumns = @JoinColumn(name = "Familiar_idFamiliar"))
    private List<Familiar> relatives;
}
