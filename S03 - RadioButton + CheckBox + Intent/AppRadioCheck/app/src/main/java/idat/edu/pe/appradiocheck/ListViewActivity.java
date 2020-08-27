package idat.edu.pe.appradiocheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private TextView tvTituloListView;
    private ListView lvDatos;
    private List<String> listAndroidVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        tvTituloListView = findViewById(R.id.tvtitulolist);
        lvDatos = findViewById(R.id.lvdatos);

        listAndroidVersion = new ArrayList<>();
        listAndroidVersion.add("Pie");
        listAndroidVersion.add("Oreo");
        listAndroidVersion.add("Nougat");
        listAndroidVersion.add("Marshmallow");
        listAndroidVersion.add("Lollipop");
        listAndroidVersion.add("KitKat");
        listAndroidVersion.add("Jellybean");

        //REUTILIZAR EL Adapter del SO
        ArrayAdapter adapterAndroidVer = new ArrayAdapter(
                this, /*CONTEXTO*/
                android.R.layout.simple_list_item_1, /*ESTILO DEL LAYAOUT*/
                listAndroidVersion
        );
        lvDatos.setAdapter(adapterAndroidVer);
        lvDatos.setOnItemClickListener(this);

        if(getIntent().hasExtra("titulolist")){
            tvTituloListView.setText(getIntent().getStringExtra("titulolist"));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(parent == lvDatos){
            String versionAndroid = listAndroidVersion.get(position);
            Toast.makeText(getApplicationContext(), "click en: "+versionAndroid, Toast.LENGTH_SHORT).show();
        }
    }
}
