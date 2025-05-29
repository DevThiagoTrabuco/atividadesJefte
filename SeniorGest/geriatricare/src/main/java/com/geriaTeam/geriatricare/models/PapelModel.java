package com.geriaTeam.geriatricare.models;

import com.geriaTeam.geriatricare.enums.PapeisEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "papeis")
public class PapelModel implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private PapeisEnums papeisEnums;

    @Override
    public String getAuthority() {
        return this.papeisEnums.toString();
    }

}
