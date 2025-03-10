package com.geriaTeam.geriatricare.models;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
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

    public Funcionarios(UUID id, String name, String phone, String email, Date birth, Funcao function) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.function = function;
    }

    public Funcionarios() {
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Funcao getFunction() {
        return function;
    }

    public void setFunction(Funcao function) {
        this.function = function;
    }
}
