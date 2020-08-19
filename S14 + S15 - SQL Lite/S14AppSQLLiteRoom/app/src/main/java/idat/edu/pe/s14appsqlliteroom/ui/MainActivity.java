package idat.edu.pe.s14appsqlliteroom.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import idat.edu.pe.s14appsqlliteroom.R;
import idat.edu.pe.s14appsqlliteroom.TarjetaDialogFragment;
import idat.edu.pe.s14appsqlliteroom.db.entity.TarjetaEntity;
import idat.edu.pe.s14appsqlliteroom.ui.adapter.TarjetaAdapter;
import idat.edu.pe.s14appsqlliteroom.viewmodel.TarjetaDialogViewModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvDatos;
    private FloatingActionButton fabAgregar;
    private TarjetaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvDatos = findViewById(R.id.rvdatos);
        fabAgregar = findViewById(R.id.floatingActionButton);
        adapter = new TarjetaAdapter(this);
        rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvDatos.setAdapter(adapter);
        fabAgregar.setOnClickListener(this);
        abrirViewModel();
    }

    private void abrirViewModel() {
        TarjetaDialogViewModel tarjetaDialogViewModel = new ViewModelProvider(this)
                .get(TarjetaDialogViewModel.class);
        tarjetaDialogViewModel.getAllTarjetas().observe(this,
                new Observer<List<TarjetaEntity>>() {
                    @Override
                    public void onChanged(List<TarjetaEntity> tarjetaEntities) {
                        adapter.setList(tarjetaEntities);
                    }
                });
    }

    private void mostrarDialogTarajeta(){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        TarjetaDialogFragment dialogFragment = new TarjetaDialogFragment();
        dialogFragment.show(fragmentManager,"NuevaTarjetaDialogFragment");
    }

    @Override
    public void onClick(View v) {
        mostrarDialogTarajeta();
    }
}
