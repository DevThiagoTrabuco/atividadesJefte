package com.geriaTeam.geriatricare.models;

import java.time.LocalDateTime;

import com.geriaTeam.geriatricare.entities.Funcionario;
import com.geriaTeam.geriatricare.entities.Paciente;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historicos")
public class HistoricoModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historicos_id")
    private int historicoId;

    @Column(name = "historicos_data_alteracao")
    private LocalDateTime dataAlteracao;

    @Column(name = "historicos_ocorrencia")
    private String ocorrencia;

    @Column(name = "historicos_observacao")
    private String observacao;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id")
    private Paciente paciente;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "funcionarios_id_fk", referencedColumnName = "funcionarios_id")
    private Funcionario funcionario;
}
