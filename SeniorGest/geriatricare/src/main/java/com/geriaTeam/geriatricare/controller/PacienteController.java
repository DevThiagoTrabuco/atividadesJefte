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
    public List<PacienteModels> listarTodos() {
        return pacienteFacade.listarTodos();
    }

    @GetMapping("/{id}")
    public PacienteModels listarPorId(@PathVariable int id) {
        return pacienteFacade.listarPorId(id);
    }

    @PostMapping
    public void adicionar(@RequestBody PacienteModels pacienteModels) {
        pacienteFacade.adicionar(pacienteModels);
    }

    @PutMapping
    public void atualizar(@RequestBody PacienteModels pacienteModels) {
        pacienteFacade.atualizar(pacienteModels);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) {
        pacienteFacade.remover(id);
    }

    @GetMapping("/estado-saude/{id}")
    public String verificarEstadoSaude(@PathVariable int id) {
        return pacienteFacade.verificarEstadoSaude(id);
    }

    @PostMapping("/registrar-entrada/{id}")
    public void registrarEntrada(@PathVariable int id) {
        pacienteFacade.registrarEntrada(id);
    }

    @PostMapping("/registrar-saida/{id}")
    public void registrarSaida(@PathVariable int id) {
        pacienteFacade.registrarSaida(id);
    }

    @GetMapping("/idade/{id}")
    public int calcularIdade(@PathVariable int id) {
        return pacienteFacade.calcularIdade(id);
    }

    @GetMapping("/historico-medicamentos/{id}")
    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentos(@PathVariable int id) {
        return pacienteFacade.verificarHistoricoMedicamentos(id);
    }

    @PostMapping("/{id}/adicionar-familiar")
    public void adicionarFamiliar(@PathVariable int id, @RequestBody PacienteFamiliarModels familiar) {
        pacienteFacade.adicionarFamiliar(id, familiar);
    }

    @DeleteMapping("/{id}/remover-familiar/{idFamiliar}")
    public void removerFamiliar(@PathVariable int id, @PathVariable int idFamiliar) {
        pacienteFacade.removerFamiliar(id, idFamiliar);
    }

    @PutMapping("/{id}/atualizar-plano/{idPlano}")
    public void atualizarPlanoSaude(@PathVariable int id, @PathVariable int idPlano) {
        pacienteFacade.atualizarPlanoSaude(id, idPlano);
    }

    @PostMapping("/{id}/adicionar-medicamento")
    public void adicionarMedicamento(@PathVariable int id, @RequestBody PacienteMedicamentoModels medicamento) {
        pacienteFacade.adicionarMedicamento(id, medicamento);
    }

    @DeleteMapping("/{id}/remover-medicamento/{idMedicamento}")
    public void removerMedicamento(@PathVariable int id, @PathVariable int idMedicamento) {
        pacienteFacade.removerMedicamento(id, idMedicamento);
    }

    @GetMapping("/{id}/plano-saude")
    public PlanoModels verificarPlanoSaude(@PathVariable int id) {
        return pacienteFacade.verificarPlanoSaude(id);
    }
}