package br.com.apirest.compostagem.model;

import br.com.caelum.stella.bean.validation.CNPJ;
import br.com.caelum.stella.bean.validation.CPF;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Email;

@Getter
@Setter
public class Cidadao {

    @Nullable
    private String nome;
    @Nullable
    private Endereco endereco;
    @CPF
    private String cpf;
    @Email
    private String email;

}
