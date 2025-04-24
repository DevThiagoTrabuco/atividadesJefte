package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.models.PacienteFamiliarModels;
import com.geriaTeam.geriatricare.models.PacienteMedicamentoModels;
import com.geriaTeam.geriatricare.models.PacienteModels;

import java.time.LocalDateTime;
import java.util.List;

import com.geriaTeam.geriatricare.models.PlanoModels;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PacienteApplication {
    private PacienteRepository pacienteRepository;
    private PlanoRepository planoRepository;

    @Autowired
    public PacienteApplication(PacienteRepository pacienteRepository, PlanoRepository planoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.planoRepository = planoRepository;
    }

    // Adicionar
    public void adicionar(PacienteModels paciente) {
        pacienteRepository.adicionar(paciente);
    }

    // Remover
    public void remover(int id) {
        PacienteModels paciente = pacienteRepository.buscarPorCodigo(id);
        if (paciente != null) {
            pacienteRepository.remover(id);
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    // Listar Todos
    public List<PacienteModels> listarTodos() {
        return pacienteRepository.buscar();
    }

    // Listar Por ID
    public PacienteModels listarPorId(int id) {
        PacienteModels paciente = pacienteRepository.buscarPorCodigo(id);
        if (paciente != null) {
            return paciente;
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    // Atualizar
    public void atualizar(PacienteModels paciente) {
        PacienteModels existente = pacienteRepository.buscarPorCodigo(paciente.getId());
        if (existente != null) {
            pacienteRepository.atualizar(paciente);
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public String verificarEstadoSaude(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels.getCondicaoMental() != null && pacienteModels.getCondicaoFisica() != null) {
            String estadoMental = pacienteModels.getCondicaoMental().getNome() ;
            String estadoFisico = pacienteModels.getCondicaoFisica().getNome();

            if (estadoMental.equals("Estável") && estadoFisico.equals("Estável")) {
                return "Paciente está estável";
            } else if (estadoMental.equals("Crítico") || estadoFisico.equals("Crítico")) {
                return "Paciente está em estado crítico";
            } else {
                return "Paciente está em estado moderado";
            }
        } else {
            return "Informações de condição de saúde não estão completas";
        }
    }


    public void registrarEntrada(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            pacienteModels.setEntrada(LocalDateTime.now());
            pacienteRepository.atualizar(pacienteModels);
            // Fazer outras ações como notificar responsáveis ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void registrarSaida(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            pacienteModels.setEntrada(null);
            pacienteRepository.atualizar(pacienteModels);
            // Fazer outras ações como notificar responsáveis ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public int calcularIdade(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            LocalDateTime agora = LocalDateTime.now();
            return agora.getYear() - pacienteModels.getNascimento().getYear();
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public List<PacienteMedicamentoModels> verificarHistoricoMedicamentos(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            return pacienteModels.getPacienteMedicamentoModels();
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void adicionarFamiliar(int id, PacienteFamiliarModels familiar) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteFamiliarModels().add(familiar);
            pacienteRepository.atualizar(pacienteModels);
            // Fazer outras ações necessárias como notificar familiar ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void removerFamiliar(int id, int idFamiliar) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteFamiliarModels().removeIf(familiar -> familiar.getId() == idFamiliar);
            pacienteRepository.atualizar(pacienteModels);
            // Fazer outras ações necessárias, como notificar ou registrar a remoção
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public PlanoModels verificarPlanoSaude(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            return pacienteModels.getPlanoModels();
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void atualizarPlanoSaude(int id, int idPlano) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            PlanoModels plano = planoRepository.buscarPorCodigo(idPlano); // Verifica se o plano existe
            if (plano != null) {
                pacienteModels.setPlanoModels(plano);
                pacienteRepository.atualizar(pacienteModels);
                // Fazer outras ações necessárias como notificar responsável ou registrar em algum sistema
            } else {
                throw new EntityNotFoundException("Plano de saúde não encontrado.");
            }
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void adicionarMedicamento(int id, PacienteMedicamentoModels medicamento) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteMedicamentoModels().add(medicamento);
            pacienteRepository.atualizar(pacienteModels);
            // Fazer outras ações necessárias como notificar responsável ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void removerMedicamento(int id, int idMedicamento) {
        PacienteModels pacienteModels = pacienteRepository.buscarPorCodigo(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteMedicamentoModels().removeIf(medicamento -> medicamento.getId() == idMedicamento);
            pacienteRepository.atualizar(pacienteModels);
            // Fazer outras ações necessárias como notificar responsável ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    // Método principal para validar os atributos do paciente

}
