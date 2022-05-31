package br.com.apirest.compostagem.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Cidadao> lista() throws ExecutionException, InterruptedException {
        return cidadaoService.listaCidadaos();
        }

    @GetMapping("/busca")
    public Cidadao detalha(@RequestParam String cpf) throws ExecutionException, InterruptedException {
        return cidadaoService.detalhaCidadao(cpf);
    }

    @PutMapping("/atualiza/{cpf}")
    public String atualiza(@Valid @PathVariable String cpf, @RequestBody  Cidadao cidadao){
        return cidadaoService.atualizaCidadao(cidadao);

    }

    @DeleteMapping
    public void deleta(@RequestParam String cpf){
        cidadaoService.deletaCidadao(cpf);
    }

}
