package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.enums.Papel;
import com.senai.Geriatricare.entities.UsuarioEntity;
import com.senai.Geriatricare.models.UsuarioModel;
import com.senai.Geriatricare.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @PostMapping("/admin")
    public ResponseEntity<?> criarAdminUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        try {
            if (usuarioEntity.getPapel() == null || usuarioEntity.getPapel().size() != 2 ||
                    !usuarioEntity.getPapel().contains(Papel.ADMIN) ||
                    !usuarioEntity.getPapel().contains(Papel.ATIVADO)) {
                return ResponseEntity.badRequest().body("Para esta rota, os papéis devem ser 'ADMIN' e 'ATIVADO'.");
            }
            usuarioService.criarUsuario(usuarioEntity);
            return ResponseEntity.ok("Usuário administrador criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @PostMapping("/cliente")
    public ResponseEntity<?> criarClienteUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        try {
            if (usuarioEntity.getPapel() == null || usuarioEntity.getPapel().size() != 2 ||
                    !usuarioEntity.getPapel().contains(Papel.CLIENTE) ||
                    !usuarioEntity.getPapel().contains(Papel.ATIVADO)) {
                return ResponseEntity.badRequest().body("Para esta rota, os papéis devem ser 'CLIENTE' e 'ATIVADO'.");
            }
            usuarioService.criarUsuario(usuarioEntity);
            return ResponseEntity.ok("Usuário cliente criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('ADMIN') or hasRole('CLIENTE')) and hasRole('ATIVADO')")
    @PostMapping("/funcionario")
    public ResponseEntity<?> criarFuncionarioUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        try {
            if (usuarioEntity.getPapel() == null || usuarioEntity.getPapel().size() != 2 ||
                    !usuarioEntity.getPapel().contains(Papel.FUNCIONARIO) ||
                    !usuarioEntity.getPapel().contains(Papel.ATIVADO)) {
                return ResponseEntity.badRequest().body("Para esta rota, os papéis devem ser 'FUNCIONARIO' e 'ATIVADO'.");
            }
            usuarioService.criarUsuario(usuarioEntity);
            return ResponseEntity.ok("Usuário funcionário criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO') and hasRole('ATIVADO')")
    @PostMapping("/familiar")
    public ResponseEntity<?> criarFamiliarUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        try {
            if (usuarioEntity.getPapel() == null || usuarioEntity.getPapel().size() != 2 ||
                    !usuarioEntity.getPapel().contains(Papel.FAMILIAR) ||
                    !usuarioEntity.getPapel().contains(Papel.ATIVADO)) {
                return ResponseEntity.badRequest().body("Para esta rota, os papéis devem ser 'FAMILIAR' e 'ATIVADO'.");
            }
            usuarioService.criarUsuario(usuarioEntity);
            return ResponseEntity.ok("Usuário familiar criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping("/listar/admin")
    public ResponseEntity<?> listarUsuariosAdmin() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuariosPorPapel(Papel.ADMIN));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar usuários ADMIN: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping("/listar/cliente")
    public ResponseEntity<?> listarUsuariosCliente() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuariosPorPapel(Papel.CLIENTE));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar usuários CLIENTE: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') and hasRole('ATIVADO')")
    @GetMapping("/listar/funcionario")
    public ResponseEntity<?> listarUsuariosFuncionario() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuariosPorPapel(Papel.FUNCIONARIO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar usuários FUNCIONARIO: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO') and hasRole('ATIVADO')")
    @GetMapping("/listar/familiar")
    public ResponseEntity<?> listarUsuariosFamiliar() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuariosPorPapel(Papel.FAMILIAR));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar usuários FAMILIAR: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping("/buscar/admin/{id}")
    public ResponseEntity<?> buscarAdminPorId(@PathVariable int id) {
        try {
            UsuarioEntity usuario = usuarioService.buscarUsuarioPorIdEPapel(id, Papel.ADMIN);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário ADMIN não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar usuário ADMIN: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @GetMapping("/buscar/cliente/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable int id) {
        try {
            UsuarioEntity usuario = usuarioService.buscarUsuarioPorIdEPapel(id, Papel.CLIENTE);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário CLIENTE não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar usuário CLIENTE: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') and hasRole('ATIVADO')")
    @GetMapping("/buscar/funcionario/{id}")
    public ResponseEntity<?> buscarFuncionarioPorId(@PathVariable int id) {
        try {
            UsuarioEntity usuario = usuarioService.buscarUsuarioPorIdEPapel(id, Papel.FUNCIONARIO);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário FUNCIONARIO não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar usuário FUNCIONARIO: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO') and hasRole('ATIVADO')")
    @GetMapping("/buscar/familiar/{id}")
    public ResponseEntity<?> buscarFamiliarPorId(@PathVariable int id) {
        try {
            UsuarioEntity usuario = usuarioService.buscarUsuarioPorIdEPapel(id, Papel.FAMILIAR);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário FAMILIAR não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar usuário FAMILIAR: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @PutMapping("/atualizar/admin/{id}")
    public ResponseEntity<?> atualizarAdmin(@PathVariable int id, @RequestBody UsuarioEntity usuarioEntity) {
        try {
            if (usuarioEntity.getPapel() == null || usuarioEntity.getPapel().size() != 2 ||
                    !usuarioEntity.getPapel().contains(Papel.ADMIN) ||
                    !usuarioEntity.getPapel().contains(Papel.ATIVADO)) {
                return ResponseEntity.badRequest().body("Para esta rota, os papéis devem ser 'ADMIN' e 'ATIVADO'.");
            }
            usuarioService.atualizarUsuarioPorPapel(id, usuarioEntity, Papel.ADMIN);
            return ResponseEntity.ok("Usuário ADMIN atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário ADMIN: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @PutMapping("/atualizar/cliente/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable int id,@RequestBody UsuarioEntity usuarioEntity) {
        try {
            if (usuarioEntity.getPapel() == null || usuarioEntity.getPapel().size() != 2 ||
                    !usuarioEntity.getPapel().contains(Papel.CLIENTE) ||
                    !usuarioEntity.getPapel().contains(Papel.ATIVADO)) {
                return ResponseEntity.badRequest().body("Para esta rota, os papéis devem ser 'CLIENTE' e 'ATIVADO'.");
            }
            usuarioService.atualizarUsuarioPorPapel(id, usuarioEntity, Papel.CLIENTE);
            return ResponseEntity.ok("Usuário CLIENTE atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário CLIENTE: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') and hasRole('ATIVADO')")
    @PutMapping("/atualizar/funcionario/{id}")
    public ResponseEntity<?> atualizarFuncionario(@PathVariable int id, @RequestBody UsuarioEntity usuarioEntity) {
        try {
            if (usuarioEntity.getPapel() == null || usuarioEntity.getPapel().size() != 2 ||
                !usuarioEntity.getPapel().contains(Papel.FUNCIONARIO) ||
                !usuarioEntity.getPapel().contains(Papel.ATIVADO)) {
                return ResponseEntity.badRequest().body("Para esta rota, os papéis devem ser 'FUNCIONARIO' e 'ATIVADO'.");
            }
            usuarioService.atualizarUsuarioPorPapel(id, usuarioEntity, Papel.FUNCIONARIO);
            return ResponseEntity.ok("Usuário FUNCIONARIO atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário FUNCIONARIO: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO') and hasRole('ATIVADO')")
    @PutMapping("/atualizar/familiar/{id}")
    public ResponseEntity<?> atualizarFamiliar(@PathVariable int id, @RequestBody UsuarioEntity usuarioEntity) {
        try {
            if (usuarioEntity.getPapel() == null || usuarioEntity.getPapel().size() != 2 ||
                    !usuarioEntity.getPapel().contains(Papel.FAMILIAR) ||
                    !usuarioEntity.getPapel().contains(Papel.ATIVADO)) {
                return ResponseEntity.badRequest().body("Para esta rota, os papéis devem ser 'FAMILIAR' e 'ATIVADO'.");
            }
            usuarioService.atualizarUsuarioPorPapel(id, usuarioEntity, Papel.FAMILIAR);
            return ResponseEntity.ok("Usuário FAMILIAR atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário FAMILIAR: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @DeleteMapping("/deletar/admin/{id}")
    public ResponseEntity<?> deletarAdmin(@PathVariable int id) {
        try {
            usuarioService.deletarUsuarioPorPapel(id, Papel.ADMIN);
            return ResponseEntity.ok("Usuário ADMIN deletado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário ADMIN não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar usuário ADMIN: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') and hasRole('ATIVADO')")
    @DeleteMapping("/deletar/cliente/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable int id) {
        try {
            usuarioService.deletarUsuarioPorPapel(id, Papel.CLIENTE);
            return ResponseEntity.ok("Usuário CLIENTE deletado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário CLIENTE não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar usuário CLIENTE: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') and hasRole('ATIVADO')")
    @DeleteMapping("/deletar/funcionario/{id}")
    public ResponseEntity<?> deletarFuncionario(@PathVariable int id) {
        try {
            usuarioService.deletarUsuarioPorPapel(id, Papel.FUNCIONARIO);
            return ResponseEntity.ok("Usuário FUNCIONARIO deletado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário FUNCIONARIO não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar usuário FUNCIONARIO: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO') and hasRole('ATIVADO')")
    @DeleteMapping("/deletar/familiar/{id}")
    public ResponseEntity<?> deletarFamiliar(@PathVariable int id) {
        try {
            usuarioService.deletarUsuarioPorPapel(id, Papel.FAMILIAR);
            return ResponseEntity.ok("Usuário FAMILIAR deletado com sucesso.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário FAMILIAR não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar usuário FAMILIAR: " + e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('ADMIN') or hasRole('CLIENTE')) and hasRole('ATIVADO')")
    @PutMapping("/alternar-status/{id}/{status}")
    public ResponseEntity<?> alternarStatusUsuario(@PathVariable int id, @PathVariable String status) {
        try {
            UsuarioEntity usuario = usuarioService.buscarUsuarioPorId(id);
            String statusFormatado = status.toUpperCase();
            if (!statusFormatado.equals("ATIVADO") && !statusFormatado.equals("DESATIVADO")) {
                return ResponseEntity.badRequest().body("Status inválido. Use 'ATIVADO' ou 'DESATIVADO'.");
            }
            usuarioService.alternarStatusUsuario(id, statusFormatado);
            return ResponseEntity.ok("Status do usuário alternado com sucesso para: " + statusFormatado);
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao alternar status do usuário: " + e.getMessage());
        }
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public ResponseEntity<UsuarioModel> buscarPorFuncionarioId(@PathVariable Integer funcionarioId) {
        return ResponseEntity.ok(usuarioService.buscarPorFuncionarioId(funcionarioId));
    }

    @GetMapping("/admin/{adminId}")
    public ResponseEntity<UsuarioModel> buscarPorAdminId(@PathVariable Integer adminId) {
        return ResponseEntity.ok(usuarioService.buscarPorAdminId(adminId));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<UsuarioModel> buscarPorClienteId(@PathVariable Integer clienteId) {
        return ResponseEntity.ok(usuarioService.buscarPorClienteId(clienteId));
    }

    @GetMapping("/familiar/{familiarId}")
    public ResponseEntity<UsuarioModel> buscarPorFamiliarId(@PathVariable Integer familiarId) {
        return ResponseEntity.ok(usuarioService.buscarPorFamiliarId(familiarId));
    }

    @PreAuthorize("(hasRole('ADMIN') or hasRole('CLIENTE')) and hasRole('ATIVADO')")
    @PutMapping("/inativar/{id}")
    public ResponseEntity<?> inativarUsuario(@PathVariable int id) {
        try {
            usuarioService.inativarUsuario(id);
            return ResponseEntity.ok("Usuário inativado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao inativar usuário: " + e.getMessage());
        }
    }

    @PreAuthorize("(hasRole('ADMIN') or hasRole('CLIENTE')) and hasRole('ATIVADO')")
    @PutMapping("/ativar/{id}")
    public ResponseEntity<?> ativarUsuario(@PathVariable int id) {
        try {
            usuarioService.ativarUsuario(id);
            return ResponseEntity.ok("Usuário ativado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao ativar usuário: " + e.getMessage());
        }
    }
}