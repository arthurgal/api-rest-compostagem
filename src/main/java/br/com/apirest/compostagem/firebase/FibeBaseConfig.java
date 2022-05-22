package br.com.apirest.compostagem.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

@Configuration
public class FibeBaseConfig {

    @Bean
    public Firestore firestore() throws Exception{
    FileInputStream serviceAccount =
            new FileInputStream("C:\\compostagem\\src\\main\\resources\\serviceAccountKey.json");

    FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();

    FirebaseApp fireBaseApp = FirebaseApp.initializeApp(options);
    return FirestoreClient.getFirestore(fireBaseApp);

    }

}
