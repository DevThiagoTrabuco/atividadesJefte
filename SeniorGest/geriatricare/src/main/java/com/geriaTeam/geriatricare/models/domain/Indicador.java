package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indicadores")
public class Indicador {
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
}
