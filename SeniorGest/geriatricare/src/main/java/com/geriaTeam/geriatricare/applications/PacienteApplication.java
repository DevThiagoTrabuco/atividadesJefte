package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.FamiliarRepository;
import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.entities.*;
import com.geriaTeam.geriatricare.models.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteApplication {
    private final PacienteRepository pacienteRepository;
    private final PlanoRepository planoRepository;
    private final FamiliarRepository familiarRepository;

    @Autowired
    public PacienteApplication(PacienteRepository pacienteRepository, PlanoRepository planoRepository, FamiliarRepository familiarRepository) {
        this.pacienteRepository = pacienteRepository;
        this.planoRepository = planoRepository;
        this.familiarRepository = familiarRepository;
    }

    // Adicionar
    public void adicionarPaciente(PacienteModels pacienteModels) {
        if (pacienteModels == null) {
            throw new EntityNotFoundException("Paciente não é válido.");
        }
        Paciente paciente = new Paciente();
        RG rg = new RG();
        CPF cpf = new CPF();

        cpf.setNumero(pacienteModels.getCpf());
        rg.setNumero(pacienteModels.getRg());

        if(!cpf.validarCPF()) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if(!rg.validarRG()) {
            throw new IllegalArgumentException("RG inválido.");
        }

        paciente.setId(pacienteModels.getId());
        paciente.setNome(pacienteModels.getNome());
        paciente.setSobrenome(pacienteModels.getSobrenome());
        paciente.setPacienteFamiliarModels(pacienteModels.getPacienteFamiliarModels());
        paciente.setRg(rg);
        paciente.setCpf(cpf);
        paciente.setEntrada(null);
        paciente.setSaida(null);
        paciente.setCondicaoMental(pacienteModels.getCondicaoMental());
        paciente.setCondicaoFisica(pacienteModels.getCondicaoFisica());
        paciente.setPacienteMedicamentoModels(pacienteModels.getPacienteMedicamentoModels());
        paciente.setPacienteFamiliarModels(pacienteModels.getPacienteFamiliarModels());
        paciente.setPlanoModels(pacienteModels.getPlanoModels());
        paciente.setNascimento(pacienteModels.getNascimento());

        pacienteRepository.adicionarPaciente(paciente.toModel());
    }

    // Remover
    public void removerPaciente(int id) {
        PacienteModels paciente = pacienteRepository.buscarPacienteId(id);
        if (paciente != null) {
            pacienteRepository.removerPaciente(id);
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    // Listar Todos
    public List<PacienteModels> buscarTodosPacientes() {
        return pacienteRepository.buscarPaciente();
    }

    // Listar Por ID
    public PacienteModels buscarPacienteId(int id) {
        PacienteModels paciente = pacienteRepository.buscarPacienteId(id);
        if (paciente != null) {
            return paciente;
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public List<PacienteModels> buscarPacienteNome(String nome, String sobrenome) {
        String nomeCompleto = nome + sobrenome;
        return pacienteRepository.buscarPacienteNome(nomeCompleto);
    }

    // Atualizar
    public void atualizarPaciente(PacienteModels pacienteModels) {
        if (pacienteModels == null || pacienteRepository.buscarPacienteId(pacienteModels.getId()) == null) {
            throw new EntityNotFoundException("Paciente não é válido.");
        }
        Paciente paciente = new Paciente();
        RG rg = new RG();
        CPF cpf = new CPF();

        cpf.setNumero(pacienteModels.getCpf());
        rg.setNumero(pacienteModels.getRg());

        if(!cpf.validarCPF()) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        if(!rg.validarRG()) {
            throw new IllegalArgumentException("RG inválido.");
        }

        paciente.setId(pacienteModels.getId());
        paciente.setNome(pacienteModels.getNome());
        paciente.setSobrenome(pacienteModels.getSobrenome());
        paciente.setPacienteFamiliarModels(pacienteModels.getPacienteFamiliarModels());
        paciente.setRg(rg);
        paciente.setCpf(cpf);
        paciente.setEntrada(pacienteModels.getEntrada());
        paciente.setSaida(pacienteModels.getSaida());
        paciente.setCondicaoMental(pacienteModels.getCondicaoMental());
        paciente.setCondicaoFisica(pacienteModels.getCondicaoFisica());
        paciente.setPacienteMedicamentoModels(pacienteModels.getPacienteMedicamentoModels());
        paciente.setPacienteFamiliarModels(pacienteModels.getPacienteFamiliarModels());
        paciente.setPlanoModels(pacienteModels.getPlanoModels());
        paciente.setNascimento(pacienteModels.getNascimento());

        pacienteRepository.atualizarPaciente(paciente.toModel());
    }

    public String verificarEstadoSaudePaciente(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels.getCondicaoMental() != null && pacienteModels.getCondicaoFisica() != null) {
            String estadoMental = pacienteModels.getCondicaoMental().getNome();
            String estadoFisico = pacienteModels.getCondicaoFisica().getNome();

            if ("Estável".equals(estadoMental) && "Estável".equals(estadoFisico)) {
                return "Paciente está estável";
            } else if ("Crítico".equals(estadoMental) || "Crítico".equals(estadoFisico)) {
                return "Paciente está em estado crítico";
            } else {
                return "Paciente está em estado moderado";
            }
        } else {
            return "Informações de condição de saúde não estão completas";
        }
    }

    public void registrarEntradaPaciente(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.setEntrada(LocalDateTime.now());
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Outras ações (notificações, logs etc)
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void registrarSaidaPaciente(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.setSaida(LocalDateTime.now());
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Outras ações (notificações, logs etc)
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public int calcularIdadePaciente(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            LocalDateTime agora = LocalDateTime.now();
            return agora.getYear() - pacienteModels.getNascimento().getYear();
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentosPaciente(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            return pacienteModels.getPacienteMedicamentoModels();
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void adicionarFamiliarPaciente(int id, PacienteFamiliarModels familiar) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            FamiliarModels familiarModels = familiarRepository.buscarFamiliarId(familiar.getFamiliarId());
            if (familiarModels == null) {
                throw new EntityNotFoundException("Familiar não encontrado.");
            }
            pacienteModels.getPacienteFamiliarModels().add(familiar);
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Outras ações (notificações, logs etc)
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void removerFamiliarPaciente(int id, int idFamiliar) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteFamiliarModels().removeIf(familiar -> familiar.getId() == idFamiliar);
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Outras ações (notificações, logs etc)
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public PlanoModels verificarPlanoSaudePaciente(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            return pacienteModels.getPlanoModels();
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void atualizarPlanoSaudePaciente(int id, int idPlano) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels == null) {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }

        PlanoModels plano = planoRepository.buscarPlanoId(idPlano)
                .orElseThrow(() -> new EntityNotFoundException("Plano de saúde não encontrado."));

        pacienteModels.setPlanoModels(plano);
        pacienteRepository.atualizarPaciente(pacienteModels);
        // Outras ações (notificações, logs etc)
    }

    public void adicionarMedicamentoPaciente(int id, PacienteMedicamentoModels medicamento) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteMedicamentoModels().add(medicamento);
            atualizarPaciente(pacienteModels);
            // Outras ações (notificações, logs etc)
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void removerMedicamentoPaciente(int id, int idMedicamento) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteMedicamentoModels().removeIf(medicamento -> medicamento.getId() == idMedicamento);
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Outras ações (notificações, logs etc)
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    // Você pode adicionar outros métodos auxiliares conforme necessário

}
