package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.PacienteHasMedicamentos;

import java.util.List;

public interface PacienteHasMedicamentosRepository {
    public PacienteHasMedicamentos buscarPorCodigo(int codigo);
    public List<PacienteHasMedicamentos> buscar();
    public void adicionar(PacienteHasMedicamentos pacienteHasMedicamentos);
    public void remover(int codigo);
    public void atualizar(int codigo, PacienteHasMedicamentos pacienteHasMedicamentos);
    public boolean vazio();
}