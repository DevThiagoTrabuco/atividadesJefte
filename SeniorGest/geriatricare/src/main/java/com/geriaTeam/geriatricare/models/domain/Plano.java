package com.geriaTeam.geriatricare.models.domain;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "planos")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planos_id")
    private int id;

    @Column(name = "planos_nome")
    private String nome;

    @Column(name = "planos_tipo")
    private String tipoPlano;

    @OneToMany(mappedBy = "planos", cascade = CascadeType.ALL)
    private List<Paciente> pacientes;
}
