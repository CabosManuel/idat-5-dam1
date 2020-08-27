package idat.edu.pe.appec2manuelcabos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistroInputActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputEditText etDni, etNombre, etApellido, etEmail, etPassword, etOtro;
    private RadioButton rbtnHombre, rdbtnMujer;
    private CheckBox chkDeporte, chkPintura, chkOtro;
    private Button btnAcceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_input);

        etDni = findViewById(R.id.etdni);
        etNombre = findViewById(R.id.etnombre);
        etApellido = findViewById(R.id.etapellido);
        etEmail = findViewById(R.id.etemail);
        etPassword = findViewById(R.id.etpassowrd);
        rbtnHombre = findViewById(R.id.rbtnhombre);
        rdbtnMujer = findViewById(R.id.rbtnmujer);
        chkDeporte = findViewById(R.id.chkdeporte);
        chkPintura = findViewById(R.id.chkpintura);
        chkOtro = findViewById(R.id.chkotro);
        etOtro = findViewById(R.id.etotro);
        btnAcceder = findViewById(R.id.btnacceder);

        btnAcceder.setOnClickListener(this);
        chkOtro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.chkotro:

                boolean checkeado = chkOtro.isChecked();

                if (checkeado) {
                    etOtro.setEnabled(true);
                } else {
                    etOtro.setText("");
                    etOtro.setEnabled(false);
                }
                break;

            case R.id.btnacceder:

                String dni = etDni.getText().toString(),
                        nombre = etNombre.getText().toString(),
                        apellido = etApellido.getText().toString(),
                        email = etEmail.getText().toString(),
                        password = etPassword.getText().toString(),
                        otro = etOtro.getText().toString();
                boolean hombre = rbtnHombre.isChecked(),
                        mujer = rdbtnMujer.isChecked(),
                        deporte = chkDeporte.isChecked(),
                        pintura = chkPintura.isChecked(),
                        otros = chkOtro.isChecked();

                if(validar(dni,nombre,apellido,email,password,otro,hombre,mujer,deporte,pintura,otros)){
                    Intent inttout = new Intent(RegistroInputActivity.this, RegistroOutputActivity.class);
                    inttout.putExtra("dni",dni);
                    inttout.putExtra("nombre",nombre);
                    inttout.putExtra("apellido",apellido);
                    inttout.putExtra("email",email);
                    inttout.putExtra("pass",password);

                    if(hombre){ inttout.putExtra("sexo",rbtnHombre.getText());}
                    else{ inttout.putExtra("sexo",rdbtnMujer.getText());}

                    String hobbies="";
                    if(deporte) {
                        hobbies += chkDeporte.getText();
                    }if(pintura) {
                        if (!hobbies.equals("")) {
                            hobbies += ", ";
                        }
                        hobbies += chkPintura.getText();
                    }if(otros){
                        if(!hobbies.equals("")) {
                            hobbies += ", ";
                        }
                        hobbies+=otro;
                    }
                    inttout.putExtra("hobbies",hobbies);

                    startActivity(inttout);
                }

                break;
        }
    }

    private boolean validar(String dni, String nombre, String apellido, String email, String password, String otro, boolean hombre, boolean mujer, boolean deporte, boolean pintura, boolean otros) {
        boolean valido = true;

        if (dni.equals("") || dni.length() < 8){
            etDni.setError("Ingrese un DNI correcto");
            valido=false;
        }if (nombre.equals("")){
            etNombre.setError("Ingrese un nombre");
            valido=false;
        }if (apellido.equals("")){
            etApellido.setError("Ingrese un apellido");
            valido=false;
        }if (email.equals("")){
            etEmail.setError("Ingrese un email");
            valido=false;
        }if (password.equals("")){
            etPassword.setError("Ingrese una contraseña");
            valido=false;
        }if (hombre == false && mujer == false){
            Toast.makeText(this, "Seleccione un sexo", Toast.LENGTH_SHORT).show();
            valido=false;
        }if (deporte == false && pintura == false && otros == false){
            Toast.makeText(this, "Seleccione al menos un hobby", Toast.LENGTH_SHORT).show();
            valido=false;
        }if (otros && otro.equals("")){
            etOtro.setError("Ingrese sus otros hobbies");
            valido=false;
        }

        return valido;
    }

}
