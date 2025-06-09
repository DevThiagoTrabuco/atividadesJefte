package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;

public interface CondicaoMentalRepository {
    public CondicaoMentalModels buscarPorCodigo(int codigo);
    public List<CondicaoMentalModels> buscar();
    public void adicionar(CondicaoMentalModels condicaoMentalModels);
    public void remover(int codigo);
    public void atualizar(CondicaoMentalModels condicaoMentalModels);
}
