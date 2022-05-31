package br.com.apirest.compostagem.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import br.com.apirest.compostagem.model.Cidadao;
import br.com.apirest.compostagem.model.Endereco;
import com.google.cloud.firestore.*;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;

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
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cidadao> listaCidaos() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("cidadao").get();

        List<QueryDocumentSnapshot> documentos = future.get().getDocuments();

        List<Cidadao> listaCidadaos = documentos.stream().map(c -> {
            Cidadao cidadao = new Cidadao();
            cidadao.setCpf(c.getString("cpf"));
            cidadao.setNome(c.getString("nome"));
            cidadao.setEmail(c.getString("email"));
            cidadao.setTelefone(c.getString("telefone"));
            cidadao.setEndereco(new Endereco(c.getString("endereco.logradouro"),
                    c.getString("endereco.numero"),
                    c.getString("endereco.estado"),
                    c.getString("endereco.cidade"),
                    c.getString("endereco.cep"),
                    c.getString("endereco.bairro")));
            return cidadao;
        }).collect(Collectors.toList());
        return listaCidadaos;
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

    public String atualizaCidadao(Cidadao cidadao){

        try {

            ApiFuture<WriteResult> colecaoEndereco = db.collection("endereco").document(cidadao.getEndereco().getCep()).set(cidadao);
            colecaoEndereco.get().getUpdateTime().toString();

            ApiFuture<WriteResult> colecao = db.collection("cidadao").document(cidadao.getCpf()).set(cidadao);
            return colecao.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deletaCidadao(String cpf){
        ApiFuture<WriteResult> result = db.collection("cidadao").document(cpf).delete();
    }

}
