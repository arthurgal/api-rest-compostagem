package br.com.apirest.compostagem.model;

import javax.validation.constraints.Email;

import org.springframework.lang.Nullable;

import br.com.apirest.compostagem.model.validator.cpf_cnpj.Cpf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cidadao {

    @Nullable
    private String nome;
    @Nullable
    private String endereco;
    @Cpf
    private String cpf;
    @Email
    private String email;

}
