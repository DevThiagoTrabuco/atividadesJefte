package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;

public interface CondicaoMentalRepository {
    public CondicaoMentalModels buscarCondicaoMental(int codigo);
    public List<CondicaoMentalModels> buscarCondicaoMental();
    public void adicionarCondicaoMental(CondicaoMentalModels condicaoMentalModels);
    public void removerCondicaoMental(int codigo);
    public void atualizarCondicaoMental(CondicaoMentalModels condicaoMentalModels);
}
