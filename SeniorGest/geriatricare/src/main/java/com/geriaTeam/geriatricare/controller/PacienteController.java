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
@RequestMapping("/api/paciente/")
public class PacienteController {

    @Autowired
    private PacienteFacade pacienteFacade;

    @GetMapping("/buscar-todos-paciente")
    public List<PacienteModels> buscarTodosPacientes() {
        return pacienteFacade.buscarTodosPacientes();
    }

    @GetMapping("/buscar-paciente-id/{id}")
    public PacienteModels buscarPacienteId(@PathVariable int id) {
        return pacienteFacade.buscarPacienteId(id);
    }

    @GetMapping("/buscar-paciente-nome/{nome}/{sobrenome}")
    public List<PacienteModels> buscarPacienteNome(@PathVariable String nome, @PathVariable String sobrenome){
        return pacienteFacade.buscarPacienteNome(nome, sobrenome);
    }

    @PostMapping("/adicionar-paciente")
    public void adicionarPaciente(@RequestBody PacienteModels pacienteModels) {
        pacienteFacade.adicionarPaciente(pacienteModels);
    }

    @PutMapping("/atualizar-paciente")
    public void atualizarPaciente(@RequestBody PacienteModels pacienteModels) {
        pacienteFacade.atualizarPaciente(pacienteModels);
    }

    @DeleteMapping("/remover-paciente/{id}")
    public void removerPaciente(@PathVariable int id) {
        pacienteFacade.removerPaciente(id);
    }

    @GetMapping("/estado-saude-paciente/{id}")
    public String verificarEstadoSaudePaciente(@PathVariable int id) {
        return pacienteFacade.verificarEstadoSaudePaciente(id);
    }

    @PostMapping("/registrar-entrada-paciente/{id}")
    public void registrarEntradaPaciente(@PathVariable int id) {
        pacienteFacade.registrarEntradaPaciente(id);
    }

    @PostMapping("/registrar-saida-paciente/{id}")
    public void registrarSaidaPaciente(@PathVariable int id) {
        pacienteFacade.registrarSaidaPaciente(id);
    }

    @GetMapping("/idade-paciente/{id}")
    public int calcularIdadePaciente(@PathVariable int id) {
        return pacienteFacade.calcularIdadePaciente(id);
    }

    @GetMapping("/historico-medicamentos-paciente/{id}")
    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentosPaciente(@PathVariable int id) {
        return pacienteFacade.verificarHistoricoMedicamentosPaciente(id);
    }

    @PostMapping("/adicionar-familiar-paciente/{id}")
    public void adicionarFamiliarPaciente(@PathVariable int id, @RequestBody PacienteFamiliarModels familiar) {
        pacienteFacade.adicionarFamiliarPaciente(id, familiar);
    }

    @DeleteMapping("/remover-familiar-paciente/{id}/{idFamiliar}")
    public void removerFamiliarPaciente(@PathVariable int id, @PathVariable int idFamiliar) {
        pacienteFacade.removerFamiliarPaciente(id, idFamiliar);
    }

    @PutMapping("/atualizar-plano-paciente/{id}/{idPlano}")
    public void atualizarPlanoSaudePaciente(@PathVariable int id, @PathVariable int idPlano) {
        pacienteFacade.atualizarPlanoSaudePaciente(id, idPlano);
    }

    @PostMapping("/adicionar-medicamento-paciente/{id}")
    public void adicionarMedicamentoPaciente(@PathVariable int id, @RequestBody PacienteMedicamentoModels medicamento) {
        pacienteFacade.adicionarMedicamentoPaciente(id, medicamento);
    }

    @DeleteMapping("/remover-medicamento/{id}/{idMedicamento}")
    public void removerMedicamentoPaciente(@PathVariable int id, @PathVariable int idMedicamento) {
        pacienteFacade.removerMedicamentoPaciente(id, idMedicamento);
    }

    @GetMapping("/plano-saude/{id}")
    public PlanoModels verificarPlanoSaudePaciente(@PathVariable int id) {
        return pacienteFacade.verificarPlanoSaudePaciente(id);
    }
}