package com.geriaTeam.geriatricare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geriaTeam.geriatricare.facade.AdminFacade;
import com.geriaTeam.geriatricare.models.domain.Admin;

@RequestMapping("/api/admin/")
@RestController
public class AdminController {
    private final AdminFacade adminFacade;

    @Autowired
    public AdminController(AdminFacade adminFacade) {
        this.adminFacade = adminFacade;

    }

    @GetMapping("")
    public List<Admin> buscar(){
        return adminFacade.buscar();
    }

    @GetMapping("/{codigo}")
    public Admin buscarPorCodigo(@PathVariable int codigo){
        return adminFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody Admin admin){
        adminFacade.adicionar(admin);
    }

    @PutMapping("/{codigo}")
    public void atualizar(@PathVariable int codigo, @RequestBody Admin admin){
        adminFacade.atualizar(codigo, admin);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        adminFacade.remover(codigo);
    }
}
