package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "plano_beneficio")
public class PlanoBeneficioModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plano_beneficio_id")
    private int id;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "plano_id_fk", referencedColumnName = "planos_id")
    private PlanoModels plano;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "beneficio_id_fk", referencedColumnName = "beneficio_id")
    private BeneficioModels beneficio;

    @Column(name = "data_associacao")
    private LocalDateTime dataAssociacao;

    @Column(name = "plano_id_fk", insertable = false, updatable = false)
    private int planoId;

    @Column(name = "beneficio_id_fk", insertable = false, updatable = false)
    private int beneficioId;
}