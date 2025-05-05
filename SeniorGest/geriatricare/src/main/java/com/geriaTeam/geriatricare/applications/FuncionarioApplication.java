package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FuncionarioRepository;
import com.geriaTeam.geriatricare.entities.Funcionario;
import com.geriaTeam.geriatricare.entities.Login;
import com.geriaTeam.geriatricare.entities.Senha;
import com.geriaTeam.geriatricare.models.FuncionarioModels;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioApplication {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private AdminApplication adminApplication;


    private void validarAdmin(String login, String senha) {
        if (adminApplication.autenticarAdmin(login, senha) == null) {
            throw new SecurityException("Acesso negado. Apenas administradores podem executar esta ação.");
        }
    }

    public void adicionarFuncionario(FuncionarioModels model, String adminLogin, String adminSenha) {
        validarAdmin(adminLogin, adminSenha);

        Login login = new Login(model.getLogin().toString());
        Senha senha = new Senha(model.getSenha().toString());

        if (!login.validarLogin()) {
            throw new IllegalArgumentException("Login inválido. Utilize um e-mail válido.");
        }

        if (!senha.validarSenha()) {
            throw new IllegalArgumentException("Senha fraca. Deve conter no mínimo 8 caracteres, letras e números.");
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setId(model.getId());
        funcionario.setNome(model.getNome());
        funcionario.setSobrenome(model.getSobrenome());
        funcionario.setDataNascimento(model.getDataNascimento());
        funcionario.setCpf(model.getCpf());
        funcionario.setRg(model.getRg());
        funcionario.setTelefone(model.getTelefone());
        funcionario.setEmail(model.getEmail());
        funcionario.setFuncao(model.getFuncao());
        funcionario.setCtps(model.getCtps());
        funcionario.setLogin(login);
        funcionario.setSenha(senha);

        funcionarioRepository.adicionarFuncionario(funcionario.toModel());
    }

    public FuncionarioModels autenticarFuncionario(Login loginInput, Senha senhaInput) {
        List<FuncionarioModels> funcionarios = funcionarioRepository.buscarFuncionario();

        for (FuncionarioModels model : funcionarios) {
            if (model.getLogin().equals(loginInput) && model.getSenha().equals(senhaInput)) {
                return model;
            }
        }

        throw new SecurityException("Login ou senha inválidos.");
    }

    public void atualizarFuncionario(FuncionarioModels model, String adminLogin, String adminSenha) {
        validarAdmin(adminLogin, adminSenha);

        FuncionarioModels existente = funcionarioRepository.buscarFuncionarioId(model.getId());
        if (existente == null) {
            throw new EntityNotFoundException("Funcionário não encontrado.");
        }
        funcionarioRepository.atualizarFuncionario(model);
    }

    public void removerFuncionario(int id, String adminLogin, String adminSenha) {
        validarAdmin(adminLogin, adminSenha);

        funcionarioRepository.removerFuncionario(id);
    }

    public List<FuncionarioModels> buscarTodosFuncionario() {
        return funcionarioRepository.buscarFuncionario();
    }

    public FuncionarioModels buscarFuncionarioId(int id) {
       FuncionarioModels funcionario = funcionarioRepository.buscarFuncionarioId(id);
        if (funcionario == null) {
            throw new EntityNotFoundException("Funcionário não encontrado.");
        }
        return funcionario;
    }
}
