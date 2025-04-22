package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Familiar {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private List<PacienteFamiliarModels> pacienteFamiliarModels;

    // Método para converter a entidade Familiar para FamiliarModels
    public FamiliarModels toModel() {
        FamiliarModels familiarModels = new FamiliarModels();
        familiarModels.setNome(this.nome);
        familiarModels.setEmail(this.email);
        familiarModels.setTelefone(this.telefone);
        familiarModels.setPacienteFamiliarModels(this.pacienteFamiliarModels);
        return familiarModels;
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
