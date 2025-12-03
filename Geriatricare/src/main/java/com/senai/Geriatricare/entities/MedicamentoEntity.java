package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.MedicamentoModel;
import com.senai.Geriatricare.enums.StatusMedicamento;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoEntity {
    private int id;
    private int clienteId;
    private String nomeComercial;
    private String nomeGenerico;
    private String dosagem;
    private String lote;
    private LocalDate dataValidade;
    private StatusMedicamento statusMedicamento;
    private int quantidade;

    public MedicamentoModel toEntity(ClienteModel cliente){
        MedicamentoModel medicamento = new MedicamentoModel();
        medicamento.setId(this.id);
        medicamento.setCliente(cliente);
        medicamento.setNomeComercial(this.nomeComercial);
        medicamento.setNomeGenerico(this.nomeGenerico);
        medicamento.setDosagem(this.dosagem);
        medicamento.setLote(this.lote);
        medicamento.setDataValidade(this.dataValidade);

        return medicamento;
    }
}
