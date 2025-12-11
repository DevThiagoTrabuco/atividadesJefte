package com.senai.Geriatricare.entities;

import com.senai.Geriatricare.models.EnderecoModel;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import com.senai.Geriatricare.entities.commons.CEP;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoEntity {
    private int id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private UnidadeFederativa uf; // Renomeado de unidadeFederativa
    private CEP cep;
    private String complemento;

    public EnderecoModel toEntity(){
        EnderecoModel endereco = new EnderecoModel();
        endereco.setId(this.id);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);
        endereco.setUnidadeFederativa(this.uf); // Atualizado
        endereco.setCep(this.cep.validaCEP() ? this.cep.getCep() : null);
        endereco.setComplemento(this.complemento);
        return endereco;
    }
}
