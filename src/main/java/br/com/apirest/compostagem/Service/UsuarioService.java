package br.com.apirest.compostagem.Service;

import br.com.apirest.compostagem.model.Usuario;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UsuarioService {

    public String salvarUsuario(Usuario usuario) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> colecao = db.collection("usuario").document().set(usuario);
        return colecao.get().getUpdateTime().toString();
    }

}
