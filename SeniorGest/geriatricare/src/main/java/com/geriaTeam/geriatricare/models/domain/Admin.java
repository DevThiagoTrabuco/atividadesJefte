package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Administrador")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userAdministrador")
    private String user;

    @Column(name = "senhaAdministrador")
    private String password;
}
