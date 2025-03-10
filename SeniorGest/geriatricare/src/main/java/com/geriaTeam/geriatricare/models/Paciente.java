package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
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

    public Paciente(UUID id, String name, Date birthDate, Date entryDate, String mentalCondition, String physicalCondition, List<PlanoHasPaciente> plans, List<Familiar> relatives) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.entryDate = entryDate;
        this.mentalCondition = mentalCondition;
        this.physicalCondition = physicalCondition;
        this.plans = plans;
        this.relatives = relatives;
    }

    public Paciente() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getMentalCondition() {
        return mentalCondition;
    }

    public void setMentalCondition(String mentalCondition) {
        this.mentalCondition = mentalCondition;
    }

    public String getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(String physicalCondition) {
        this.physicalCondition = physicalCondition;
    }

    public List<PlanoHasPaciente> getPlans() {
        return plans;
    }

    public void setPlans(List<PlanoHasPaciente> plans) {
        this.plans = plans;
    }

    public List<Familiar> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Familiar> relatives) {
        this.relatives = relatives;
    }
}
