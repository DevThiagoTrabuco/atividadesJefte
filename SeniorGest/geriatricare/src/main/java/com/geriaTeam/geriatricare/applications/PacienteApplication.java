package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PacienteRepository;
import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.entities.*;
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
    public void adicionarPaciente(PacienteModels pacienteModels) {
        if (pacienteModels == null) {
            throw new EntityNotFoundException("Paciente não é valido.");
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
        String nomeCompleto = nome + " " + sobrenome;
        return pacienteRepository.buscarPacienteNome(nomeCompleto);
    }
    // Atualizar
    public void atualizarPaciente(PacienteModels pacienteModels) {
        if (pacienteModels == null || pacienteRepository.buscarPacienteId(pacienteModels.getId()) == null) {
            pacienteRepository.atualizarPaciente(pacienteModels);
            throw new EntityNotFoundException("Paciente não é valido.");
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


    public void registrarEntradaPaciente(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.setEntrada(LocalDateTime.now());
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Fazer outras ações como notificar responsáveis ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void registrarSaidaPaciente(int id) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.setSaida(LocalDateTime.now());
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Fazer outras ações como notificar responsáveis ou registrar em algum sistema
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
            pacienteModels.getPacienteFamiliarModels().add(familiar);
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Fazer outras ações necessárias como notificar familiar ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void removerFamiliarPaciente(int id, int idFamiliar) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteFamiliarModels().removeIf(familiar -> familiar.getId() == idFamiliar);
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Fazer outras ações necessárias, como notificar ou registrar a remoção
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
        if (pacienteModels != null) {
            PlanoModels plano = planoRepository.buscarPlanoId(idPlano); // Verifica se o plano existe
            if (plano != null) {
                pacienteModels.setPlanoModels(plano);
                pacienteRepository.atualizarPaciente(pacienteModels);
                // Fazer outras ações necessárias como notificar responsável ou registrar em algum sistema
            } else {
                throw new EntityNotFoundException("Plano de saúde não encontrado.");
            }
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void adicionarMedicamentoPaciente(int id, PacienteMedicamentoModels medicamento) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteMedicamentoModels().add(medicamento);
            atualizarPaciente(pacienteModels);
            // Fazer outras ações necessárias como notificar responsável ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    public void removerMedicamentoPaciente(int id, int idMedicamento) {
        PacienteModels pacienteModels = pacienteRepository.buscarPacienteId(id);
        if (pacienteModels != null) {
            pacienteModels.getPacienteMedicamentoModels().removeIf(medicamento -> medicamento.getId() == idMedicamento);
            pacienteRepository.atualizarPaciente(pacienteModels);
            // Fazer outras ações necessárias como notificar responsável ou registrar em algum sistema
        } else {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
    }

    // Método principal para validar os atributos do paciente

}
