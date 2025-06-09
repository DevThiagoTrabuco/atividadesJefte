package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.CondicaoMentalFacade;
import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condicao-mental/")
public class CondicaoMentalController {

    private final CondicaoMentalFacade condicaoMentalFacade;

    @Autowired
    public CondicaoMentalController(CondicaoMentalFacade condicaoMentalFacade) {
        this.condicaoMentalFacade = condicaoMentalFacade;
    }
    // Métodos de controle

    @PostMapping("/adicionar")
    public void adicionarCondicaoMental(@RequestParam String nome, @RequestParam String descricao) {
        condicaoMentalFacade.adicionarCondicaoMental(nome, descricao);
    }

    @DeleteMapping("/remover-condicao/{codigo}")
    public void removerCondicaoMental(@PathVariable int id) {
        condicaoMentalFacade.removerCondicaoMental(id);
    }

    @GetMapping("/todas")
    public List<CondicaoMentalModels> buscarTodasCondicoes() {
        return condicaoMentalFacade.buscarTodasCondicoes();
    }

    @PutMapping("/atualizar-condicao/{codigo}")
    public void atualizarCondicaoMental(
            @PathVariable int id,
            @RequestParam String nome,
            @RequestParam String descricao
    ) {
        condicaoMentalFacade.atualizarCondicaoMental(id, nome, descricao);
    }

    @GetMapping("/verificar/{codigo}")
    public boolean verificarCondicaoMental(@PathVariable int id) {
        return condicaoMentalFacade.verificarCondicaoMental(id);
    }
}
