package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.entities.Familiar;
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

    // 1. Adicionar Familiar
    public void adicionarFamiliar(String nome, String email, String telefone) {
        FamiliarModels familiar = new FamiliarModels();
        familiar.setNome(nome);
        familiar.setEmail(email);
        familiar.setTelefone(telefone);

        // Adicionando o familiar no banco de dados
        familiarRepository.adicionar(familiar);
    }

    // 2. Remover Familiar
    public void removerFamiliar(int id) {
        FamiliarModels familiar = familiarRepository.buscarPorCodigo(id);  // Busca o familiar pelo id
        if (familiar != null) {
            familiarRepository.remover(id);
        } else {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
    }

    // 3. Buscar Familiar
    public FamiliarModels buscarFamiliar(int id) {
        FamiliarModels familiar = familiarRepository.buscarPorCodigo(id);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
        return familiar;
    }

    // 4. Atualizar Familiar
    public void atualizarFamiliar(int id, String novoNome, String novoEmail, String novoTelefone) {
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

    // 5. Buscar Todos Familiares
    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarRepository.buscar();
    }
}
