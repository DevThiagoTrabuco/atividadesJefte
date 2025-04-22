package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.Interfaces.CondicaoMentalRepository;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import lombok.*;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
@Setter
@AllArgsConstructor
public class CondicaoMental {
    private int id;
    private String nome;
    private String descricao;

    // Método para converter a entidade CondicaoMental para CondicaoMentalModels
    public CondicaoMentalModels toModel() {
        CondicaoMentalModels condicaoMentalModels = new CondicaoMentalModels();
        condicaoMentalModels.setNome(this.nome);
        condicaoMentalModels.setDescricao(this.descricao);
        return condicaoMentalModels;
    }

    // 1. Adicionar Condição Mental
    public void adicionarCondicaoMental(String nome, String descricao, CondicaoMentalRepository condicaoMentalRepository) {
        CondicaoMentalModels condicaoMentalModels = new CondicaoMentalModels();
        condicaoMentalModels.setNome(nome);
        condicaoMentalModels.setDescricao(descricao);

        // Adicionando no repositório
        condicaoMentalRepository.adicionar(condicaoMentalModels);
    }

    // 2. Remover Condição Mental
    public void removerCondicaoMental(int codigo) {
        CondicaoMentalModels condicaoMental = condicaoMentalRepository.buscarPorCodigo(codigo);
        if (condicaoMental != null) {
            condicaoMentalRepository.remover(codigo);
        } else {
            throw new NoSuchElementException("Condição mental não encontrada.");
        }
    }

    // 3. Buscar todas as Condições Mentais
    public List<CondicaoMentalModels> buscarTodasCondicoes() {
        return condicaoMentalRepository.buscar();
    }

    // 4. Atualizar Condição Mental
    public void atualizarCondicaoMental(int codigo, String nome, String descricao) {
        CondicaoMentalModels condicaoMental = condicaoMentalRepository.buscarPorCodigo(codigo);
        if (condicaoMental != null) {
            condicaoMental.setNome(nome);
            condicaoMental.setDescricao(descricao);
            condicaoMentalRepository.atualizar(condicaoMental);
        } else {
            throw new NoSuchElementException("Condição mental não encontrada.");
        }
    }

    // 5. Verificar se a Condição Mental Existe
    public boolean verificarCondicaoMental(int codigo) {
        return condicaoMentalRepository.buscarPorCodigo(codigo) != null;
    }
}
