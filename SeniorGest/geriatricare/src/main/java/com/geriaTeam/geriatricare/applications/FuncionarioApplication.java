package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FuncionarioRepository;
import com.geriaTeam.geriatricare.entities.*;
import com.geriaTeam.geriatricare.models.FuncionarioModels;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioApplication {
    private FuncionarioRepository funcionarioRepository;


    @Autowired
    public FuncionarioApplication(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void adicionarFuncionario(FuncionarioModels funcionarioModels){
        if(funcionarioRepository.buscarPorEmail(funcionarioModels.getEmail()) != null){
            throw new RuntimeException("Já existe um funcionário cadastrado com o email: " + funcionarioModels.getEmail());
        }
        if(funcionarioModels.getNome() == null || funcionarioModels.getNome().isEmpty()){
            throw new RuntimeException("O nome do funcionário não pode ser vazio.");
        }
        if(funcionarioModels.getSenha() == null || funcionarioModels.getSenha().isEmpty()){
            throw new RuntimeException("A senha do funcionário não pode ser vazia.");
        }

        if(funcionarioModels.getCpf() == null || funcionarioModels.getCpf().isEmpty()){
            throw new RuntimeException("O CPF do funcionário não pode ser vazio.");
        }

        if(funcionarioModels.getCtps() == null || funcionarioModels.getCtps().isEmpty()){
            throw new RuntimeException("A CTPS do funcionário não pode ser vazia.");
        }

        if( funcionarioModels.getCpf() == null || funcionarioModels.getCpf().isEmpty()){
            throw new RuntimeException("O CPF do funcionário não é valido.");
        }

        if(funcionarioModels.getRg() == null || funcionarioModels.getRg().isEmpty()){
            throw new RuntimeException("O RG do funcionário não pode ser vazio.");
        }

        CPF cpf = new CPF(funcionarioModels.getCpf());
        CTPS ctps = new CTPS();
        ctps.setNumero(funcionarioModels.getCtps());
        RG rg = new RG();
        rg.setNumero(funcionarioModels.getRg());
        Email email = new Email(funcionarioModels.getEmail());
        Telefone telefone = new Telefone(funcionarioModels.getTelefone());

        if(!cpf.validarCPF()){
            throw new RuntimeException("O CPF do funcionário não é válido.");
        }
        if(!ctps.validarCTPS()){
            throw new RuntimeException("A CTPS do funcionário não é válida.");
        }
        if(!rg.validarRG()){
            throw new RuntimeException("O RG do funcionário não é válido.");
        }
        if(!email.validarEmail()){
            throw new RuntimeException("O email do funcionário não é válido.");
        }
        if(!telefone.validarTelefone()){
            throw new RuntimeException("O telefone do funcionário não é válido.");
        }

        Funcionario funcionario = new Funcionario();

        funcionario.setNome(funcionarioModels.getNome());
        funcionario.setSobrenome(funcionarioModels.getSobrenome());
        funcionario.setCpf(cpf);
        funcionario.setCtps(ctps);
        funcionario.setRg(rg);
        funcionario.setEmail(email);
        funcionario.setTelefone(telefone);
        funcionario.setSenha(funcionarioModels.getSenha());
        funcionario.setFuncaoModels(funcionarioModels.getFuncaoModels());
        funcionario.setDataNascimento(funcionarioModels.getDataNascimento());

        this.funcionarioRepository.adicionar(funcionario.toModel());
    }

    public void atualizarFuncionario(FuncionarioModels funcionarioModels) {
        FuncionarioModels funcionarioExistente = funcionarioRepository.buscarPorCodigo(funcionarioModels.getId());
        if (funcionarioExistente == null) {
            throw new RuntimeException("Funcionário com ID " + funcionarioModels.getId() + " não encontrado.");
        }

        if (funcionarioModels.getNome() != null && !funcionarioModels.getNome().isEmpty()) {
            funcionarioExistente.setNome(funcionarioModels.getNome());
        }
        if (funcionarioModels.getSobrenome() != null && !funcionarioModels.getSobrenome().isEmpty()) {
            funcionarioExistente.setSobrenome(funcionarioModels.getSobrenome());
        }
        if (funcionarioModels.getSenha() != null && !funcionarioModels.getSenha().isEmpty()) {
            funcionarioExistente.setSenha(funcionarioModels.getSenha());
        }
        if (funcionarioModels.getCpf() != null && !funcionarioModels.getCpf().isEmpty()) {
            CPF cpf = new CPF(funcionarioModels.getCpf());
            if (!cpf.validarCPF()) {
                throw new RuntimeException("O CPF do funcionário não é válido.");
            }
            funcionarioExistente.setCpf(funcionarioModels.getCpf());
        }
        if (funcionarioModels.getCtps() != null && !funcionarioModels.getCtps().isEmpty()) {
            CTPS ctps = new CTPS();
            ctps.setNumero(funcionarioModels.getCtps());
            if (!ctps.validarCTPS()) {
                throw new RuntimeException("A CTPS do funcionário não é válida.");
            }
            funcionarioExistente.setCtps(funcionarioModels.getCtps());
        }
        if (funcionarioModels.getRg() != null && !funcionarioModels.getRg().isEmpty()) {
            RG rg = new RG();
            rg.setNumero(funcionarioModels.getRg());
            if (!rg.validarRG()) {
                throw new RuntimeException("O RG do funcionário não é válido.");
            }
            funcionarioExistente.setRg(funcionarioModels.getRg());
        }
        if (funcionarioModels.getEmail() != null && !funcionarioModels.getEmail().isEmpty()) {
            Email email = new Email(funcionarioModels.getEmail());
            if (!email.validarEmail()) {
                throw new RuntimeException("O email do funcionário não é válido.");
            }
            funcionarioExistente.setEmail(funcionarioModels.getEmail());
        }
        if (funcionarioModels.getTelefone() != null && !funcionarioModels.getTelefone().isEmpty()) {
            Telefone telefone = new Telefone(funcionarioModels.getTelefone());
            if (!telefone.validarTelefone()) {
                throw new RuntimeException("O telefone do funcionário não é válido.");
            }
            funcionarioExistente.setTelefone(funcionarioModels.getTelefone());
        }
        if (funcionarioModels.getFuncaoModels() != null) {
            funcionarioExistente.setFuncaoModels(funcionarioModels.getFuncaoModels());
        }
        if (funcionarioModels.getDataNascimento() != null) {
            funcionarioExistente.setDataNascimento(funcionarioModels.getDataNascimento());
        }

        this.funcionarioRepository.atualizar(funcionarioExistente);
    }

    public void remover(int codigo){
        this.funcionarioRepository.remover(codigo);
    }

    public List<FuncionarioModels> buscar(){
        return this.funcionarioRepository.buscar();
    }

    public FuncionarioModels buscarPorCodigo(int codigo){
        return this.funcionarioRepository.buscarPorCodigo(codigo);
    }
}

