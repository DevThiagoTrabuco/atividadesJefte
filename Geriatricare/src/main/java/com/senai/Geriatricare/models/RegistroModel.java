package com.senai.Geriatricare.models;

import com.senai.Geriatricare.enums.Entidade;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "log")
@Getter
@Setter
public class RegistroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private FuncionarioModel funcionario;

    @Enumerated(EnumType.STRING)
    private Entidade entidade;

    @Column(name = "entidade_id", nullable = false)
    private int entidadeId;

    @Column(name = "campo", nullable = false)
    private String campo;

    @Column(name = "valor_antigo")
    private String valorAntigo;

    @Column(name = "valor_novo")
    private String valorNovo;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;
}
