package br.com.apirest.compostagem.model;

import br.com.apirest.compostagem.validacaoCpf.Cpf;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Email;

@Getter
@Setter
public class Usuario {

    private String nome;
    private String endereco;
    @Cpf
    private String cpf;
    @Email
    private String email;

}
