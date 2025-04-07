package com.geriaTeam.geriatricare.applications;
import com.geriaTeam.geriatricare.repositories.jpa.FamiliarJPA;
import com.geriaTeam.geriatricare.models.domain.Familiar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;


    @Service
    @RestController
    @RequestMapping("/api/familiar/")
    public class FamiliarApplication {
        private final FamiliarJPA familiarJPA;


        @Autowired
        public FamiliarApplication(FamiliarJPA familiarJPA) {
            this.familiarJPA = familiarJPA;
        }

        @GetMapping("")
        public List<Familiar> getAll() {
            return this.familiarJPA.findAll();
        }

        @GetMapping("{id}")
        public Familiar getById(@PathVariable int id) {
            return this.familiarJPA.findById(id).get();
        }

        @PostMapping("")
        public Familiar save(@RequestBody Familiar familiar) {
            return this.familiarJPA.save(familiar);
        }

        @DeleteMapping("{id}")
        public void delete(@PathVariable int id) {
            this.familiarJPA.deleteById(id);
        }

        @PutMapping
        public Familiar getById(@RequestBody Familiar familiar) {
            return this.familiarJPA.save(familiar);
        }
}
