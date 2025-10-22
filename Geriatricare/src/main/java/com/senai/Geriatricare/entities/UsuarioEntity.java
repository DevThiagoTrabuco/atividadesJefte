package com.senai.Geriatricare.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private int id;

    @ManyToMany
    @JoinTable(name = "usuarios_papeis",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private List<PapelEntity> papeis;

    @Column(name = "nome_usuario", nullable = false, unique = true)
    private String nomeUsuario;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funcionario_id", nullable = true)
    private FuncionarioEntity funcionario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_id", referencedColumnName = "admin_id", nullable = true)
    private AdminEntity admin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", nullable = true)
    private ClienteEntity cliente;

    // Os campos abaixo estavam incorretos ou duplicados e foram removidos.
    // O relacionamento OneToOne deve ser declarado apenas uma vez.
    // O lado "dono" (UsuarioEntity) usa @JoinColumn.
    // O outro lado (AdminEntity) usará "mappedBy".


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.papeis;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nomeUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
