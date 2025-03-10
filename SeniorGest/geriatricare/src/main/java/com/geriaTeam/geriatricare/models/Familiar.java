package com.geriaTeam.geriatricare.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
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

    public Familiar(UUID id, String name, String phone, String email, List<Paciente> pacients) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.pacients = pacients;

    }

    public Familiar() {

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Paciente> getPacients() {
        return pacients;
    }

    public void setPacients(List<Paciente> pacients) {
        this.pacients = pacients;
    }
}
