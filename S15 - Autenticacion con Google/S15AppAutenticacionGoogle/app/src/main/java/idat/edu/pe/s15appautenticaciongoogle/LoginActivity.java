package idat.edu.pe.s15appautenticaciongoogle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    private GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        SignInButton btnSign= findViewById(R.id.btnlogin);
        btnSign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Intent del dialogo de Google
                Intent singInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(singInIntent,192);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==192){
            Task<GoogleSignInAccount> accountTask = GoogleSignIn
                    .getSignedInAccountFromIntent(data); // Trae la autenticación del usuario

            // La autenticación es correcta o denegada
            resultadoDeAutenticacion(accountTask);
        }
    }

    private void resultadoDeAutenticacion(Task<GoogleSignInAccount> accountTask) {
        try {
            GoogleSignInAccount account = accountTask.getResult(ApiException.class);
            ingresarAlApp(account);
        }catch (ApiException e){
            Toast.makeText(this, "Autenticación incorrecta", Toast.LENGTH_SHORT).show();
        }
    }

    private void ingresarAlApp(GoogleSignInAccount account) {
        if(account!=null){
            Intent intent = new Intent(this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    intent.FLAG_ACTIVITY_CLEAR_TASK |
                    intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        ingresarAlApp(account);
    }
}

