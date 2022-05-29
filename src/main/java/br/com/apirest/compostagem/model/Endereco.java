package br.com.apirest.compostagem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class Endereco {

    @Nullable
    private String logradouro;
    @Nullable
    private String cep;
    @Nullable
    private String numero;
    @Nullable
    private String bairro;
    @Nullable
    private String cidade;
    @Nullable
    private String estado;

}
