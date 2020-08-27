package idat.edu.pe.appradiocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.le.ScanRecord;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class CheckActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tituloCheckBox;
    private CheckBox chkDeporte, chkVideojuegos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        tituloCheckBox = findViewById(R.id.tvtitulocheck);
        chkDeporte = findViewById(R.id.chkdeporte);
        chkVideojuegos = findViewById(R.id.chkvideojuegos);

        if(getIntent().hasExtra("titulocheck")){
            tituloCheckBox.setText(getIntent().getStringExtra("titulocheck"));
        }

        chkDeporte.setOnClickListener(this);
        chkVideojuegos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CheckBox checkBox = null;
        boolean checkeado = false;

        switch (v.getId()){
            case R.id.chkdeporte:
                checkBox = (CheckBox)v;
                checkeado = checkBox.isChecked();

                if(checkeado){
                    Snackbar.make(v,"Se ha marcado Deporte",Snackbar.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(v,"Se ha desmarcado Deporte",Snackbar.LENGTH_SHORT).show();
                }
            break;
            case R.id.chkvideojuegos:
                checkBox = (CheckBox)v;
                checkeado = checkBox.isChecked();

                if(checkeado){
                    Snackbar.make(v,"Se ha marcado Videojuegos",Snackbar.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(v,"Se ha desmarcado Videojuegos",Snackbar.LENGTH_SHORT).show();
                }
                break;
            default:
                Snackbar.make(v,"Se ha marcado un elemento no mapeado",Snackbar.LENGTH_SHORT).show();
        }

    }
}
