package br.com.apirest.compostagem.controller;

import br.com.apirest.compostagem.Service.UsuarioService;
import br.com.apirest.compostagem.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public String salva(@RequestBody Usuario usuario) throws ExecutionException, InterruptedException {

        return usuarioService.salvarUsuario(usuario);

    }
}
