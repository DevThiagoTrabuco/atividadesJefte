package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.entities.PlanoInterface;
import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.factories.PlanoFactory;
import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.geriaTeam.geriatricare.entities.PlanoAvancado.obterBeneficiosPlanoAvancado;
import static com.geriaTeam.geriatricare.entities.PlanoBasico.obterBeneficiosPlanoBasico;
import static com.geriaTeam.geriatricare.entities.PlanoIntermediario.obterBeneficiosPlanoIntermediario;

@Service
public class PlanoApplication {

    private final PlanoRepository planoRepository;

    private static final double PRECO_BASICO = 99.90;
    private static final double PRECO_INTERMEDIARIO = 199.90;
    private static final double PRECO_AVANCADO = 299.90;

    @Autowired
    public PlanoApplication(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public void adicionarPlano(PlanoModels planoModels) {
        criarPlanosPadraoSeNaoExistirem();

        if (planoModels == null) {
            throw new IllegalArgumentException("Plano não pode ser nulo.");
        }

        // Use Optional para buscar planos por id e nome
        boolean planoExistePorId = planoRepository.buscarPlanoId(planoModels.getId()).isPresent();
        boolean planoExistePorNome = planoRepository.buscarPlanoNome(planoModels.getNome()).stream().findAny().isPresent();

        if (planoExistePorId || planoExistePorNome) {
            throw new IllegalArgumentException("Plano já existe.");
        }

        planoRepository.adicionarPlano(planoModels);
    }

    public void atualizarPlano(int codigo, PlanoModels planoAtualizado) {
        Optional<PlanoModels> planoExistente = planoRepository.buscarPlanoId(codigo);
        if (planoExistente.isEmpty()) {
            throw new IllegalArgumentException("Plano com ID " + codigo + " não encontrado.");
        }

        if (planoAtualizado.getNome() != null) planoExistente.get().setNome(planoAtualizado.getNome());
        if (planoAtualizado.getTipoPlano() != null) planoExistente.get().setTipoPlano(planoAtualizado.getTipoPlano());
        if (planoAtualizado.getPeriodoMensalidade() != 0) planoExistente.get().setPeriodoMensalidade(planoAtualizado.getPeriodoMensalidade());
        if (planoAtualizado.getDescricao() != null) planoExistente.get().setDescricao(planoAtualizado.getDescricao());
        if (planoAtualizado.getPreco() != 0.0) planoExistente.get().setPreco(planoAtualizado.getPreco());
        if (planoAtualizado.getBeneficio() != null) planoExistente.get().setBeneficio(planoAtualizado.getBeneficio());

        planoRepository.atualizarPlano(planoExistente.orElse(null));
    }

    public void removerPlano(int codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("Código do plano não pode ser negativo.");
        }

        boolean existePlano = planoRepository.buscarPlanoId(codigo).isPresent();
        if (!existePlano) {
            throw new IllegalArgumentException("Plano com código " + codigo + " não encontrado.");
        }

        planoRepository.removerPlano(codigo);
    }

    public List<PlanoModels> buscar() {
        List<PlanoModels> planos = planoRepository.buscarPlano();
        if (planos == null || planos.isEmpty()) {
            throw new IllegalArgumentException("Nenhum plano encontrado.");
        }
        return planos;
    }

    public PlanoModels buscarPlanoId(int codigo) {
        return planoRepository.buscarPlanoId(codigo)
                .orElseThrow(() -> new RuntimeException("Plano com código " + codigo + " não encontrado."));
    }

    public List<PlanoModels> buscarPlanoNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do plano não pode ser nulo ou vazio.");
        }

        List<PlanoModels> planos = planoRepository.buscarPlanoNome(nome.trim());
        if (planos == null || planos.isEmpty()) {
            throw new RuntimeException("Nenhum plano encontrado com o nome: " + nome);
        }

        return planos;
    }

    private void criarPlanosPadraoSeNaoExistirem() {
        PlanoFactory planoFactory = new PlanoFactory();

        for (TipoPlanoEnums tipoPlano : TipoPlanoEnums.values()) {
            String nomePlano = getNomePorTipo(tipoPlano);
            List<PlanoModels> planosExistentes = planoRepository.buscarPlanoNome(nomePlano);

            // Considerando que buscarPlanoNome retorna lista, verificar se está vazio
            if (planosExistentes == null || planosExistentes.isEmpty()) {
                PlanoInterface plano = planoFactory.criarPlano(tipoPlano);
                configurarPlano(plano, tipoPlano);
                planoRepository.adicionarPlano(plano.toModel());
            }
        }
    }

    private void configurarPlano(PlanoInterface plano, TipoPlanoEnums tipoPlano) {
        plano.setNome(getNomePorTipo(tipoPlano));
        plano.setDescricao(getDescricaoPorTipo(tipoPlano));
        plano.setPeriodoMensalidade(30);
        plano.setTipoPlano(tipoPlano);
        plano.setBeneficio(obterBeneficiosPorPlano(tipoPlano));
        plano.setPreco(obterPreco(tipoPlano));
    }

    private String getNomePorTipo(TipoPlanoEnums tipoPlano) {
        return switch (tipoPlano) {
            case PLANO_BASICO -> "Plano Basico";
            case PLANO_INTERMEDIARIO -> "Plano Intermediario";
            case PLANO_AVANCADO -> "Plano Avancado";
            default -> "Plano Desconhecido";
        };
    }

    private String getDescricaoPorTipo(TipoPlanoEnums tipoPlano) {
        return switch (tipoPlano) {
            case PLANO_BASICO -> "Plano Básico com benefícios limitados";
            case PLANO_INTERMEDIARIO -> "Plano Intermediário com benefícios intermediários";
            case PLANO_AVANCADO -> "Plano Avançado com benefícios completos";
            default -> "";
        };
    }

    public static String obterBeneficiosPorPlano(TipoPlanoEnums tipoPlano) {
        List<String> beneficios = new ArrayList<>();

        switch (tipoPlano) {
            case PLANO_BASICO -> beneficios.addAll(obterBeneficiosPlanoBasico());
            case PLANO_INTERMEDIARIO -> beneficios.addAll(obterBeneficiosPlanoIntermediario());
            case PLANO_AVANCADO -> beneficios.addAll(obterBeneficiosPlanoAvancado());
            default -> throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlano);
        }

        return String.join(", ", beneficios);
    }

    public static double obterPreco(TipoPlanoEnums tipoPlano) {
        return switch (tipoPlano) {
            case PLANO_BASICO -> PRECO_BASICO;
            case PLANO_INTERMEDIARIO -> PRECO_INTERMEDIARIO;
            case PLANO_AVANCADO -> PRECO_AVANCADO;
            default -> throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlano);
        };
    }
}
