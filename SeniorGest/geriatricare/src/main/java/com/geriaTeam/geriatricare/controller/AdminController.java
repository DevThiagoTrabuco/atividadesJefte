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
import com.geriaTeam.geriatricare.models.AdminModels;

@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminFacade adminFacade;

    @GetMapping
    public List<AdminModels> buscarTodosAdmin(){
        return adminFacade.buscarTodosAdmin();
    }

    @GetMapping("/buscarAdminId/{id}")
    public AdminModels buscarAdminId(@PathVariable int id){
        return adminFacade.buscarAdminId(id);
    }

    @PostMapping("/adicionarAdmin")
    public void adicionarAdmin(@RequestBody AdminModels adminModels){
        adminFacade.adicionarAdmin(adminModels);
    }

    @PutMapping("/atualizarAdmin/{id}")
    public void atualizarAdmin(@PathVariable int id, @RequestBody AdminModels adminModels){
        adminFacade.atualizarAdmin(adminModels);
    }

    @DeleteMapping("/removerAdmin/{id}")
    public void removerAdmin(@PathVariable int id){
        adminFacade.removerAdmin(id);
    }

    //Testar apenas
    @GetMapping("/autenticarAdmin")
    public AdminModels autenticarAdmin(@RequestBody AdminModels adminModels){
        return adminFacade.autenticarAdmin(adminModels.getLogin(), adminModels.getSenha());
    }
}
