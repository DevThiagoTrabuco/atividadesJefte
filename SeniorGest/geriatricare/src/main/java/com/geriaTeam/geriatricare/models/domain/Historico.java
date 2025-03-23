package com.geriaTeam.geriatricare.models.domain;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "historicos")
public class Historico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historicos_id")
    private int historicoId;

    @Column(name = "historicos_data_alteracao")
    private Date dataAlteracao;

    public Historico() {

    }

    public Historico(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Historico(int historicoId, Date dataAlteracao) {
        this.historicoId = historicoId;
        this.dataAlteracao = dataAlteracao;
    }
}
