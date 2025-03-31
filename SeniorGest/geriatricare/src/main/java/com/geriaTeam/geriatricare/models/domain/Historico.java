package com.geriaTeam.geriatricare.models.domain;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "historicos")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historicos_id")
    private int historicoId;

    @Column(name = "historicos_data_alteracao")
    private Date dataAlteracao;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id")
    private Paciente paciente;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "funcionarios_id_fk", referencedColumnName = "funcionarios_id")
    private Funcionario funcionario;
}
