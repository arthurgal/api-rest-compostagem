package br.com.apirest.compostagem.controller;

import br.com.apirest.compostagem.Service.UsuarioService;
import br.com.apirest.compostagem.model.Usuario;
import com.google.cloud.firestore.DocumentReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.concurrent.ExecutionException;

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
}
