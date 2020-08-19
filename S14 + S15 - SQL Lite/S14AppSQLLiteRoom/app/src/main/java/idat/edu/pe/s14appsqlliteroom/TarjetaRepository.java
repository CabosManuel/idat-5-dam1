package idat.edu.pe.s14appsqlliteroom;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import idat.edu.pe.s14appsqlliteroom.db.IdatRoomDatabase;
import idat.edu.pe.s14appsqlliteroom.db.dao.ITarjetaDao;
import idat.edu.pe.s14appsqlliteroom.db.entity.TarjetaEntity;

// Contiene métodos del DAO
public class TarjetaRepository{
    private ITarjetaDao tarjetaDao;

    public TarjetaRepository(Application application) {
        IdatRoomDatabase database = IdatRoomDatabase
                .getDatabase(application);
        tarjetaDao = database.tarjetaDao();
    }

    public LiveData<List<TarjetaEntity>> getAll(){
        return tarjetaDao.getAll();
    }

    public LiveData<TarjetaEntity> getTarjeta(int idtarjeta){
        return tarjetaDao.getTarjeta(idtarjeta);
    }

    public void insert(TarjetaEntity tarjeta){
        new insertAsyncTask(tarjetaDao).execute(tarjeta);
    }

    // Async Task
    // Anteriormente utilizado en WebServices
    private static class insertAsyncTask extends AsyncTask<TarjetaEntity,Void,Void>{

        private ITarjetaDao tarjetaDaoAsyncTask;
        insertAsyncTask(ITarjetaDao dao){
            tarjetaDaoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(TarjetaEntity... tarjetaEntities) {
            tarjetaDaoAsyncTask.insert(tarjetaEntities[0]);
            return null;
        }
    }

    public void update(TarjetaEntity tarjeta){
        new updateAsyncTask(tarjetaDao).execute(tarjeta);
    }

    private static class updateAsyncTask extends AsyncTask<TarjetaEntity,Void,Void>{

        private ITarjetaDao tarjetaDaoAsyncTask;
        updateAsyncTask(ITarjetaDao dao){
            tarjetaDaoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(TarjetaEntity... tarjetaEntities) {
            tarjetaDaoAsyncTask.update(tarjetaEntities[0]);
            return null;
        }
    }

    public void delete(Integer idTarjeta){
        new deleteAsyncTask(tarjetaDao).execute(idTarjeta);
    }

    private static class deleteAsyncTask extends AsyncTask<Integer,Void,Void>{

        private ITarjetaDao tarjetaDaoAsyncTask;
        deleteAsyncTask(ITarjetaDao dao){
            tarjetaDaoAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            tarjetaDaoAsyncTask.deleteById(integers[0]);
            return null;
        }
    }
}
