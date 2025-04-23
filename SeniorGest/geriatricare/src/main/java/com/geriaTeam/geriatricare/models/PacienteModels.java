package com.geriaTeam.geriatricare.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pacientes")
public class PacienteModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pacientes_id")
    private int id;

    @Column(name = "pacientes_nome")
    private String nome;

    @Column(name = "pacientes_sobrenome")
    private String sobrenome;

    @Column(name = "pacientes_CPF")
    private String cpf;

    @Column(name = "pacientes_RG")
    private String rg;

    @Column(name = "pacientes_nascimento")
    private LocalDateTime nascimento;

    @Column(name = "pacientes_entrada")
    private LocalDateTime entrada;

    @Column(name = "pacientes_saida")
    private LocalDateTime saida;

    @ManyToOne
    @JoinColumn(name = "condicoes_mentais_id_fk", referencedColumnName = "condicoes_mentais_id")
    private CondicaoMentalModels condicaoMental;

    @ManyToOne
    @JoinColumn(name = "condicoes_fisicas_id_fk", referencedColumnName = "condicoes_fisicas_id")
    private CondicaoFisicaModels condicaoFisica;


    @OneToMany(mappedBy = "pacienteModels", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PacienteMedicamentoModels> pacienteMedicamentoModels;

    @OneToMany(mappedBy = "pacienteModels", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PacienteFamiliarModels> pacienteFamiliarModels;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "planos_id_fk", referencedColumnName = "planos_id")
    private PlanoModels planoModels;
}
