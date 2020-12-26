package idat.edu.pe.appradiocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCheck,btnRadio,btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheck = findViewById(R.id.btnchek);
        btnRadio = findViewById(R.id.btnradio);
        btnList = findViewById(R.id.btnlist);

        btnCheck.setOnClickListener(this);
        btnRadio.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        
        // Todo es switch es para los distintos botones que tengas
        
        switch (v.getId()){
            case R.id.btnchek:
                
                // Acá iría el "enabled = true"
                
                
                // Esto ignoralo en todos, son otras funciones ---------------------------------------------
                Toast.makeText(getApplicationContext(),"Hizo click en btn Check",Toast.LENGTH_SHORT).show();
                Intent inttcheck = new Intent(MainActivity.this, CheckActivity.class);
                inttcheck.putExtra("titulocheck","Ejemplo CHECKBOX");
                startActivity(inttcheck);
                // -----------------------------------------------------------------------------------------
                
                break;
            case R.id.btnradio:
                Toast.makeText(getApplicationContext(),"Hizo click en btn RadioButton",Toast.LENGTH_SHORT).show();
                Intent inttradio = new Intent(MainActivity.this, RadioButtonActivity.class);
                inttradio.putExtra("tituloradio","Ejemplo RADIOBUTTON");
                startActivity(inttradio);
                break;

            case R.id.btnlist:
                Toast.makeText(getApplicationContext(),"Hizo click en btn ListView",Toast.LENGTH_SHORT).show();
                Intent inttlist = new Intent(MainActivity.this, ListViewActivity.class);
                inttlist.putExtra("titulolist","Ejemplo LISTVIEW");
                startActivity(inttlist);
                break;
            default:
                Toast.makeText(getApplicationContext(),"Hizo click en un btn no mapeado",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

