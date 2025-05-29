package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.IndicadorModels;
import com.geriaTeam.geriatricare.models.PacienteModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Indicador {
    private int id;
    private int batimentos;
    private int oximetria;
    private int temperatura;
    private PacienteModels pacienteModels;

    // Método para converter a entidade Indicador para IndicadorModels
    public IndicadorModels toModel() {
        IndicadorModels indicadorModels = new IndicadorModels();
        indicadorModels.setId(this.id);
        indicadorModels.setBatimentos(this.batimentos);
        indicadorModels.setOximetria(this.oximetria);
        indicadorModels.setTemperatura(this.temperatura);
        indicadorModels.setPacienteModels(this.pacienteModels != null ? this.pacienteModels : null);
        return indicadorModels;
    }
}
