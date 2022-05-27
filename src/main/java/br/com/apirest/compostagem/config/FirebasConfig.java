package br.com.apirest.compostagem.config;

import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.common.io.Resources;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import lombok.Cleanup;

@Configuration
public class FirebasConfig {

	@PostConstruct
    public void initialize(){
        try{

        	@Cleanup InputStream serviceAccount = Resources.getResource("serviceAccountKey.json").openStream();
			FirebaseOptions options = FirebaseOptions.builder()
								                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
								                    .setDatabaseUrl("https://teste-e77f0-default-rtdb.firebaseio.com")
								                    .build();
			FirebaseApp.initializeApp(options);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

	@Bean
	public Firestore getFirestore() {
		return FirestoreClient.getFirestore();
	}
}
