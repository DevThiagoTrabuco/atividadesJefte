package com.senai.Geriatricare.entities;

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
    @JoinColumn(name = "funcionario_obj", nullable = true)
    private FuncionarioEntity funcionarioObj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_obj", nullable = true)
    private AdminEntity adminObj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_obj", nullable = true)
    private ClienteEntity clienteObj;

    @OneToOne(mappedBy = "clienteObj")
    private ClienteEntity cliente;

    @OneToOne(mappedBy = "funcionarioObj")
    private UsuarioEntity usuario;

    @OneToOne(mappedBy = "adminObj")
    private AdminEntity admin;


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
