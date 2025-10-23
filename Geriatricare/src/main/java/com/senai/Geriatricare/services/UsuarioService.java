package com.senai.Geriatricare.services;


import com.senai.Geriatricare.models.PapelModel;
import com.senai.Geriatricare.models.UsuarioModel;
import com.senai.Geriatricare.enums.Papel;
import com.senai.Geriatricare.entities.UsuarioEntity;
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

    public void criarUsuario(UsuarioEntity usuarioEntity) {
        if (usuarioRepository.findByNomeUsuario(usuarioEntity.getNomeUsuario()) != null) {
            throw new IllegalArgumentException("Já existe um usuário com o nome: " + usuarioEntity.getNomeUsuario());
        }
        if (!usuarioEntity.getSenha().validaSenha()) {
            throw new IllegalArgumentException("Senha inválida. A senha deve ter no mínimo 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.");
        }

        List<PapelModel> papeisEntity = usuarioEntity.getPapel().stream().map(papelEnum -> {
            PapelModel papelModel = papelRepository.findByPapel(papelEnum);
            if (papelModel == null) {
                throw new EntityNotFoundException("Papel não encontrado: " + papelEnum.name());
            }
            return papelModel;
        }).toList();

        UsuarioModel usuario = usuarioEntity.toEntity();
        usuario.setPapeis(papeisEntity);

        usuarioRepository.save(usuario);
    }

    public UsuarioEntity buscarUsuarioPorId(int id) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        List<Papel> papeis = usuarioModel.getPapeis().stream()
                .map(PapelModel::getPapel)
                .toList();
        return new UsuarioEntity(usuarioModel.getId(), usuarioModel.getNomeUsuario(), null, papeis);
    }

    public List<UsuarioEntity> listarUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioEntity(usuario.getId(), usuario.getNomeUsuario(), null, Collections.emptyList()))
                .toList();
    }

    public List<UsuarioEntity> listarUsuariosPorPapel(Papel papel) {
        List<UsuarioModel> usuarios = usuarioRepository.findByPapeis_Papel(papel);
        return usuarios.stream()
                .map(usuario -> new UsuarioEntity(usuario.getId(), usuario.getNomeUsuario(), null, Collections.emptyList()))
                .toList();
    }

    public UsuarioEntity buscarUsuarioPorIdEPapel(int id, Papel papel) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        boolean possuiApenasOPapel = usuarioModel.getPapeis().size() == 1 &&
                usuarioModel.getPapeis().getFirst().getPapel() == papel;
        if (!possuiApenasOPapel) {
            throw new EntityNotFoundException("Usuário não possui o papel " + papel.name() + " ou possui múltiplos papéis.");
        }

        return new UsuarioEntity(
                usuarioModel.getId(),
                usuarioModel.getNomeUsuario(),
                null,
                List.of(papel)
        );
    }

    public void atualizarUsuarioPorPapel(int id, UsuarioEntity usuarioEntity, Papel papel) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        boolean possuiApenasOPapel = usuarioModel.getPapeis().size() == 1 &&
                usuarioModel.getPapeis().getFirst().getPapel() == papel;
        if (!possuiApenasOPapel) {
            throw new IllegalArgumentException("Usuário não possui o papel " + papel.name() + " ou possui múltiplos papéis.");
        }

        if (usuarioRepository.existsByNomeUsuario(usuarioEntity.getNomeUsuario()) &&
            !usuarioModel.getNomeUsuario().equals(usuarioEntity.getNomeUsuario())) {
            throw new IllegalArgumentException("Já existe um usuário com o nome: " + usuarioEntity.getNomeUsuario());
        }

        usuarioModel.setNomeUsuario(usuarioEntity.getNomeUsuario());
        if (usuarioEntity.getSenha() != null && usuarioEntity.getSenha().validaSenha()) {
            usuarioModel.setSenha(PasswordEncoder.encode(usuarioEntity.getSenha().getSenha()));
        }

        PapelModel papelModel = papelRepository.findByPapel(papel);
        if (papelModel == null) {
            throw new EntityNotFoundException("Papel não encontrado: " + papel.name());
        }
        usuarioModel.setPapeis(List.of(papelModel));

        usuarioRepository.save(usuarioModel);
    }

    public void deletarUsuario(int id) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        usuarioRepository.delete(usuarioModel);
    }

    public void deletarUsuarioPorPapel(int id, Papel papel) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        boolean possuiApenasOPapel = usuarioModel.getPapeis().size() == 1 &&
                usuarioModel.getPapeis().getFirst().getPapel() == papel;
        if (!possuiApenasOPapel) {
            throw new EntityNotFoundException("Usuário não possui o papel " + papel.name() + " ou possui múltiplos papéis.");
        }

        usuarioRepository.delete(usuarioModel);
    }

    public void alternarStatusUsuario(int id, String status) {
        String statusFormatado = status.toUpperCase();

        if (!statusFormatado.equals("ATIVADO") && !statusFormatado.equals("DESATIVADO")) {
            throw new IllegalArgumentException("Status inválido. Use 'ATIVADO' ou 'DESATIVADO'.");
        }

        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        PapelModel papelAtual = papelRepository.findByPapel(
                usuarioModel.getPapeis().stream()
                        .anyMatch(p -> p.getPapel().equals(Papel.ATIVADO)) ? Papel.ATIVADO : Papel.DESATIVADO
        );

        PapelModel papelAlternativo = papelRepository.findByPapel(
                statusFormatado.equals("ATIVADO") ? Papel.ATIVADO : Papel.DESATIVADO
        );

        if (papelAtual == null || papelAlternativo == null) {
            throw new EntityNotFoundException("Roles ATIVADO ou DESATIVADO não encontradas.");
        }

        List<PapelModel> papeis = usuarioModel.getPapeis();
        if (!papeis.contains(papelAlternativo)) {
            papeis.remove(papelAtual);
            papeis.add(papelAlternativo);
        } else {
            throw new IllegalArgumentException("Usuário já possui o status: " + statusFormatado);
        }

        usuarioModel.setPapeis(papeis);
        usuarioRepository.save(usuarioModel);
    }
}
