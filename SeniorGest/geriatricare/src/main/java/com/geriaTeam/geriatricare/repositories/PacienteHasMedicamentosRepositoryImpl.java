package com.geriaTeam.geriatricare.repositories;

import com.geriaTeam.geriatricare.Interfaces.PacienteHasMedicamentosRepository;
import com.geriaTeam.geriatricare.models.domain.PacienteHasMedicamentos;

import java.util.List;

public class PacienteHasMedicamentosRepositoryImpl implements PacienteHasMedicamentosRepository {
    @Override
    public PacienteHasMedicamentos buscarPorCodigo(int codigo) {
        return null;
    }

    @Override
    public List<PacienteHasMedicamentos> buscar() {
        return List.of();
    }

    @Override
    public void adicionar(PacienteHasMedicamentos pacienteHasMedicamentos) {

    }

    @Override
    public void remover(int codigo) {

    }

    @Override
    public void atualizar(int codigo, PacienteHasMedicamentos pacienteHasMedicamentos) {

    }

    @Override
    public boolean vazio() {
        return false;
    }
}
