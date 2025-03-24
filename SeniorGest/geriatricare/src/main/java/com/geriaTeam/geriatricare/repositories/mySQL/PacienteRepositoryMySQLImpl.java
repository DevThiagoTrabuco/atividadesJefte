package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.models.domain.Paciente;
import com.geriaTeam.geriatricare.repositories.jpa.PacienteJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PacienteRepositoryMySQLImpl implements PacienteRepository {
    private final PacienteJPA pacienteJPA;

    @Autowired
    public PacienteRepositoryMySQLImpl(PacienteJPA pacienteJPA) {
        this.pacienteJPA = pacienteJPA;
    }

    @Override
    public Paciente buscarPorCodigo(int codigo) {
        return this.pacienteJPA.findById(codigo).get();
    }

    @Override
    public List<Paciente> buscar() {
        return this.pacienteJPA.findAll();
    }

    @Override
    public void adicionar(Paciente paciente) {
        this.pacienteJPA.save(paciente);
    }

    @Override
    public void remover(int codigo) {
        this.pacienteJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(int codigo, Paciente paciente) {
        Paciente pacienteDB = this.pacienteJPA.findById(codigo).get();

        pacienteDB.setNome(paciente.getNome());
        pacienteDB.setNascimento(paciente.getNascimento());
        pacienteDB.setEntrada(paciente.getEntrada());
        pacienteDB.setCondMental(paciente.getCondMental());
        pacienteDB.setCondFisica(paciente.getCondFisica());
        
        this.pacienteJPA.save(pacienteDB);
    }
}
