package idat.edu.pe.s05apprecilerviewimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import idat.edu.pe.s05apprecilerviewimage.adapter.AndroidAdapter;
import idat.edu.pe.s05apprecilerviewimage.model.Android;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvDatos;
    private AndroidAdapter androidAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDatos = findViewById(R.id.rvdatos);
        rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        androidAdapter = new AndroidAdapter(MainActivity.this);
        rvDatos.setAdapter(androidAdapter);

        ArrayList<Android> lista = new ArrayList<>();
        System.out.println("Agregando servicios...");
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image1,
                "Angel Cake",
                "Android 1.0"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image2,
                "Battenberg",
                "Android 1.1"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image3,
                "CupCake",
                "Android 1.5"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image4,
                "Donut",
                "Android 1.6"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image5,
                "Eclair",
                "Android 2.0-2.1"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image6,
                "Froyo",
                "Android 2.2"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image7,
                "Gingerbread",
                "Android 2.3"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image8,
                "Honneycomb",
                "Android 3.0"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image9,
                "Ice cream sandwich",
                "Android 4.0"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image10,
                "Jelly Bean",
                "Android 4.1"
        ));

        androidAdapter.agregarElementos(lista);
        System.out.println("Lista de servicios: "+lista);
    }


}
