package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliarApplication {
    private final FamiliarRepository familiarRepository;

    @Autowired
    public FamiliarApplication(FamiliarRepository familiarRepository) {
        this.familiarRepository = familiarRepository;
    }

    public void adicionarFamiliar(String nome, String email, String telefone) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido: " + nome);
        }
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
        if (!validarTelefone(telefone)) {
            throw new IllegalArgumentException("Telefone inválido: " + telefone);
        }

        FamiliarModels familiar = new FamiliarModels();
        familiar.setNome(nome);
        familiar.setEmail(email);
        familiar.setTelefone(telefone);

        familiarRepository.adicionar(familiar);
    }

    public void atualizarFamiliar(int id, String novoNome, String novoEmail, String novoTelefone) {
        if (!validarId(id)) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
        if (!validarNome(novoNome)) {
            throw new IllegalArgumentException("Nome inválido: " + novoNome);
        }
        if (!validarEmail(novoEmail)) {
            throw new IllegalArgumentException("Email inválido: " + novoEmail);
        }
        if (!validarTelefone(novoTelefone)) {
            throw new IllegalArgumentException("Telefone inválido: " + novoTelefone);
        }

        FamiliarModels familiar = familiarRepository.buscarPorCodigo(id);
        if (familiar != null) {
            familiar.setNome(novoNome);
            familiar.setEmail(novoEmail);
            familiar.setTelefone(novoTelefone);
            familiarRepository.atualizar(familiar);
        } else {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
    }

    public void removerFamiliar(int id) {
        if (!validarId(id)) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }

        FamiliarModels familiar = familiarRepository.buscarPorCodigo(id);
        if (familiar != null) {
            familiarRepository.remover(id);
        } else {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
    }

    public FamiliarModels buscarFamiliar(int id) {
        if (!validarId(id)) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }

        FamiliarModels familiar = familiarRepository.buscarPorCodigo(id);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
        return familiar;
    }

    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarRepository.buscar();
    }

    private boolean validarId(int id) {
        return id > 0;
    }

    private boolean validarNome(String nome) {
        return nome != null && !nome.isBlank() && nome.length() <= 100;
    }

    private boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.length() <= 100;
    }

    private boolean validarTelefone(String telefone) {
        return telefone != null && telefone.matches("\\d{10,15}");
    }
}