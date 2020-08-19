package idat.edu.pe.appidatgram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Idatgram");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int iditem = item.getItemId();
        String mensaje="";
        if(iditem==R.id.opcionconfig){
            mensaje = "Selecciono Configuración.";
        }else if(iditem==R.id.opcioncamara){
            mensaje = "Selecciono Cámara";
        }

        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
