package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PacienteMedicamentoFacade;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.MedicamentoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacienteMedicamento/")
public class PacienteMedicamentoController {

    private final PacienteMedicamentoFacade pacienteMedicamentoFacade;

    @Autowired
    public PacienteMedicamentoController(PacienteMedicamentoFacade pacienteMedicamentoFacade) {
        this.pacienteMedicamentoFacade = pacienteMedicamentoFacade;
    }

    @GetMapping("")
    public List<PacienteMedicamentoModels> buscar() {
        return pacienteMedicamentoFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public PacienteMedicamentoModels buscarPorCodigo(@PathVariable int codigo) {
        return pacienteMedicamentoFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody PacienteMedicamentoModels pacienteMedicamentoModels) {
        pacienteMedicamentoFacade.adicionar(pacienteMedicamentoModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody PacienteMedicamentoModels pacienteMedicamentoModels) {
        pacienteMedicamentoFacade.atualizar(pacienteMedicamentoModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        pacienteMedicamentoFacade.remover(codigo);
    }

    // Novas rotas com base na facade

    @PostMapping("/adicionar-medicamento")
    public void adicionarMedicamento(@RequestParam int pacienteId, @RequestParam int medicamentoId) {
        pacienteMedicamentoFacade.adicionarMedicamento(pacienteId, medicamentoId);
    }

    @DeleteMapping("/remover-medicamento")
    public void removerMedicamento(@RequestParam int pacienteId, @RequestParam int medicamentoId) {
        pacienteMedicamentoFacade.removerMedicamento(pacienteId, medicamentoId);
    }

    @GetMapping("/medicamentos/{pacienteId}")
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
