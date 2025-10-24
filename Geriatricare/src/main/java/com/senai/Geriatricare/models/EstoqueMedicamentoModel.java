package com.senai.Geriatricare.models;

import com.senai.Geriatricare.enums.TipoEstoque;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estoque_medicamento")
@Getter
@Setter
public class EstoqueMedicamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_medicamento_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_estoque", nullable = false)
    private TipoEstoque tipoEstoque;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModelModel cliente;

    @ManyToOne
    @JoinColumn(name = "medicamento_id", nullable = false)
    private MedicamentoModel medicamento;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonBackReference("paciente-estoque")
    private PacienteModel paciente;

}
