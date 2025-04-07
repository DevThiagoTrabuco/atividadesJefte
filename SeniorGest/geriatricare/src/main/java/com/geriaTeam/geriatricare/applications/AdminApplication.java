package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.models.domain.Admin;
import com.geriaTeam.geriatricare.repositories.jpa.AdminJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/api/admin/")
public class AdminApplication {
    private final AdminJPA adminJPA;


    @Autowired
    public AdminApplication(AdminJPA adminJPA) {
        this.adminJPA = adminJPA;
    }

    @GetMapping("")
    public List<Admin> getAll() {
        return this.adminJPA.findAll();
    }

    @GetMapping("{id}")
    public Admin getById(@PathVariable int id) {
        return this.adminJPA.findById(id).get();
    }

    @PostMapping("")
    public Admin save(@RequestBody Admin admin) {
        return this.adminJPA.save(admin);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        this.adminJPA.deleteById(id);
    }

    @PutMapping
    public Admin getById(@RequestBody Admin admin) {
        return this.adminJPA.save(admin);
    }
}
