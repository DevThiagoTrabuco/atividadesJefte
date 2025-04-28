package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "beneficios")
public class BeneficioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficio_id")
    private int id;

    @Column(name = "beneficio_descricao")
    private String descricao;

    @OneToMany(mappedBy = "beneficio", cascade = CascadeType.ALL)
    private List<PlanoBeneficioModels> planoBeneficioModels;
}