package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Sinais_Vitais")
public class SinaisVitais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "frequencia_cardiaca")
    private int heartRate;

    @Column(name = "oximetria")
    private int oximetry;

    @Column(name = "temperatura")
    private double temperature;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente patient;
}
