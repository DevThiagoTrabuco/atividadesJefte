package com.senai.Geriatricare.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estoque_medicamento")
@Getter
@Setter
public class EstoqueMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_medicamento_id")
    private int id;

    //private PacienteModel paciente nullable = true;
    //private TipoEstoque tipoEstoque;
    //private ClienteModel paciente;
   //private Produto produto;
    //private int quantidade;
}
