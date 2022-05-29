package br.com.apirest.compostagem.controller;

import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.apirest.compostagem.model.Cidadao;
import br.com.apirest.compostagem.service.CidadaoService;

@RestController
@RequestMapping("/cidadao")
public class CidadaoController {

    @Autowired
    CidadaoService cidadaoService;

    @PostMapping
    public String salva(@Valid @RequestBody Cidadao cidadao){

        return cidadaoService.salvarCidadao(cidadao);

    }

    @GetMapping("/busca")
    public Cidadao detalha(@RequestParam String cpf) throws ExecutionException, InterruptedException {
        return cidadaoService.detalhaCidadao(cpf);
    }

    @PutMapping("/atualiza")
    public String atualiza(@Valid @RequestBody Cidadao cidadao) throws ExecutionException, InterruptedException {
        return cidadaoService.atualizaCidadao(cidadao);

    }

    @DeleteMapping
    public void deleta(@RequestParam String cpf){
        cidadaoService.deletaCidadao(cpf);
    }

}
