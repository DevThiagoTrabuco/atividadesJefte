package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @Column(name = "medicamentos_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "medicamentos_nome")
    private String nome;

    @Column(name = "medicamentos_qtd")
    private int qtd;

    @Column(name="medicamentos_lote")
    private int lote;

    @Column(name="medicamentos_vencimento")
    private Date vencimento;
}
