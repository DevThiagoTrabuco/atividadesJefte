package com.senai.Geriatricare.controllers;

import com.senai.Geriatricare.enums.Papel;
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

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin")
    public ResponseEntity<?> criarAdminUsuario(@RequestBody UsuarioModel usuarioModel) {
        try {
            if (usuarioModel.getPapel() == null || usuarioModel.getPapel().size() != 1 || !usuarioModel.getPapel().contains(Papel.ADMIN)) {
                return ResponseEntity.badRequest().body("Para esta rota, o papel deve ser apenas 'ADMIN'.");
            }
            usuarioService.criarUsuario(usuarioModel);
            return ResponseEntity.ok("Usuário administrador criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/cliente")
    public ResponseEntity<?> criarClienteUsuario(@RequestBody UsuarioModel usuarioModel) {
        try {
            if (usuarioModel.getPapel() == null || usuarioModel.getPapel().size() != 1 || !usuarioModel.getPapel().contains(Papel.CLIENTE)) {
                return ResponseEntity.badRequest().body("Para esta rota, o papel deve ser apenas 'CLIENTE'.");
            }
            usuarioService.criarUsuario(usuarioModel);
            return ResponseEntity.ok("Usuário cliente criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @PostMapping("/funcionario")
    public ResponseEntity<?> criarFuncionarioUsuario(@RequestBody UsuarioModel usuarioModel) {
        try {
            if (usuarioModel.getPapel() == null || usuarioModel.getPapel().size() != 1 || !usuarioModel.getPapel().contains(Papel.FUNCIONARIO)) {
                return ResponseEntity.badRequest().body("Para esta rota, o papel deve ser apenas 'FUNCIONARIO'.");
            }
            usuarioService.criarUsuario(usuarioModel);
            return ResponseEntity.ok("Usuário funcionário criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @PostMapping("/familiar")
    public ResponseEntity<?> criarFamiliarUsuario(@RequestBody UsuarioModel usuarioModel) {
        try {
            if (usuarioModel.getPapel() == null || usuarioModel.getPapel().size() != 1 || !usuarioModel.getPapel().contains(Papel.FAMILIAR)) {
                return ResponseEntity.badRequest().body("Para esta rota, o papel deve ser apenas 'FAMILIAR'.");
            }
            usuarioService.criarUsuario(usuarioModel);
            return ResponseEntity.ok("Usuário familiar criado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar/admin")
    public ResponseEntity<?> listarUsuariosAdmin() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuariosPorPapel(Papel.ADMIN));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar usuários ADMIN: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listar/cliente")
    public ResponseEntity<?> listarUsuariosCliente() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuariosPorPapel(Papel.CLIENTE));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar usuários CLIENTE: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @GetMapping("/listar/funcionario")
    public ResponseEntity<?> listarUsuariosFuncionario() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuariosPorPapel(Papel.FUNCIONARIO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar usuários FUNCIONARIO: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/listar/familiar")
    public ResponseEntity<?> listarUsuariosFamiliar() {
        try {
            return ResponseEntity.ok(usuarioService.listarUsuariosPorPapel(Papel.FAMILIAR));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao listar usuários FAMILIAR: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/buscar/admin/{id}")
    public ResponseEntity<?> buscarAdminPorId(@PathVariable int id) {
        try {
            UsuarioModel usuario = usuarioService.buscarUsuarioPorIdEPapel(id, Papel.ADMIN);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário ADMIN não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar usuário ADMIN: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/buscar/cliente/{id}")
    public ResponseEntity<?> buscarClientePorId(@PathVariable int id) {
        try {
            UsuarioModel usuario = usuarioService.buscarUsuarioPorIdEPapel(id, Papel.CLIENTE);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário CLIENTE não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar usuário CLIENTE: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @GetMapping("/buscar/funcionario/{id}")
    public ResponseEntity<?> buscarFuncionarioPorId(@PathVariable int id) {
        try {
            UsuarioModel usuario = usuarioService.buscarUsuarioPorIdEPapel(id, Papel.FUNCIONARIO);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário FUNCIONARIO não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar usuário FUNCIONARIO: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @GetMapping("/buscar/familiar/{id}")
    public ResponseEntity<?> buscarFamiliarPorId(@PathVariable int id) {
        try {
            UsuarioModel usuario = usuarioService.buscarUsuarioPorIdEPapel(id, Papel.FAMILIAR);
            return ResponseEntity.ok(usuario);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Usuário FAMILIAR não encontrado com ID: " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao buscar usuário FAMILIAR: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/atualizar/admin")
    public ResponseEntity<?> atualizarAdmin(@RequestBody UsuarioModel usuarioModel) {
        try {
            if (usuarioModel.getPapel() == null || usuarioModel.getPapel().size() != 1 || !usuarioModel.getPapel().contains(Papel.ADMIN)) {
                return ResponseEntity.badRequest().body("Para esta rota, o papel deve ser apenas 'ADMIN'.");
            }
            usuarioService.atualizarUsuarioPorPapel(usuarioModel.getId(), usuarioModel, Papel.ADMIN);
            return ResponseEntity.ok("Usuário ADMIN atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário ADMIN: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/atualizar/cliente")
    public ResponseEntity<?> atualizarCliente(@RequestBody UsuarioModel usuarioModel) {
        try {
            if (usuarioModel.getPapel() == null || usuarioModel.getPapel().size() != 1 || !usuarioModel.getPapel().contains(Papel.CLIENTE)) {
                return ResponseEntity.badRequest().body("Para esta rota, o papel deve ser apenas 'CLIENTE'.");
            }
            usuarioService.atualizarUsuarioPorPapel(usuarioModel.getId(), usuarioModel, Papel.CLIENTE);
            return ResponseEntity.ok("Usuário CLIENTE atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário CLIENTE: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    @PostMapping("/atualizar/funcionario")
    public ResponseEntity<?> atualizarFuncionario(@RequestBody UsuarioModel usuarioModel) {
        try {
            if (usuarioModel.getPapel() == null || usuarioModel.getPapel().size() != 1 || !usuarioModel.getPapel().contains(Papel.FUNCIONARIO)) {
                return ResponseEntity.badRequest().body("Para esta rota, o papel deve ser apenas 'FUNCIONARIO'.");
            }
            usuarioService.atualizarUsuarioPorPapel(usuarioModel.getId(), usuarioModel, Papel.FUNCIONARIO);
            return ResponseEntity.ok("Usuário FUNCIONARIO atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário FUNCIONARIO: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
    @PostMapping("/atualizar/familiar")
    public ResponseEntity<?> atualizarFamiliar(@RequestBody UsuarioModel usuarioModel) {
        try {
            if (usuarioModel.getPapel() == null || usuarioModel.getPapel().size() != 1 || !usuarioModel.getPapel().contains(Papel.FAMILIAR)) {
                return ResponseEntity.badRequest().body("Para esta rota, o papel deve ser apenas 'FAMILIAR'.");
            }
            usuarioService.atualizarUsuarioPorPapel(usuarioModel.getId(), usuarioModel, Papel.FAMILIAR);
            return ResponseEntity.ok("Usuário FAMILIAR atualizado com sucesso.");
        } catch (IllegalArgumentException | EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar usuário FAMILIAR: " + e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
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

    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE') or hasRole('FUNCIONARIO')")
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

}