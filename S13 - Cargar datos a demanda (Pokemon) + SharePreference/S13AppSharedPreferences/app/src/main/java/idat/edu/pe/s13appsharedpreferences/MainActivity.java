package idat.edu.pe.s13appsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText etUser, etPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser = findViewById(R.id.etuser);
        etPass = findViewById(R.id.etpass);
        btnLogin = findViewById(R.id.btnlogin);

        SharedPreferences preferences = getSharedPreferences("appIDAT",MODE_PRIVATE);
        if(preferences.contains("user")){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();
                // Consumir el webservice de autentificación
                SharedPreferences.Editor editor = getSharedPreferences("appIDAT",MODE_PRIVATE).edit();
                editor.putString("user",user);
                editor.putString("pass",pass);
                editor.apply();
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
                finish();
            }
        });
    }
}
