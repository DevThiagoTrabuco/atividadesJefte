package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.entities.Familiar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliarApplication {
    private final Familiar familiar;
    private final FamiliarRepository familiarRepository;

    @Autowired
    public FamiliarApplication(FamiliarRepository familiarRepository) {
        this.familiarRepository = familiarRepository;
        this.familiar = new Familiar(familiarRepository);
    }

    // Adicionar Familiar
    public void adicionarFamiliar(String nome, String email, String telefone) {
        familiar.adicionarFamiliar(nome, email, telefone);
    }

    // Remover Familiar
    public void removerFamiliar(int id) {
        familiar.removerFamiliar(id);
    }

    // Buscar Familiar por ID
    public FamiliarModels buscarFamiliar(int id) {
        return familiar.buscarFamiliar(id);
    }

    // Atualizar Familiar
    public void atualizarFamiliar(int id, String novoNome, String novoEmail, String novoTelefone) {
        familiar.atualizarFamiliar(id, novoNome, novoEmail, novoTelefone);
    }

    // Buscar Todos Familiares
    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiar.buscarTodosFamiliares();
    }

    // Funções adicionais que interagem diretamente com o repositório
    public void adicionar(FamiliarModels familiarModels) {
        familiarRepository.adicionar(familiarModels);
    }

    public void atualizar(FamiliarModels familiarModels) {
        familiarRepository.atualizar(familiarModels);
    }

    public void remover(int code) {
        familiarRepository.remover(code);
    }

    public List<FamiliarModels> buscar() {
        return familiarRepository.buscar();
    }

    public FamiliarModels buscarPorCodigo(int code) {
        return familiarRepository.buscarPorCodigo(code);
    }
}
