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

import br.com.apirest.compostagem.model.Usuario;
import br.com.apirest.compostagem.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public String salva(@Valid @RequestBody Usuario usuario) throws ExecutionException, InterruptedException {

        return usuarioService.salvarUsuario(usuario);

    }

    @GetMapping("/busca")
    public Usuario detalha(@RequestParam String cpf) throws ExecutionException, InterruptedException {
        return usuarioService.detalhaUsuario(cpf);
    }

    @PutMapping("/atualiza")
    public String atualiza(@Valid @RequestBody Usuario usuario) throws ExecutionException, InterruptedException {
        return usuarioService.atualizaUsuario(usuario);

    }

    @DeleteMapping
    public void deleta(@RequestParam String cpf){
        usuarioService.deletaUsuario(cpf);
    }

}
