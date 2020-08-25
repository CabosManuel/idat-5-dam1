package ef.appcabosmanuel.ui;

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

import ef.appcabosmanuel.EstacionamientoDialogFragment;
import ef.appcabosmanuel.R;
import ef.appcabosmanuel.db.entity.EstacionamientoEntity;
import ef.appcabosmanuel.ui.adapter.EstacionamientoAdapter;
import ef.appcabosmanuel.viewmodel.EstacionamientoDialogViewModel;

public class MainActivity extends AppCompatActivity 
        implements View.OnClickListener{

    private RecyclerView rvDatos;
    private FloatingActionButton fabAgregar;
    private EstacionamientoAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvDatos = findViewById(R.id.rvdatos);
        fabAgregar = findViewById(R.id.fabagregar);

        adapter = new EstacionamientoAdapter(this);
        rvDatos.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvDatos.setAdapter(adapter);
        fabAgregar.setOnClickListener(this);
        abrirViewModel();
    }

    private void abrirViewModel() {
        EstacionamientoDialogViewModel tarjetaDialogViewModel = new ViewModelProvider(this)
                .get(EstacionamientoDialogViewModel.class);
        tarjetaDialogViewModel.getAllEstacionamientos().observe(this,
                new Observer<List<EstacionamientoEntity>>() {
                    @Override
                    public void onChanged(List<EstacionamientoEntity> tarjetaEntities) {
                        adapter.setList(tarjetaEntities);
                    }
                });
    }

    private void mostrarDialogTarajeta(){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        EstacionamientoDialogFragment dialogFragment = new EstacionamientoDialogFragment();
        dialogFragment.show(fragmentManager,"NuevoEstacionamientoDialogFragment");
    }

    @Override
    public void onClick(View v) {
        mostrarDialogTarajeta();
    }
}
