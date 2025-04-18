package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.CondicaoMentalRepository;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import com.geriaTeam.geriatricare.entities.CondicaoMental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondicaoMentalApplication {

    private final CondicaoMental condicaoMental;
    private final CondicaoMentalRepository condicaoMentalRepository;

    @Autowired
    public CondicaoMentalApplication(CondicaoMentalRepository condicaoMentalRepository) {
        this.condicaoMentalRepository = condicaoMentalRepository;
        this.condicaoMental = new CondicaoMental(condicaoMentalRepository);
    }

    // Adicionar Condição Mental
    public void adicionarCondicaoMental(String nome, String descricao) {
        condicaoMental.adicionarCondicaoMental(nome, descricao, condicaoMental.getCondicaoMentalRepository());
    }

    // Remover Condição Mental
    public void removerCondicaoMental(int codigo) {
        condicaoMental.removerCondicaoMental(codigo);
    }

    // Buscar Todas as Condições Mentais
    public List<CondicaoMentalModels> buscarTodasCondicoes() {
        return condicaoMental.buscarTodasCondicoes();
    }

    // Atualizar Condição Mental
    public void atualizarCondicaoMental(int codigo, String nome, String descricao) {
        condicaoMental.atualizarCondicaoMental(codigo, nome, descricao);
    }

    // Verificar se a Condição Mental Existe
    public boolean verificarCondicaoMental(int codigo) {
        return condicaoMental.verificarCondicaoMental(codigo);
    }

    // Métodos de repositório (caso queira chamar diretamente)
    public void adicionar(CondicaoMentalModels condicaoMentalModels) {
        condicaoMentalRepository.adicionar(condicaoMentalModels);
    }

    public void atualizar(CondicaoMentalModels condicaoMentalModels) {
        condicaoMentalRepository.atualizar(condicaoMentalModels);
    }

    public void remover(int codigo) {
        condicaoMentalRepository.remover(codigo);
    }

    public List<CondicaoMentalModels> buscar() {
        return condicaoMentalRepository.buscar();
    }

    public CondicaoMentalModels buscarPorCodigo(int codigo) {
        return condicaoMentalRepository.buscarPorCodigo(codigo);
    }
}
