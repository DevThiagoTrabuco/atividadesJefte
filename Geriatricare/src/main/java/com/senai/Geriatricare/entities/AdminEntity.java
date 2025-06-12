package com.senai.Geriatricare.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "administradores")
@Getter
@Setter
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<ClienteEntity> clientes;
}
