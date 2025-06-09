package com.geriaTeam.geriatricare.entities;

import java.util.List;

public interface FuncaoInterface {
    String getNome();
    String getDescricao();
    List<String> getPermissoes();
    boolean possuiPermissao(String permissao);
    boolean validarFuncao();
}