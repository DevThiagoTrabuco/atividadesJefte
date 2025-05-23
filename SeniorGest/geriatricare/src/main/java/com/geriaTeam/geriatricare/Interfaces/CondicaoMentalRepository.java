package com.geriaTeam.geriatricare.Interfaces;

import java.util.List;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;

public interface CondicaoMentalRepository {
    CondicaoMentalModels buscarCondicaoMental(int codigo);
    List<CondicaoMentalModels> buscarCondicaoMental();
    void adicionarCondicaoMental(CondicaoMentalModels condicaoMentalModels);
    void removerCondicaoMental(int codigo);
    void atualizarCondicaoMental(CondicaoMentalModels condicaoMentalModels);
}
