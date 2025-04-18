package com.geriaTeam.geriatricare.models;

import java.util.Date;

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
    private Date dataAlteracao;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id")
    private PacienteModels pacienteModels;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "funcionarios_id_fk", referencedColumnName = "funcionarios_id")
    private FuncionarioModels funcionarioModels;
}
