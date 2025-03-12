package com.geriaTeam.geriatricare.controller;

import com.geriaTeam.geriatricare.facade.AdminFacade;
import com.geriaTeam.geriatricare.models.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/adm/")
@RestController
public class AdminController {
    private final AdminFacade adminFacade;

    @Autowired
    public AdminController(AdminFacade adminFacade) {
        this.adminFacade = adminFacade;

    }

    @GetMapping("")
    public List<Admin> get(){
        return adminFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Admin getLanche(@PathVariable UUID codigo){
        return adminFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void cadastrar(@RequestBody Admin admin){
        adminFacade.cadastrar(admin);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable UUID codigo, @RequestBody Admin admin){
        adminFacade.atualizar(codigo, admin);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable UUID codigo, @RequestBody Admin admin){
        adminFacade.remover(codigo, admin);
    }

}
