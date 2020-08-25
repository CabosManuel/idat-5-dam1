package ef.appcabosmanuel.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ef.appcabosmanuel.EstacionamientoRepository;
import ef.appcabosmanuel.db.entity.EstacionamientoEntity;

public class EstacionamientoDialogViewModel extends AndroidViewModel {

    private LiveData<List<EstacionamientoEntity>> allEstacionamientos;
    private EstacionamientoRepository estacionamientoRepository;
    
    public EstacionamientoDialogViewModel(@NonNull Application application) {
        super(application);
        estacionamientoRepository = new EstacionamientoRepository(application);
        allEstacionamientos = estacionamientoRepository.getAll();
    }

    public LiveData<List<EstacionamientoEntity>> getAllEstacionamientos(){
        return allEstacionamientos;
    }

    public LiveData<EstacionamientoEntity> getEstacionamiento(int cod){
        return estacionamientoRepository.getEstacionamiento(cod);
    }

    public void insertEstacionamiento(EstacionamientoEntity estacionamientoEntity){
        estacionamientoRepository.insert(estacionamientoEntity);
    }
}
