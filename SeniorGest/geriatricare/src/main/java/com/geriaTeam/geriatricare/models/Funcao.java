package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Funcao")
public class Funcao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "nomeFuncao")
    private String name;

    public Funcao(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Funcao() {
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
}
