package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.generics.Generics;
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

    public void adicionarFamiliar(String nome, String sobrenome, String cpf, String rg, String email, String telefone) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido: " + nome);
        }
        if (!validarNome(sobrenome)) {
            throw new IllegalArgumentException("Sobrenome inválido: " + sobrenome);
        }
        if (!Generics.validarCpf(cpf)) {
            throw new IllegalArgumentException("CPF inválido: " + cpf);
        }
        if (!Generics.validarRg(rg)) {
            throw new IllegalArgumentException("RG inválido: " + rg);
        }
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
        if (!validarTelefone(telefone)) {
            throw new IllegalArgumentException("Telefone inválido: " + telefone);
        }

        FamiliarModels familiar = new FamiliarModels();
        familiar.setNome(nome);
        familiar.setSobrenome(sobrenome);
        familiar.setCpf(cpf);
        familiar.setRg(rg);
        familiar.setEmail(email);
        familiar.setTelefone(telefone);

        familiarRepository.adicionar(familiar);
    }

    public void atualizarFamiliar(int id, String novoNome,String novoSobrenome,String novoEmail, String novoTelefone) {
        if (!Generics.validarId(id)) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }
        if (!Generics.validarNome(novoNome)) {
            throw new IllegalArgumentException("Nome inválido: " + novoNome);
        }

        if (!validarNome(novoSobrenome)) {
            throw new IllegalArgumentException("Sobrenome inválido: " + novoSobrenome);
        }

        if (!Generics.validarEmail(novoEmail)) {
            throw new IllegalArgumentException("Email inválido: " + novoEmail);
        }
        if (!Generics.validarTelefone(novoTelefone)) {
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

    public static boolean validarId(int id) {
        return Generics.validarId(id);
    }

    public static boolean validarNome(String nome) {
        return Generics.validarNome(nome);
    }

    private boolean validarEmail(String email) {
        return Generics.validarEmail(email);
    }

    private boolean validarTelefone(String telefone) {
       return Generics.validarTelefone(telefone);
    }
}