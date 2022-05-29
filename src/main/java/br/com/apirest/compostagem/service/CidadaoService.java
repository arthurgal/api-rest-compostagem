package br.com.apirest.compostagem.service;

import java.util.concurrent.ExecutionException;

import br.com.apirest.compostagem.model.Cidadao;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

@Service
public class CidadaoService {

	private Firestore db;
	
	public CidadaoService(Firestore db) {
		this.db = db;
	}
		
    public String salvarCidadao(Cidadao cidadao){

        try {

            ApiFuture<WriteResult> colecaoEndereco = db.collection("endereco").document(cidadao.getEndereco().getCep()).set(cidadao);
            colecaoEndereco.get().getUpdateTime().toString();

            ApiFuture<WriteResult> colecao = db.collection("cidadao").document(cidadao.getCpf()).set(cidadao);
            return colecao.get().getUpdateTime().toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cidadao detalhaCidadao(String cpf) throws ExecutionException, InterruptedException {

        DocumentReference documentReference = db.collection("cidadao").document(cpf);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();
        Cidadao cidadao;
        if (documentSnapshot.exists()){
            cidadao = documentSnapshot.toObject(Cidadao.class);
            return cidadao;
        }
        return null;
    }

    public String atualizaCidadao(Cidadao cidadao) throws ExecutionException, InterruptedException {

        ApiFuture<WriteResult> colecao = db.collection("cidadao").document(cidadao.getCpf()).set(cidadao);
        return colecao.get().getUpdateTime().toString();
    }

    public void deletaCidadao(String cpf){
        ApiFuture<WriteResult> result = db.collection("cidadao").document(cpf).delete();
    }

}
