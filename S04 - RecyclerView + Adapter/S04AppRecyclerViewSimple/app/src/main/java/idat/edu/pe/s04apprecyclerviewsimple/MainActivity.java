package idat.edu.pe.s04apprecyclerviewsimple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDatos;
    ArrayList<String> listaDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDatos = findViewById(R.id.rvdatos);
        rvDatos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        listaDatos = new ArrayList<>();
        for(int i=0; i<50; i++){
            listaDatos.add("Dato #"+i);
        }
        rvDatos.setAdapter(new AdapterLista(listaDatos));
    }
}
