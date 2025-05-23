package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionarios")
public class FuncionarioModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionarios_id")
    private int id;

    @Column(name = "funcionarios_nome")
    private String nome;

    @Column(name = "funcionarios_sobrenome")
    private String sobrenome;

    @Column(name = "funcionarios_CPF")
    private String cpf;

    @Column(name = "funcionarios_RG")
    private String rg;

    @Column(name = "funcionarios_CTPS")
    private String ctps;

    @Column(name = "funcionarios_nascimento")
    private LocalDateTime nascimento;

    @Column(name = "funcionarios_telefone")
    private String telefone;

    @Column(name = "funcionarios_email")
    private String email;


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "funcoes_id_fk", referencedColumnName = "funcoes_id")
    private FuncaoModels funcaoModels;
}
