package com.geriaTeam.geriatricare.repositories.mySQL;

import com.geriaTeam.geriatricare.Interfaces.IndicadorRepository;
import com.geriaTeam.geriatricare.models.domain.Indicador;
import com.geriaTeam.geriatricare.repositories.jpa.IndicadorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IndicadorRepositoryMySQLImpl implements IndicadorRepository {
    private final IndicadorJPA indicadorJPA;

    @Autowired
    public IndicadorRepositoryMySQLImpl(IndicadorJPA indicadorJPA) {
        this.indicadorJPA = indicadorJPA;
    }

    @Override
    public Indicador buscarPorCodigo(int codigo) {
        return this.indicadorJPA.findById(codigo).get();
    }

    @Override
    public List<Indicador> buscar() {
        return this.indicadorJPA.findAll();
    }

    @Override
    public void adicionar(Indicador indicador) {
        this.indicadorJPA.save(indicador);
    }

    @Override
    public void remover(int codigo) {
        this.indicadorJPA.deleteById(codigo);
    }

    @Override
    public void atualizar(int codigo, Indicador indicador) {
        Indicador indicadorDB = this.indicadorJPA.findById(codigo).get();
        
        indicadorDB.setOximetria(indicador.getOximetria());
        indicadorDB.setBatimentos(indicador.getBatimentos());
        indicadorDB.setTemperatura(indicador.getTemperatura());

        this.indicadorJPA.save(indicadorDB);
    }
}
