package br.com.apirest.compostagem.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FirebaseInitialize {

    @PostConstruct
    public void initialize(){
        try{

            FileInputStream serviceAccount =
                    new FileInputStream("C:\\api-rest-compostagem\\serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://teste-e77f0-default-rtdb.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }



}
