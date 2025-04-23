package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indicadores")
public class IndicadorModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "indicadores_id")
    private int id;

    @Column(name = "indicadores_batimentos")
    private int batimentos;

    @Column(name = "indicadores_oximetria")
    private int oximetria;

    @Column(name = "indicadores_temperatura")
    private int temperatura;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    @JoinColumn(name = "pacientes_id_fk", referencedColumnName = "pacientes_id")
    private PacienteModels pacienteModels;
}
