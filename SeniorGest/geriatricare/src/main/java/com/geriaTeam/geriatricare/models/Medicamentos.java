package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medicamentos")
public class Medicamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "nomeMedicamento")
    private String name;

    @Column(name = "qtdMedicamento")
    private int quantity;
}
