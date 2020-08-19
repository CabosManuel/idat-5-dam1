package idat.edu.pe.appidatgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin;
    private TextInputEditText etUsu, etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnlogin);
        etUsu = findViewById(R.id.tvusuario);
        etPass = findViewById(R.id.etpass);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
    }
}
