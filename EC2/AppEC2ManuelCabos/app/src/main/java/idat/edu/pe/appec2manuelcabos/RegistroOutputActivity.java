package idat.edu.pe.appec2manuelcabos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RegistroOutputActivity extends AppCompatActivity {

    TextView tvDni,tvNombre,tvApellido,tvEmail,tvPass,tvSexo,tvHobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_output);

        tvDni = findViewById(R.id.tvdni);
        tvNombre = findViewById(R.id.tvnombre);
        tvApellido = findViewById(R.id.tvapellido);
        tvEmail = findViewById(R.id.tvemail);
        tvPass = findViewById(R.id.tvpassword);
        tvSexo = findViewById(R.id.tvsexo);
        tvHobbies = findViewById(R.id.tvhobbies);

        if(getIntent().hasExtra("dni")){
            tvDni.setText(getIntent().getStringExtra("dni"));
        }
        if(getIntent().hasExtra("nombre")){
            tvNombre.setText(getIntent().getStringExtra("nombre"));
        }
        if(getIntent().hasExtra("apellido")){
            tvApellido.setText(getIntent().getStringExtra("apellido"));
        }
        if(getIntent().hasExtra("email")){
            tvEmail.setText(getIntent().getStringExtra("email"));
        }
        if(getIntent().hasExtra("pass")){
            tvPass.setText(getIntent().getStringExtra("pass"));
        }
        if(getIntent().hasExtra("sexo")){
            tvSexo.setText(getIntent().getStringExtra("sexo"));
        }
        if(getIntent().hasExtra("hobbies")){
            tvHobbies.setText(getIntent().getStringExtra("hobbies"));
        }
    }
}
