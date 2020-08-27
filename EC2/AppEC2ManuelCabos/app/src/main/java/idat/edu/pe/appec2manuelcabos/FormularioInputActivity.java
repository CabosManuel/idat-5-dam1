package idat.edu.pe.appec2manuelcabos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class FormularioInputActivity extends AppCompatActivity implements View.OnClickListener{

    private CheckBox chkDisminucion, chkTos,chkGarganta,chkNasal,chkNinguno,
                        chkLuz,chkAgua,chkInternet,chkCable;
    private RadioButton rbtnFiebreSi,rbtnFiebreNo,
                        rbtnCasaSi,rbtnCasaNo,
                        rbtnAdultoSi,rbtnAdultoNo;
    private Button btnResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_input);

        chkDisminucion = findViewById(R.id.chkdisminucion);
        chkTos = findViewById(R.id.chktos);
        chkGarganta = findViewById(R.id.chkgarganta);
        chkNasal = findViewById(R.id.chknasal);
        chkNinguno = findViewById(R.id.chkninguno);
        chkLuz = findViewById(R.id.chkluz);
        chkAgua = findViewById(R.id.chkagua);
        chkInternet = findViewById(R.id.chkinternet);
        chkCable = findViewById(R.id.chkcable);
        rbtnFiebreSi = findViewById(R.id.rbtnfiebresi);
        rbtnFiebreNo = findViewById(R.id.rbtnfiebreno);
        rbtnCasaSi = findViewById(R.id.rbtncasasi);
        rbtnCasaNo = findViewById(R.id.rbtncasano);
        rbtnAdultoSi = findViewById(R.id.rbtnadultosi);
        rbtnAdultoNo = findViewById(R.id.rbtnadultono);
        btnResolver = findViewById(R.id.btnresolver);

        btnResolver.setOnClickListener(this);
        chkNinguno.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.chkninguno:

                boolean checkeado = chkNinguno.isChecked();

                if (checkeado) {
                    chkDisminucion.setChecked(false);
                    chkTos.setChecked(false);
                    chkGarganta.setChecked(false);
                    chkNasal.setChecked(false);
                    chkDisminucion.setEnabled(false);
                    chkTos.setEnabled(false);
                    chkGarganta.setEnabled(false);
                    chkNasal.setEnabled(false);
                } else {
                    chkDisminucion.setEnabled(true);
                    chkTos.setEnabled(true);
                    chkGarganta.setEnabled(true);
                    chkNasal.setEnabled(true);
                }
                break;
        }

    }

}
