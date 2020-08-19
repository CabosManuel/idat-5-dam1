package idat.edu.pe.s14appsqlliteroom.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import idat.edu.pe.s14appsqlliteroom.TarjetaRepository;
import idat.edu.pe.s14appsqlliteroom.db.entity.TarjetaEntity;

public class TarjetaDialogViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel

    private LiveData<List<TarjetaEntity>> allTarjetas;
    private TarjetaRepository tarjetaRepository;

    public TarjetaDialogViewModel(@NonNull Application application){
        super(application);
        tarjetaRepository = new TarjetaRepository(application);
        allTarjetas = tarjetaRepository.getAll();
    }

    public LiveData<List<TarjetaEntity>> getAllTarjetas(){
        return allTarjetas;
    }

    public LiveData<TarjetaEntity> getTarjeta(int idtarjeta){
        return tarjetaRepository.getTarjeta(idtarjeta);
    }

    public void insertTarjeta(TarjetaEntity tarjetaEntity){
        tarjetaRepository.insert(tarjetaEntity);
    }

    public void updateTarjeta(TarjetaEntity tarjetaEntity){
        tarjetaRepository.update(tarjetaEntity);
    }

    public void deleteTarjeta(int idTarjeta){
        tarjetaRepository.delete(idTarjeta);
    }
}
