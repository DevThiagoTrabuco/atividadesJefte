package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.enums.Papel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "papeis")
@Getter
@Setter
public class PapelEntity implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "papel_id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 100)
    private Papel papel;

    @Override
    public String getAuthority() {
        return this.papel.toString();
    }
}
