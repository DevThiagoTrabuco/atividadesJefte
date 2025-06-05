package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.MedicamentoEntity;
import com.senai.Geriatricare.enums.StatusMedicamento;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoModel {
    private int id;
    private String nomeComercial;
    private String nomeGenerico;
    private String dosagem;
    private String lote;
    private LocalDate dataValidade;
    private StatusMedicamento statusMedicamento;
    private int quantidade;

    public MedicamentoEntity toEntity(){
        MedicamentoEntity medicamento = new MedicamentoEntity();
        medicamento.setId(this.id);
        medicamento.setNomeComercial(this.nomeComercial);
        medicamento.setNomeGenerico(this.nomeGenerico);
        medicamento.setDosagem(this.dosagem);
        medicamento.setLote(this.lote);
        medicamento.setDataValidade(this.dataValidade);
        medicamento.setStatusMedicamento(this.statusMedicamento);
        medicamento.setQuantidade(this.quantidade);
        return medicamento;
    }
}
