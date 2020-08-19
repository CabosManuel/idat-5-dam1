package idat.edu.pe.appandroid01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etTalla,etPeso;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //poner en el contenido el layout

        //INSTANCIA A LOS CONTROLES Layout
        etTalla = findViewById(R.id.etTalla);
        etPeso = findViewById(R.id.etPeso);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Funciona :D",Toast.LENGTH_LONG).show();

                if(etTalla.getText().toString().equals("")){
                    etTalla.setError("Ingrese su talla");
                }else if(etPeso.getText().toString().equals("")){
                    etPeso.setError("Ingrese su peso");
                }else{
                    Double peso,talla,tallam,imc;
                    String resultadoIMC="";
                    peso = Double.parseDouble(etPeso.getText().toString());
                    talla = Double.parseDouble(etTalla.getText().toString());
                    tallam = talla/100;
                    imc = peso/(tallam*tallam);
                    if(imc<=18.5){
                        resultadoIMC="Por debajo del peso";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCBajo));
                    }else if(imc<=25){
                        resultadoIMC="Con peso normal";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCNormal));
                    }else if(imc<=30){
                        resultadoIMC ="Con sobrepeso";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCSobrePeso));
                    }else if(imc<=35){
                        resultadoIMC = "Obesidad leve";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCObsesidad1));
                    }else if(imc<=39){
                        resultadoIMC = "Obesidad media";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCObsesidad2));
                    }else{
                        resultadoIMC = "Obesidad mórbida";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCObsesidad3));
                    }
                    tvResultado.setText("Tu valo de IMC es: "+ imc.toString() + "\n" +
                                        "Ud. se encuentra: "+resultadoIMC);

                    //Toast.makeText(getApplicationContext(),"TODO OK",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
