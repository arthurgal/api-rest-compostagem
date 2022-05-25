package br.com.apirest.compostagem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
public class Usuario {

    private String nome;
    private String endereco;
    private String cpf;
    private String email;

}
