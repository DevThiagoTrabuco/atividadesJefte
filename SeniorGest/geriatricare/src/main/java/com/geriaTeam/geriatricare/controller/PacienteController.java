package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.PacienteFacade;
import com.geriaTeam.geriatricare.models.PacienteModels;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.PlanoModels;
import com.geriaTeam.geriatricare.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/paciente/")
public class PacienteController {

    private final PacienteFacade pacienteFacade;

    @Autowired
    public PacienteController(PacienteFacade pacienteFacade) {
        this.pacienteFacade = pacienteFacade;
    }

    @GetMapping("")
    public List<PacienteModels> buscar() {
        return pacienteFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public PacienteModels buscarPorCodigo(@PathVariable int codigo) {
        return pacienteFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody PacienteModels pacienteModels) {
        pacienteFacade.adicionar(pacienteModels);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody PacienteModels pacienteModels) {
        pacienteFacade.atualizar(pacienteModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo) {
        pacienteFacade.remover(codigo);
    }

    // Novas rotas

    @PostMapping("/verificar-estado-saude")
    public String verificarEstadoSaude(@RequestBody Paciente paciente) {
        return pacienteFacade.verificarEstadoSaude(paciente);
    }

    @PostMapping("/registrar-entrada")
    public void registrarEntrada(@RequestParam("dataEntrada") String dataEntradaStr, @RequestBody Paciente paciente) {
        LocalDateTime dataEntrada = LocalDateTime.parse(dataEntradaStr);
        pacienteFacade.registrarEntrada(paciente, dataEntrada);
    }

    @PostMapping("/calcular-idade")
    public int calcularIdade(@RequestBody Paciente paciente) {
        return pacienteFacade.calcularIdade(paciente);
    }

    @PostMapping("/historico-medicamentos")
    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentos(@RequestBody Paciente paciente) {
        return pacienteFacade.verificarHistoricoMedicamentos(paciente);
    }

    @PostMapping("/adicionar-familiar")
    public void adicionarFamiliar(@RequestBody Paciente paciente, @RequestParam("familiarId") int familiarId) {
        PacienteFamiliarModels familiar = new PacienteFamiliarModels(); // ou busca do banco
        familiar.setFamiliarId(familiarId);
        pacienteFacade.adicionarFamiliar(paciente, familiar);
    }

    @PostMapping("/verificar-plano")
    public PlanoModels verificarPlanoSaude(@RequestBody Paciente paciente) {
        return pacienteFacade.verificarPlanoSaude(paciente);
    }
}
