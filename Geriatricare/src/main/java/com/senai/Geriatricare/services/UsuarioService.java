package com.senai.Geriatricare.services;

import com.senai.Geriatricare.models.*;
import com.senai.Geriatricare.enums.Papel;
import com.senai.Geriatricare.entities.UsuarioEntity;
import com.senai.Geriatricare.repositories.*;
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
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final AdminRepository adminRepository;
    private final FamiliarRepository familiarRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PapelRepository papelRepository, PasswordEncoder passwordEncoder, ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository, AdminRepository adminRepository, FamiliarRepository familiarRepository) {
        this.usuarioRepository = usuarioRepository;
        this.papelRepository = papelRepository;
        this.passwordEncoder = passwordEncoder;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.adminRepository = adminRepository;
        this.familiarRepository = familiarRepository;
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

        UsuarioModel usuario = usuarioEntity.toModel();
        usuario.setSenha(passwordEncoder.encode(usuarioEntity.getSenha().getSenha()));
        usuario.setPapeis(papeisEntity);

        if (usuarioEntity.getCliente_id() != null) {
            ClienteModel cliente = clienteRepository.findById(usuarioEntity.getCliente_id())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + usuarioEntity.getCliente_id()));
            usuario.setCliente(cliente);
        }

        if (usuarioEntity.getFuncionario_id() != null) {
            FuncionarioModel funcionario = funcionarioRepository.findById(usuarioEntity.getFuncionario_id())
                    .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + usuarioEntity.getFuncionario_id()));
            usuario.setFuncionario(funcionario);
        }

        if (usuarioEntity.getAdmin_id() != null) {
            AdminModel admin = adminRepository.findById(usuarioEntity.getAdmin_id())
                    .orElseThrow(() -> new EntityNotFoundException("Admin não encontrado com ID: " + usuarioEntity.getAdmin_id()));
            usuario.setAdmin(admin);
        }

        if (usuarioEntity.getFamiliar_id() != null) {
            FamiliarModel familiar = familiarRepository.findById(usuarioEntity.getFamiliar_id())
                    .orElseThrow(() -> new EntityNotFoundException("Familiar não encontrado com ID: " + usuarioEntity.getFamiliar_id()));
            usuario.setFamiliar(familiar);
        }

        usuarioRepository.save(usuario);
    }

    public UsuarioEntity buscarUsuarioPorId(int id) {
        UsuarioModel usuarioModel = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        List<Papel> papeis = usuarioModel.getPapeis().stream()
                .map(PapelModel::getPapel)
                .toList();
        Integer clienteId = usuarioModel.getCliente() != null ? usuarioModel.getCliente().getId() : null;
        Integer funcionarioId = usuarioModel.getFuncionario() != null ? usuarioModel.getFuncionario().getId() : null;
        Integer adminId = usuarioModel.getAdmin() != null ? usuarioModel.getAdmin().getId() : null;
        Integer familiarId = usuarioModel.getFamiliar() != null ? usuarioModel.getFamiliar().getId() : null;
        return new UsuarioEntity(usuarioModel.getId(), usuarioModel.getNomeUsuario(), null, papeis, clienteId, funcionarioId, adminId, familiarId);
    }

    public List<UsuarioEntity> listarUsuarios() {
        List<UsuarioModel> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> {
                    Integer clienteId = usuario.getCliente() != null ? usuario.getCliente().getId() : null;
                    Integer funcionarioId = usuario.getFuncionario() != null ? usuario.getFuncionario().getId() : null;
                    Integer adminId = usuario.getAdmin() != null ? usuario.getAdmin().getId() : null;
                    Integer familiarId = usuario.getFamiliar() != null ? usuario.getFamiliar().getId() : null;
                    return new UsuarioEntity(usuario.getId(), usuario.getNomeUsuario(), null, Collections.emptyList(), clienteId, funcionarioId, adminId, familiarId);
                })
                .toList();
    }

    public List<UsuarioEntity> listarUsuariosPorPapel(Papel papel) {
        List<UsuarioModel> usuarios = usuarioRepository.findByPapeis_Papel(papel);
        return usuarios.stream()
                .map(usuario -> {
                    Integer clienteId = usuario.getCliente() != null ? usuario.getCliente().getId() : null;
                    Integer funcionarioId = usuario.getFuncionario() != null ? usuario.getFuncionario().getId() : null;
                    Integer adminId = usuario.getAdmin() != null ? usuario.getAdmin().getId() : null;
                    Integer familiarId = usuario.getFamiliar() != null ? usuario.getFamiliar().getId() : null;
                    return new UsuarioEntity(usuario.getId(), usuario.getNomeUsuario(), null, Collections.emptyList(), clienteId, funcionarioId, adminId, familiarId);
                })
                .toList();
    }

    public UsuarioEntity buscarUsuarioPorIdEPapel(int id, Papel papel) {
        UsuarioModel usuarioModel = usuarioRepository.findByIdAndPapeis_Papel(id, papel);
        if (usuarioModel == null) {
            throw new EntityNotFoundException("Usuário " + papel.name() + " não encontrado com ID: " + id);
        }
        Integer clienteId = usuarioModel.getCliente() != null ? usuarioModel.getCliente().getId() : null;
        Integer funcionarioId = usuarioModel.getFuncionario() != null ? usuarioModel.getFuncionario().getId() : null;
        Integer adminId = usuarioModel.getAdmin() != null ? usuarioModel.getAdmin().getId() : null;
        Integer familiarId = usuarioModel.getFamiliar() != null ? usuarioModel.getFamiliar().getId() : null;
        return new UsuarioEntity(
                usuarioModel.getId(),
                usuarioModel.getNomeUsuario(),
                null,
                List.of(papel),
                clienteId,
                funcionarioId,
                adminId,
                familiarId
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
        papeis.remove(papelAtivado);
        papeis.remove(papelDesativado);

        if (statusFormatado.equals("ATIVADO")) {
            papeis.add(papelAtivado);
        } else {
            papeis.add(papelDesativado);
        }

        usuarioModel.setPapeis(papeis);
        usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel buscarPorFuncionarioId(Integer funcionarioId) {
        return usuarioRepository.findByFuncionarioId(funcionarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado para o funcionário com ID: " + funcionarioId));
    }

    public UsuarioModel buscarPorAdminId(Integer adminId) {
        return usuarioRepository.findByAdminId(adminId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado para o admin com ID: " + adminId));
    }

    public UsuarioModel buscarPorClienteId(Integer clienteId) {
        return usuarioRepository.findByClienteId(clienteId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado para o cliente com ID: " + clienteId));
    }

    public UsuarioModel buscarPorFamiliarId(Integer familiarId) {
        return usuarioRepository.findByFamiliarId(familiarId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado para o familiar com ID: " + familiarId));
    }

    public void inativarUsuario(int id) {
        alternarStatusUsuario(id, "DESATIVADO");
    }

    public void ativarUsuario(int id) {
        alternarStatusUsuario(id, "ATIVADO");
    }
}
