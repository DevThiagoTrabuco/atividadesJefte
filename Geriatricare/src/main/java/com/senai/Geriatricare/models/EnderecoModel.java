package com.senai.Geriatricare.models;

import com.senai.Geriatricare.entities.EnderecoEntity;
import com.senai.Geriatricare.enums.UnidadeFederativa;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoModel {
    private int id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private UnidadeFederativa UF;
    private String cep;
    private String complemento;

    public EnderecoEntity toEntity(){
        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setId(this.id);
        endereco.setLogradouro(this.logradouro);
        endereco.setNumero(this.numero);
        endereco.setBairro(this.bairro);
        endereco.setCidade(this.cidade);
        endereco.setUnidadeFederativa(this.UF);
        endereco.setCep(this.cep);
        endereco.setComplemento(this.complemento);
        return endereco;
    }
}
