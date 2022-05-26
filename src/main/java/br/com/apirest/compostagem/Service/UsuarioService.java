package br.com.apirest.compostagem.Service;

import br.com.apirest.compostagem.model.Usuario;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UsuarioService {

    Firestore db = FirestoreClient.getFirestore();

    public String salvarUsuario(Usuario usuario) throws ExecutionException, InterruptedException {

        ApiFuture<WriteResult> colecao = db.collection("usuario").document(usuario.getCpf()).set(usuario);
        return colecao.get().getUpdateTime().toString();
    }


    public Usuario detalhaUsuario(String cpf) throws ExecutionException, InterruptedException {

        DocumentReference documentReference = db.collection("usuario").document(cpf);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();
        Usuario usuario;
        if (documentSnapshot.exists()){
            usuario = documentSnapshot.toObject(Usuario.class);
            return usuario;
        }
        return null;
    }

    public String atualizaUsuario(Usuario usuario) throws ExecutionException, InterruptedException {

        ApiFuture<WriteResult> colecao = db.collection("usuario").document(usuario.getCpf()).set(usuario);
        return colecao.get().getUpdateTime().toString();
    }

    public void deletaUsuario(String cpf){
        ApiFuture<WriteResult> result = db.collection("usuario").document(cpf).delete();
    }

}
