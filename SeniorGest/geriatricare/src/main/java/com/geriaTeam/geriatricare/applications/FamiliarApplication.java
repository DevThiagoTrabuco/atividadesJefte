package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.entities.*;
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

    public void adicionarFamiliar(FamiliarModels familiarModels) {
        Familiar familiar = new Familiar();
        RG rg = new RG();
        CPF cpf = new CPF();
        Email email = new Email();
        Telefone telefone = new Telefone();

        cpf.setNumero(familiarModels.getCpf());
        rg.setNumero(familiarModels.getRg());
        email.setEndereco(familiarModels.getEmail());
        telefone.setNumero(familiarModels.getTelefone());

        if(!cpf.validarCPF()) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if(!rg.validarRG()) {
            throw new IllegalArgumentException("RG inválido.");
        }
        if(!email.validarEmail()) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if(!telefone.validarTelefone()) {
            throw new IllegalArgumentException("Telefone inválido.");
        }

        familiar.setId(familiarModels.getId());
        familiar.setNome(familiarModels.getNome());
        familiar.setSobrenome(familiarModels.getSobrenome());
        familiar.setPacienteFamiliarModels(familiarModels.getPacienteFamiliarModels());
        familiar.setRg(rg);
        familiar.setCpf(cpf);
        familiar.setEmail(email);
        familiar.setTelefone(telefone);

        familiarRepository.adicionarFamiliar(familiar.toModel());
    }

    public void atualizarFamiliar(FamiliarModels familiarModels) {
        if(familiarRepository.buscarFamiliarId(familiarModels.getId()) == null) {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
        Familiar familiar = new Familiar();
        RG rg = new RG();
        CPF cpf = new CPF();
        Email email = new Email();
        Telefone telefone = new Telefone();

        cpf.setNumero(familiarModels.getCpf());
        rg.setNumero(familiarModels.getRg());
        email.setEndereco(familiarModels.getEmail());
        telefone.setNumero(familiarModels.getTelefone());
        if(!cpf.validarCPF()) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if(!rg.validarRG()) {
            throw new IllegalArgumentException("RG inválido.");
        }
        if(!email.validarEmail()) {
            throw new IllegalArgumentException("Email inválido.");
        }
        if(!telefone.validarTelefone()) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
        familiar.setId(familiarModels.getId());
        familiar.setNome(familiarModels.getNome());
        familiar.setSobrenome(familiarModels.getSobrenome());
        familiar.setPacienteFamiliarModels(familiarModels.getPacienteFamiliarModels());
        familiar.setRg(rg);
        familiar.setCpf(cpf);
        familiar.setEmail(email);
        familiar.setTelefone(telefone);

        familiarRepository.atualizarFamiliar(familiar.toModel());
    }

    public void removerFamiliar(int id) {
        FamiliarModels familiar = familiarRepository.buscarFamiliarId(id);
        if (familiar != null) {
            familiarRepository.removerFamiliar(id);
        } else {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
    }

    public FamiliarModels buscarFamiliarId(int id) {
        FamiliarModels familiar = familiarRepository.buscarFamiliarId(id);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
        return familiar;
    }

    public FamiliarModels buscarFamiliarCpf(String Cpf) {
        FamiliarModels familiar = familiarRepository.buscarFamiliarCpf(Cpf);
        if (familiar == null) {
            throw new EntityNotFoundException("Familiar não encontrado.");
        }
        return familiar;
    }

    public List<FamiliarModels> buscarPorNome(String nome, String sobrenome) {
        String nomeCompleto = nome + sobrenome;
        return familiarRepository.buscarFamiliarNome(nomeCompleto);
    }

    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarRepository.buscarFamiliar();
    }
}