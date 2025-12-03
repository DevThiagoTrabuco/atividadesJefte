package com.senai.Geriatricare.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @JsonManagedReference("cliente-endereco")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private EnderecoModel endereco;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private EstoqueGeralModel estoqueGeral;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private AdminModel admin;

    @JsonProperty("adminId")
    public Integer getAdminId() {
        return admin != null ? admin.getId() : null;
    }

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("cliente-contas-pagar")
    private List<ContasAPagarModel> contasAPagarModel = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("cliente-contas-receber")
    private List<ContasAReceberModel> contasAReceberModel = new ArrayList<>();
}
