package br.com.apirest.compostagem.controller;

import br.com.apirest.compostagem.Service.UsuarioService;
import br.com.apirest.compostagem.model.Usuario;
import com.google.cloud.firestore.DocumentReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{nome}")
    public Usuario detalha(@PathVariable String nome) throws ExecutionException, InterruptedException {
        return usuarioService.detalhaUsuario(nome);
    }
}
