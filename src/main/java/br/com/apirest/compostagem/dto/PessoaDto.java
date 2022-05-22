package br.com.apirest.compostagem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {

    private String id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

}
