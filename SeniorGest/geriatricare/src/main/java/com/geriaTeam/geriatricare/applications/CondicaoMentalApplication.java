package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoMentalRepository;
import com.geriaTeam.geriatricare.entities.CondicaoMental;
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
    public void adicionarCondicaoMental(CondicaoMentalModels condicaoMentalModels) {
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
    public void atualizarCondicaoMental(CondicaoMentalModels condicaoAtualizada) {
        CondicaoMentalModels condicaoExistente = condicaoMentalRepository.buscarCondicaoMental(condicaoAtualizada.getId());
        if (condicaoExistente == null) {
            throw new NoSuchElementException("Condição mental não encontrada.");
        }

        if (condicaoAtualizada.getNome() != null && !condicaoAtualizada.getNome().isEmpty()) {
            condicaoExistente.setNome(condicaoAtualizada.getNome());
        }

        if (condicaoAtualizada.getDescricao() != null && !condicaoAtualizada.getDescricao().isEmpty()) {
            condicaoExistente.setDescricao(condicaoAtualizada.getDescricao());
        }

        condicaoMentalRepository.atualizarCondicaoMental(condicaoExistente);
    }

}
