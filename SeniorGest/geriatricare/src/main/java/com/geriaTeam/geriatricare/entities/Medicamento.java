package com.geriaTeam.geriatricare.entities;

import com.geriaTeam.geriatricare.models.MedicamentoModels;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {
    private int id;
    private String nome;
    private int quantidade;
    private String lote;
    private LocalDateTime vencimento;

    //Método para converter a entidade Medicamento para MedicamentoModels
    public MedicamentoModels toModel() {
        MedicamentoModels medicamentoModels = new MedicamentoModels();
        medicamentoModels.setId(this.id);
        medicamentoModels.setNome(this.nome);
        medicamentoModels.setLote(this.lote);
        medicamentoModels.setQuantidade(this.quantidade);
        medicamentoModels.setVencimento(this.vencimento);
        return medicamentoModels;
    }
}
