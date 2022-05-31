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

    public Endereco(String logradouro, String numero, String estado, String cidade, String cep, String bairro) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
    }
}
