package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @Column(name = "medicamentos_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicamentosId;

    @Column(name = "medicamentos_nome")
    private String nome;

    @Column(name = "medicamentos_qtd")
    private int qtdMedicamentos;

    public Medicamento() {

    }

    public Medicamento(String nome, int qtdMedicamentos) {
        this.nome = nome;
        this.qtdMedicamentos = qtdMedicamentos;
    }

    public Medicamento(int medicamentosId, String nome, int qtdMedicamentos) {
        this.medicamentosId = medicamentosId;
        this.nome = nome;
        this.qtdMedicamentos = qtdMedicamentos;
    }
}
