package com.geriaTeam.geriatricare.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicamentos")
public class MedicamentoModels {
    @Id
    @Column(name = "medicamentos_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "medicamentos_nome")
    private String nome;

    @Column(name="medicamentos_lote")
    private String lote;

    @Column(name = "medicamentos_quantidade")
    private int quantidade;

    @Column(name="medicamentos_vencimento")
    private LocalDateTime vencimento;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "medicamentoModels", cascade = {CascadeType.PERSIST, CascadeType. MERGE})
    private List<PacienteMedicamentoModels> pacienteMedicamentoModels;

}
