package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.Entidade;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registros")
@Getter
@Setter
public class RegistroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private FuncionarioEntity funcionario;

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
