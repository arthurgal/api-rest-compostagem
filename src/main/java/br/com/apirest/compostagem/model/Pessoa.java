package br.com.apirest.compostagem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
public class Pessoa {

    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

}
