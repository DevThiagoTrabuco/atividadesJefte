package com.senai.Geriatricare.models;

import com.senai.Geriatricare.enums.TipoPlano;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planos")
@Getter
@Setter
public class PlanoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plano_id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoPlano tipo;

    @Column(name = "preco")
    private double preco;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @OneToMany(mappedBy = "planoAssociado")
    private List<PacienteModel> pacientes = new ArrayList<>();
}
