package idat.edu.pe.appec2manuelcabos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegistro,btnFormulario,btnListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistro = findViewById(R.id.btnregistro);
        btnFormulario = findViewById(R.id.btnformulario);
        btnListado= findViewById(R.id.btnlistado);

        btnRegistro.setOnClickListener(this);
        btnFormulario.setOnClickListener(this);
        btnListado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnregistro:
                startActivity(new Intent(MainActivity.this, RegistroInputActivity.class));
                break;
            case R.id.btnformulario:
                startActivity(new Intent(MainActivity.this, FormularioInputActivity.class));
                break;
            case R.id.btnlistado:
                startActivity(new Intent(MainActivity.this, ListadoActivity.class));
                break;
        }
    }
}
