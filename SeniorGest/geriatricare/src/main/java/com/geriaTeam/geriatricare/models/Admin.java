package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Administrador")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "userAdministrador")
    private String user;

    @Column(name = "senhaAdministrador")
    private String password;

    public Admin(UUID id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }
    public Admin() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
