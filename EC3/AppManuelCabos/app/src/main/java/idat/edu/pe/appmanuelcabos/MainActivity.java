package idat.edu.pe.appmanuelcabos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import idat.edu.pe.appmanuelcabos.model.Paciente;

public class MainActivity extends AppCompatActivity{

    private TextInputEditText etCodigo,etContraseña;
    private Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo = findViewById(R.id.etcodpaciente);
        etContraseña = findViewById(R.id.etcontraseña);
        btnIngresar = findViewById(R.id.btningresar);

        final List<Paciente> listaPacientes = new ArrayList<>();
        listaPacientes.add(new Paciente(1,"123456","Manuel Cabos","987654321"));
        listaPacientes.add(new Paciente(2,"654321","German Apolaya","987654321"));
        listaPacientes.add(new Paciente(3,"159753","Dina Gouro","987654321"));

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etCodigo.getText().toString().equals("")){
                    etCodigo.setError("Ingrese un código");
                }
                if(etContraseña.getText().toString().equals("")){
                    etContraseña.setError("Ingrese contraseña");
                }else {
                    int codigo = Integer.parseInt(etCodigo.getText().toString());
                    String contraseña = etContraseña.getText().toString();

                    for (Paciente p : listaPacientes) {
                        if (p.getCodPaciente() == codigo && p.getContraseña().equals(contraseña)) {
                            startActivity(new Intent(MainActivity.this, MenuActivity.class));
                            break;
                        } else if(p.getCodPaciente()==listaPacientes.size()){
                            Toast.makeText(MainActivity.this, "Código y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}
