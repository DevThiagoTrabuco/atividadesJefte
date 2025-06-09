package com.geriaTeam.geriatricare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.geriaTeam.geriatricare.facade.PacienteFacade;
import com.geriaTeam.geriatricare.models.PacienteModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.PlanoModels;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteFacade pacienteFacade;

    @GetMapping
    public List<PacienteModels> buscarTodosPacientes() {
        return pacienteFacade.buscarTodosPacientes();
    }

    @GetMapping("/buscar-id/{id}")
    public PacienteModels buscarPacienteId(@PathVariable int id) {
        return pacienteFacade.buscarPacienteId(id);
    }

    @PostMapping("adicionar")
    public void adicionarPaciente(@RequestBody PacienteModels pacienteModels) {
        pacienteFacade.adicionarPaciente(pacienteModels);
    }

    @PutMapping("atalizar")
    public void atualizarPaciente(@RequestBody PacienteModels pacienteModels) {
        pacienteFacade.atualizarPaciente(pacienteModels);
    }

    @DeleteMapping("/remover/{id}")
    public void removerPaciente(@PathVariable int id) {
        pacienteFacade.removerPaciente(id);
    }

    @GetMapping("/estado-saude/{id}")
    public String verificarEstadoSaudePaciente(@PathVariable int id) {
        return pacienteFacade.verificarEstadoSaudePaciente(id);
    }

    @PostMapping("/registrar-entrada/{id}")
    public void registrarEntradaPaciente(@PathVariable int id) {
        pacienteFacade.registrarEntradaPaciente(id);
    }

    @PostMapping("/registrar-saida/{id}")
    public void registrarSaidaPaciente(@PathVariable int id) {
        pacienteFacade.registrarSaidaPaciente(id);
    }

    @GetMapping("/idade/{id}")
    public int calcularIdadePaciente(@PathVariable int id) {
        return pacienteFacade.calcularIdadePaciente(id);
    }

    @GetMapping("/historico-medicamentos/{id}")
    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentosPaciente(@PathVariable int id) {
        return pacienteFacade.verificarHistoricoMedicamentosPaciente(id);
    }

    @PostMapping("/{id}/adicionar-familiar")
    public void adicionarFamiliarPaciente(@PathVariable int id, @RequestBody PacienteFamiliarModels familiar) {
        pacienteFacade.adicionarFamiliarPaciente(id, familiar);
    }

    @DeleteMapping("/{id}/remover-familiar/{idFamiliar}")
    public void removerFamiliarPaciente(@PathVariable int id, @PathVariable int idFamiliar) {
        pacienteFacade.removerFamiliarPaciente(id, idFamiliar);
    }

    @PutMapping("/{id}/atualizar-plano/{idPlano}")
    public void atualizarPlanoSaudePaciente(@PathVariable int id, @PathVariable int idPlano) {
        pacienteFacade.atualizarPlanoSaudePaciente(id, idPlano);
    }

    @PostMapping("/{id}/adicionar-medicamento")
    public void adicionarMedicamentoPaciente(@PathVariable int id, @RequestBody PacienteMedicamentoModels medicamento) {
        pacienteFacade.adicionarMedicamentoPaciente(id, medicamento);
    }

    @DeleteMapping("/{id}/remover-medicamento/{idMedicamento}")
    public void removerMedicamentoPaciente(@PathVariable int id, @PathVariable int idMedicamento) {
        pacienteFacade.removerMedicamentoPaciente(id, idMedicamento);
    }

    @GetMapping("/{id}/plano-saude")
    public PlanoModels verificarPlanoSaudePaciente(@PathVariable int id) {
        return pacienteFacade.verificarPlanoSaudePaciente(id);
    }
}