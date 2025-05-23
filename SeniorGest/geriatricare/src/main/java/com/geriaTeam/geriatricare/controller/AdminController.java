package com.geriaTeam.geriatricare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.geriaTeam.geriatricare.facade.AdminFacade;
import com.geriaTeam.geriatricare.models.AdminModels;

@RequestMapping("/api/admin/")
@RestController
public class AdminController {
    private final AdminFacade adminFacade;

    @Autowired
    public AdminController(AdminFacade adminFacade) {
        this.adminFacade = adminFacade;
    }

    @GetMapping("/buscar-todos-admin")
    public List<AdminModels> buscar(){
        return adminFacade.buscar();
    }

    @GetMapping("buscar-admin-id/{codigo}")
    public AdminModels buscarPorCodigo(@PathVariable int codigo){
        return adminFacade.buscarPorCodigo(codigo);
    }

    @PostMapping("")
    public void adicionar(@RequestBody AdminModels adminModels){
        adminFacade.adicionar(adminModels);
    }

    @PutMapping("/{codigo}")
    public void atualizarAdmin(@PathVariable int codigo, @RequestBody AdminModels adminModels){
        adminFacade.atualizarAdmin(codigo, adminModels);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable int codigo){
        adminFacade.remover(codigo);
    }
}
