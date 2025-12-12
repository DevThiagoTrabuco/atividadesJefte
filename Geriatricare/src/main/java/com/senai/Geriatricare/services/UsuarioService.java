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
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PapelRepository papelRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PapelRepository papelRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.papelRepository = papelRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void criarUsuario(UsuarioEntity usuarioEntity) {
        if (usuarioRepository.findByNomeUsuario(usuarioEntity.getNomeUsuario()) != null) {
            throw new IllegalArgumentException("Já existe um usuário com o nome: " + usuarioEntity.getNomeUsuario());
        }
        if (usuarioEntity.getSenha() == null || !usuarioEntity.getSenha().validaSenha()) {
            throw new IllegalArgumentException("Senha inválida. A senha deve ter no mínimo 8 caracteres, incluindo letras maiúsculas, minúsculas, números e caracteres especiais.");
        }

        List<PapelModel> papeisEntity = usuarioEntity.getPapel().stream().map(papelEnum -> {
            PapelModel papelModel = papelRepository.findByPapel(papelEnum);
            if (papelModel == null) {
                throw new EntityNotFoundException("Papel não encontrado: " + papelEnum.name());
            }
            return papelModel;
        }).collect(Collectors.toList());

        UsuarioModel usuario = usuarioEntity.toEntity();
        usuario.setSenha(passwordEncoder.encode(usuarioEntity.getSenha().getSenha()));
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
        UsuarioModel usuarioModel = usuarioRepository.findByIdAndPapeis_Papel(id, papel);
        if (usuarioModel == null) {
            throw new EntityNotFoundException("Usuário " + papel.name() + " não encontrado com ID: " + id);
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

        boolean possuiPapel = usuarioModel.getPapeis().stream().anyMatch(p -> p.getPapel() == papel);
        if (!possuiPapel) {
            throw new IllegalArgumentException("Usuário não possui o papel " + papel.name());
        }

        if (usuarioRepository.existsByNomeUsuario(usuarioEntity.getNomeUsuario()) &&
            !usuarioModel.getNomeUsuario().equals(usuarioEntity.getNomeUsuario())) {
            throw new IllegalArgumentException("Já existe um usuário com o nome: " + usuarioEntity.getNomeUsuario());
        }

        usuarioModel.setNomeUsuario(usuarioEntity.getNomeUsuario());
        if (usuarioEntity.getSenha() != null && usuarioEntity.getSenha().validaSenha()) {
            usuarioModel.setSenha(passwordEncoder.encode(usuarioEntity.getSenha().getSenha()));
        }

        // Preserve existing roles and only update the ones provided
        List<Papel> novosPapeisEnum = usuarioEntity.getPapel();
        if (novosPapeisEnum != null && !novosPapeisEnum.isEmpty()) {
            List<PapelModel> novosPapeis = novosPapeisEnum.stream()
                    .map(papelRepository::findByPapel)
                    .collect(Collectors.toList());
            usuarioModel.setPapeis(novosPapeis);
        }

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

        boolean possuiPapel = usuarioModel.getPapeis().stream().anyMatch(p -> p.getPapel() == papel);
        if (!possuiPapel) {
            throw new EntityNotFoundException("Usuário não possui o papel " + papel.name());
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

        PapelModel papelAtivado = papelRepository.findByPapel(Papel.ATIVADO);
        PapelModel papelDesativado = papelRepository.findByPapel(Papel.DESATIVADO);

        if (papelAtivado == null || papelDesativado == null) {
            throw new EntityNotFoundException("Roles ATIVADO ou DESATIVADO não encontradas.");
        }

        List<PapelModel> papeis = usuarioModel.getPapeis();
        boolean isAtivado = papeis.contains(papelAtivado);

        if (statusFormatado.equals("ATIVADO") && !isAtivado) {
            papeis.remove(papelDesativado);
            papeis.add(papelAtivado);
        } else if (statusFormatado.equals("DESATIVADO") && isAtivado) {
            papeis.remove(papelAtivado);
            papeis.add(papelDesativado);
        } else {
            throw new IllegalArgumentException("Usuário já possui o status: " + statusFormatado);
        }

        usuarioModel.setPapeis(papeis);
        usuarioRepository.save(usuarioModel);
    }
}
