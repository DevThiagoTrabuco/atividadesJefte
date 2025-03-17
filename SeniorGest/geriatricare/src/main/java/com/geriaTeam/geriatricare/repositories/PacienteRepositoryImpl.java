package com.geriaTeam.geriatricare.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.domain.Paciente;

@Repository
public class PacienteRepositoryImpl implements PacienteRepository {
    private List<Paciente> pacientes = new ArrayList<>();

    @Override
    public void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    @Override
    public void atualizar(int codigo, Paciente paciente) {
        Paciente pacienteEmMemoria = this.buscarPorCodigo(codigo);
        pacienteEmMemoria.setId(paciente.getId());
        pacienteEmMemoria.setNome(paciente.getNome());
        pacienteEmMemoria.setNascimento(paciente.getNascimento());
        pacienteEmMemoria.setEntrada(paciente.getEntrada());
        pacienteEmMemoria.setCondMental(paciente.getCondMental());
        pacienteEmMemoria.setCondFisica(paciente.getCondFisica());
    }

    @Override
    public List<Paciente> buscar() {
        return pacientes;
    }

    @Override
    public Paciente buscarPorCodigo(int codigo) {
        Paciente paciente = pacientes
                .stream()
                .filter(l -> l.getId() == codigo)
                .findFirst()
                .get();

        return paciente;
    }

    @Override
    public void remover(int codigo) {
        pacientes.removeIf(l -> l.getId() == codigo);
    }
}