package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionarios_id")
    private int id;

    @Column(name = "funcionarios_nome")
    private String nome;

    @Column(name = "funcionarios_nascimento")
    private LocalDateTime nascimento;

    @Column(name = "funcionarios_telefone")
    private int telefone;

    @Column(name = "funcionarios_email")
    private String email;

    @Column(name = "funcionarios_funcao")
    private int funcao;

    public Funcionario() {

    }

    public Funcionario(String nome, LocalDateTime nascimento, int telefone, String email, int funcao) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.email = email;
        this.funcao = funcao;
    }

    public Funcionario(int id, String nome, LocalDateTime nascimento, int telefone, String email, int funcao) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.email = email;
        this.funcao = funcao;
    }
}
