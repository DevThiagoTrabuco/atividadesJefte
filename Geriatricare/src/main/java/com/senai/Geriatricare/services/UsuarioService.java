package com.senai.Geriatricare.services;


import com.senai.Geriatricare.entities.PapelEntity;
import com.senai.Geriatricare.entities.UsuarioEntity;
import com.senai.Geriatricare.enums.Papel;
import com.senai.Geriatricare.models.UsuarioModel;
import com.senai.Geriatricare.repositories.PapelRepository;
import com.senai.Geriatricare.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PapelRepository papelRepository;
    private final PasswordEncoder PasswordEncoder;


    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PapelRepository papelRepository, PasswordEncoder PasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.papelRepository = papelRepository;
        this.PasswordEncoder = PasswordEncoder;
    }

    public void criarUsuario(UsuarioModel usuarioModel) {
        if (usuarioRepository.findByNomeUsuario(usuarioModel.getNomeUsuario()) != null) {
            throw new IllegalArgumentException("Já existe um usuário com o nome: " + usuarioModel.getNomeUsuario());
        }
        if (!usuarioModel.getSenha().validaSenha()) {
            throw new IllegalArgumentException("Senha inválida. A senha deve ter no mínimo 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.");
        }

        List<PapelEntity> papeisEntity = usuarioModel.getPapel().stream().map(papelEnum -> {
            PapelEntity papelEntity = papelRepository.findByPapel(papelEnum);
            if (papelEntity == null) {
                throw new EntityNotFoundException("Papel não encontrado: " + papelEnum.name());
            }
            return papelEntity;
        }).toList();

        UsuarioEntity usuario = usuarioModel.toEntity();
        usuario.setPapeis(papeisEntity);

        usuarioRepository.save(usuario);
    }

    public UsuarioModel buscarUsuarioPorId(int id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        List<Papel> papeis = usuarioEntity.getPapeis().stream()
                .map(PapelEntity::getPapel)
                .toList();
        return new UsuarioModel(usuarioEntity.getId(), usuarioEntity.getNomeUsuario(), null, papeis);
    }

    public List<UsuarioModel> listarUsuarios() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioModel(usuario.getId(), usuario.getNomeUsuario(), null, Collections.emptyList()))
                .toList();
    }

    public List<UsuarioModel> listarUsuariosPorPapel(Papel papel) {
        List<UsuarioEntity> usuarios = usuarioRepository.findByPapeis_Papel(papel);
        return usuarios.stream()
                .map(usuario -> new UsuarioModel(usuario.getId(), usuario.getNomeUsuario(), null, Collections.emptyList()))
                .toList();
    }

    public UsuarioModel buscarUsuarioPorIdEPapel(int id, Papel papel) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        boolean possuiApenasOPapel = usuarioEntity.getPapeis().size() == 1 &&
                usuarioEntity.getPapeis().getFirst().getPapel() == papel;
        if (!possuiApenasOPapel) {
            throw new EntityNotFoundException("Usuário não possui o papel " + papel.name() + " ou possui múltiplos papéis.");
        }

        return new UsuarioModel(
                usuarioEntity.getId(),
                usuarioEntity.getNomeUsuario(),
                null,
                List.of(papel)
        );
    }

    public void atualizarUsuarioPorPapel(int id, UsuarioModel usuarioModel, Papel papel) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        boolean possuiApenasOPapel = usuarioEntity.getPapeis().size() == 1 &&
                usuarioEntity.getPapeis().getFirst().getPapel() == papel;
        if (!possuiApenasOPapel) {
            throw new IllegalArgumentException("Usuário não possui o papel " + papel.name() + " ou possui múltiplos papéis.");
        }

        if (usuarioRepository.existsByNomeUsuario(usuarioModel.getNomeUsuario()) &&
            !usuarioEntity.getNomeUsuario().equals(usuarioModel.getNomeUsuario())) {
            throw new IllegalArgumentException("Já existe um usuário com o nome: " + usuarioModel.getNomeUsuario());
        }

        usuarioEntity.setNomeUsuario(usuarioModel.getNomeUsuario());
        if (usuarioModel.getSenha() != null && usuarioModel.getSenha().validaSenha()) {
            usuarioEntity.setSenha(PasswordEncoder.encode(usuarioModel.getSenha().getSenha()));
        }

        PapelEntity papelEntity = papelRepository.findByPapel(papel);
        if (papelEntity == null) {
            throw new EntityNotFoundException("Papel não encontrado: " + papel.name());
        }
        usuarioEntity.setPapeis(List.of(papelEntity));

        usuarioRepository.save(usuarioEntity);
    }

    public void deletarUsuario(int id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        usuarioRepository.delete(usuarioEntity);
    }

    public void deletarUsuarioPorPapel(int id, Papel papel) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        boolean possuiApenasOPapel = usuarioEntity.getPapeis().size() == 1 &&
                usuarioEntity.getPapeis().getFirst().getPapel() == papel;
        if (!possuiApenasOPapel) {
            throw new EntityNotFoundException("Usuário não possui o papel " + papel.name() + " ou possui múltiplos papéis.");
        }

        usuarioRepository.delete(usuarioEntity);
    }

    public void alternarStatusUsuario(int id, String status) {
        String statusFormatado = status.toUpperCase();

        if (!statusFormatado.equals("ATIVADO") && !statusFormatado.equals("DESATIVADO")) {
            throw new IllegalArgumentException("Status inválido. Use 'ATIVADO' ou 'DESATIVADO'.");
        }

        UsuarioEntity usuarioEntity = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        PapelEntity papelAtual = papelRepository.findByPapel(
                usuarioEntity.getPapeis().stream()
                        .anyMatch(p -> p.getPapel().equals(Papel.ATIVADO)) ? Papel.ATIVADO : Papel.DESATIVADO
        );

        PapelEntity papelAlternativo = papelRepository.findByPapel(
                statusFormatado.equals("ATIVADO") ? Papel.ATIVADO : Papel.DESATIVADO
        );

        if (papelAtual == null || papelAlternativo == null) {
            throw new EntityNotFoundException("Roles ATIVADO ou DESATIVADO não encontradas.");
        }

        List<PapelEntity> papeis = usuarioEntity.getPapeis();
        if (!papeis.contains(papelAlternativo)) {
            papeis.remove(papelAtual);
            papeis.add(papelAlternativo);
        } else {
            throw new IllegalArgumentException("Usuário já possui o status: " + statusFormatado);
        }

        usuarioEntity.setPapeis(papeis);
        usuarioRepository.save(usuarioEntity);
    }
}
