package com.geriaTeam.geriatricare.models.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medicamentos")
public class Medicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeMedicamento")
    private String name;

    @Column(name = "qtdMedicamento")
    private int quantity;
}
