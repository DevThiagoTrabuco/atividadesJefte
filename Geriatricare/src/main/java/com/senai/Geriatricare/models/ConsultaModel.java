package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consultas")
@Getter
@Setter
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consulta_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonBackReference("paciente-consulta")
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    @JsonBackReference("funcionario-consulta")
    private FuncionarioModel funcionario;

    @OneToMany(
            mappedBy = "consulta",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference("consulta-prescricao")
    private List<PrescricaoModel> prescricoes = new ArrayList<>();

    @Column(name = "data_consulta", nullable = false)
    private LocalDateTime dataConsulta;

    @Column(name = "observacoes", nullable = false)
    private String observacoes;
}
