package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estoques_pacientes")
@Getter
@Setter
public class EstoquePacienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_paciente_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false, unique = true)
    private PacienteModel paciente;

    @OneToMany(mappedBy = "estoquePaciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("estoque-paciente-medicamentos")
    private List<EstoqueMedicamentoModel> itensEstoqueMedicamento = new ArrayList<>();

    @OneToMany(mappedBy = "estoquePaciente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("estoque-paciente-produtos")
    private List<EstoqueProdutoModel> itensEstoqueProduto = new ArrayList<>();
}
