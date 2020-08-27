package idat.edu.pe.appradiocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class RadioButtonActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton rbtnMujer,rbtnHombre, rbtnOtro;
    private TextView tvTituloRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        rbtnMujer = findViewById(R.id.rbtnmujer);
        rbtnHombre = findViewById(R.id.rbtnhombre);
        rbtnOtro = findViewById(R.id.rbtnotro);
        tvTituloRadio = findViewById(R.id.tvtituloradio);

        //EXISTE EL COMPONENTE(Intent en el MainActivity) CON ESTE NOMBRE?
        if(getIntent().hasExtra("tituloradio")){
            tvTituloRadio.setText(getIntent().getStringExtra("tituloradio"));
        }

        rbtnMujer.setOnClickListener(this);
        rbtnHombre.setOnClickListener(this);
        rbtnOtro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rbtnmujer:
                Snackbar.make(v,"Seleccionó Mujer",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.rbtnhombre:
                Snackbar.make(v,"Seleccionó Hombre",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.rbtnotro:
                Snackbar.make(v,"Seleccionó Otro",Snackbar.LENGTH_SHORT).show();
                break;
        }
    }
}
