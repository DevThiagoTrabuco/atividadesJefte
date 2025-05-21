package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.FamiliarFacade;
import com.geriaTeam.geriatricare.models.FamiliarModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familiar/")
public class FamiliarController {

    private final FamiliarFacade familiarFacade;

    @Autowired
    public FamiliarController(FamiliarFacade familiarFacade) {
        this.familiarFacade = familiarFacade;
    }

    // CRUD padrão
    @PostMapping("/adicionar-familiar")
    public void adicionarFamiliar(@RequestBody FamiliarModels familiarModels) {
        familiarFacade.adicionarFamiliar(familiarModels);
    }

    @DeleteMapping("/remover-familiar/{id}")
    public void removerFamiliar(@PathVariable int id) {
        familiarFacade.removerFamiliar(id);
    }

    @GetMapping("/buscar-familiar-id/{id}")
    public FamiliarModels buscarFamiliarId(@PathVariable int id) {
        return familiarFacade.buscarFamiliarId(id);
    }

    @GetMapping("/buscar-familiar-cpf/{cpf}")
    public FamiliarModels buscarFamiliarCpf(@PathVariable String Cpf) {
        return familiarFacade.buscarFamiliarCpf(Cpf);
    }

    @GetMapping("/buscar-familiar-nome/{nome}/{sobrenome}")
    public List<FamiliarModels> buscarFamiliarNome(@PathVariable String nome, @PathVariable String sobrenome) {
        return familiarFacade.buscarPorNome(nome, sobrenome);
    }

    @PutMapping("/atualizar-familiar")
    public void atualizarFamiliar(@RequestBody FamiliarModels familiarModels) {
        familiarFacade.atualizarFamiliar(familiarModels);
    }

    @GetMapping("/buscar-todos-familiar")
    public List<FamiliarModels> buscarTodosFamiliares() {
        return familiarFacade.buscarTodosFamiliares();
    }
}
