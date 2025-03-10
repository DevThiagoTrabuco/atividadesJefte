package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Sinais_Vitais")
public class SinaisVitais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "frequencia_cardiaca")
    private int heartRate;

    @Column(name = "oximetria")
    private int oximetry;

    @Column(name = "temperatura")
    private double temperature;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente patient;

    public SinaisVitais(UUID id, int heartRate, int oximetry, double temperature, Paciente patient) {
        this.id = id;
        this.heartRate = heartRate;
        this.oximetry = oximetry;
        this.temperature = temperature;
        this.patient = patient;
    }

    public SinaisVitais() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getOximetry() {
        return oximetry;
    }

    public void setOximetry(int oximetry) {
        this.oximetry = oximetry;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public Paciente getPatient() {
        return patient;
    }

    public void setPatient(Paciente patient) {
        this.patient = patient;
    }
}
