package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "tipoPlano")
    private String name;

    @Column(name = "descricaoPlano")
    private String description;

    @Column(name = "valorPlano")
    private double value;

    @OneToMany(mappedBy = "plan")
    private List<PlanoHasPaciente> pacients;

    public Plano(UUID id, String name, String description, double value, List<PlanoHasPaciente> pacients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.pacients = pacients;
    }

    public Plano() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<PlanoHasPaciente> getPacients() {
        return pacients;
    }

    public void setPacients(List<PlanoHasPaciente> pacients) {
        this.pacients = pacients;
    }
}
