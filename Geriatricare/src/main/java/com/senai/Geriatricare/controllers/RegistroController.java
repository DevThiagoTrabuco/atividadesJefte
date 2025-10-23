package com.senai.Geriatricare.controllers;

    import com.senai.Geriatricare.models.RegistroModel;
    import com.senai.Geriatricare.entities.RegistroEntity;
    import com.senai.Geriatricare.services.RegistroService;
    import jakarta.persistence.EntityNotFoundException;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.*;

    import java.time.LocalDateTime;
    import java.util.List;

    @RestController
    @RequestMapping("/{clienteId}/registros")
    public class RegistroController {

        private final RegistroService registroService;

        @Autowired
        public RegistroController(RegistroService registroService) {
            this.registroService = registroService;
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @PostMapping
        public ResponseEntity<?> criarRegistro(@RequestBody RegistroEntity registroEntity) {
            try {
                registroService.criarRegistro(registroEntity);
                return ResponseEntity.ok("Registro criado com sucesso.");
            } catch (IllegalArgumentException | EntityNotFoundException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @PutMapping("/{id}")
        public ResponseEntity<?> atualizarRegistro(@PathVariable int id, @RequestBody RegistroEntity registroEntity) {
            try {
                registroEntity.setId(id);
                registroService.atualizarRegistro(registroEntity);
                return ResponseEntity.ok("Registro atualizado com sucesso.");
            } catch (IllegalArgumentException | EntityNotFoundException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @DeleteMapping("/{id}")
        public ResponseEntity<?> removerRegistro(@PathVariable int id) {
            try {
                registroService.removerRegistro(id);
                return ResponseEntity.ok("Registro removido com sucesso.");
            } catch (EntityNotFoundException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @GetMapping
        public ResponseEntity<List<RegistroModel>> listarTodos() {
            return ResponseEntity.ok(registroService.listarTodos());
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @GetMapping("/{id}")
        public ResponseEntity<?> buscarPorId(@PathVariable int id) {
            try {
                return ResponseEntity.ok(registroService.buscarPorId(id));
            } catch (EntityNotFoundException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @GetMapping("/entidade/{entidade}/{entidadeId}")
        public ResponseEntity<List<RegistroModel>> buscarPorEntidadeEId(
                @PathVariable int clienteId,
                @PathVariable String entidade,
                @PathVariable int entidadeId) {
            return ResponseEntity.ok(registroService.buscarPorEntidadeEId(clienteId, entidade, entidadeId));
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @GetMapping("/entidade/{entidade}")
        public ResponseEntity<List<RegistroModel>> buscarPorEntidade(
                @PathVariable int clienteId,
                @PathVariable String entidade) {
            return ResponseEntity.ok(registroService.buscarPorEntidade(clienteId, entidade));
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @GetMapping("/funcionario/{funcionarioId}")
        public ResponseEntity<List<RegistroModel>> buscarPorFuncionario(
                @PathVariable int clienteId,
                @PathVariable int funcionarioId) {
            return ResponseEntity.ok(registroService.buscarPorFuncionario(clienteId, funcionarioId));
        }

        @PreAuthorize("(hasRole('CLIENTE') or hasRole('FUNCIONARIO')) and hasRole('ATIVADO')")
        @GetMapping("/data/{dataHora}")
        public ResponseEntity<List<RegistroModel>> buscarPorData(
                @PathVariable int clienteId,
                @PathVariable String dataHora) {
            LocalDateTime data = LocalDateTime.parse(dataHora);
            return ResponseEntity.ok(registroService.buscarPorData(clienteId, data));
        }
    }