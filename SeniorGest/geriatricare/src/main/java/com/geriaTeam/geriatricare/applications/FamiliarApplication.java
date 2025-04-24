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

    public void adicionarFamiliar(String nome, String sobrenome, String cpf, String rg, String email, String telefone) {
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
        FamiliarModels familiar = familiarRepository.buscarPorCodigo(id);
        if (familiar != null) {
            familiarRepository.remover(id);
        } else {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
    }

    public FamiliarModels buscarFamiliar(int id) {
        FamiliarModels familiar = familiarRepository.buscarPorCodigo(id);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
        return familiar;
    }


    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarRepository.buscar();
    }
}