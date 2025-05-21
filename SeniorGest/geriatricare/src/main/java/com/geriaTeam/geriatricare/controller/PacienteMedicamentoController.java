package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PacienteMedicamentoFacade;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente-medicamento/")
public class PacienteMedicamentoController {

    private final PacienteMedicamentoFacade pacienteMedicamentoFacade;

    @Autowired
    public PacienteMedicamentoController(PacienteMedicamentoFacade pacienteMedicamentoFacade) {
        this.pacienteMedicamentoFacade = pacienteMedicamentoFacade;
    }
    @PostMapping("/adicionar-medicamento")
    public void adicionarMedicamento(@RequestParam int pacienteId, @RequestParam int medicamentoId) {
        pacienteMedicamentoFacade.adicionarMedicamento(pacienteId, medicamentoId);
    }

    @DeleteMapping("/remover-medicamento")
    public void removerMedicamento(@RequestParam int pacienteId, @RequestParam int medicamentoId) {
        pacienteMedicamentoFacade.removerMedicamento(pacienteId, medicamentoId);
    }

    @GetMapping("/todos-medicamentos/{pacienteId}")
    public List<MedicamentoModels> buscarMedicamentosPorPaciente(@PathVariable int pacienteId) {
        return pacienteMedicamentoFacade.buscarMedicamentosPorPaciente(pacienteId);
    }

    @PutMapping("/atualizar-medicamento")
    public void atualizarMedicamento(
            @RequestParam int pacienteId,
            @RequestParam int medicamentoIdAntigo,
            @RequestParam int medicamentoIdNovo
    ) {
        pacienteMedicamentoFacade.atualizarMedicamento(pacienteId, medicamentoIdAntigo, medicamentoIdNovo);
    }

    @GetMapping("/verificar-medicamento")
    public boolean verificarMedicamento(
            @RequestParam int pacienteId,
            @RequestParam int medicamentoId
    ) {
        return pacienteMedicamentoFacade.verificarMedicamento(pacienteId, medicamentoId);
    }
}
