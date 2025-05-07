package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoMentalRepository;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CondicaoMentalApplication {
    private final CondicaoMentalRepository condicaoMentalRepository;

    @Autowired
    public CondicaoMentalApplication(CondicaoMentalRepository condicaoMentalRepository) {
        this.condicaoMentalRepository = condicaoMentalRepository;
    }

    //Adicionar Condição Mental
    public void adicionarCondicaoMental(String nome, String descricao) {
        CondicaoMentalModels condicaoMentalModels = new CondicaoMentalModels();
        condicaoMentalModels.setNome(nome);
        condicaoMentalModels.setDescricao(descricao);
        condicaoMentalRepository.adicionarCondicaoMental(condicaoMentalModels);
    }

    //Remover Condição Mental
    public void removerCondicaoMental(int codigo) {
        CondicaoMentalModels condicaoMental = condicaoMentalRepository.buscarCondicaoMental(codigo);
        if (condicaoMental != null) {
            condicaoMentalRepository.removerCondicaoMental(codigo);
        } else {
            throw new NoSuchElementException("Condição mental não encontrada.");
        }
    }

    //Buscar todas as Condições Mentais
    public List<CondicaoMentalModels> buscarTodasCondicoes() {
        return condicaoMentalRepository.buscarCondicaoMental();
    }

    //Atualizar Condição Mental
    public void atualizarCondicaoMental(int id, String nome, String descricao) {
        CondicaoMentalModels condicaoMental = condicaoMentalRepository.buscarCondicaoMental(id);
        if (condicaoMental != null) {
            condicaoMental.setNome(nome);
            condicaoMental.setDescricao(descricao);
            condicaoMentalRepository.atualizarCondicaoMental(condicaoMental);
        } else {
            throw new NoSuchElementException("Condição mental não encontrada.");
        }
    }

}
