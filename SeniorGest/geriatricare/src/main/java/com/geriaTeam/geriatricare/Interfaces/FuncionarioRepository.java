package com.geriaTeam.geriatricare.Interfaces;

package com.geriaTeam.geriatricare.Interfaces;

import com.geriaTeam.geriatricare.models.domain.Funcionario;

import java.util.List;

public interface FuncionarioRepository {
    public Funcionario buscarPorCodigo(int codigo);
    public List<Funcionario> buscar();
    public void adicionar(Funcionario funcionario);
    public void remover(int codigo);
    public void atualizar(int codigo, Funcionario funcionario);
}
