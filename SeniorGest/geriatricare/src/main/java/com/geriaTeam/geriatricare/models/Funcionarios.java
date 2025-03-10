package com.geriaTeam.geriatricare.models;

import java.sql.Date;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Funcionarios")
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "nomeFuncionario")
    private String name;

    @Column(name = "telefoneFuncionario")
    private String phone;

    @Column(name = "emailFuncionario")
    private String email;

    @Column(name = "nascFuncionario")
    private Date birth;

    @OneToOne
    @JoinColumn(name = "idFuncao")
    private Funcao function;
}
