package ef.appcabosmanuel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import ef.appcabosmanuel.db.EFRoomDatabase;
import ef.appcabosmanuel.db.dao.IEstacionamientoDAO;
import ef.appcabosmanuel.db.entity.EstacionamientoEntity;

public class EstacionamientoRepository {
    private IEstacionamientoDAO estacionamientoDAO;

    public EstacionamientoRepository(Application application){
        EFRoomDatabase database = EFRoomDatabase
                .getDatabase(application);
        estacionamientoDAO = database.estacionamientoDAO();
    }

    public LiveData<List<EstacionamientoEntity>> getAll(){
        return estacionamientoDAO.getAll();
    }

    public LiveData<EstacionamientoEntity> getEstacionamiento(int cod){
        return estacionamientoDAO.getEstacionamiento(cod);
    }

    public void insert(EstacionamientoEntity estacionamiento){
        new insertAsyncTask(estacionamientoDAO).execute(estacionamiento);
    }

    private static class insertAsyncTask extends AsyncTask<EstacionamientoEntity,Void,Void> {

        private IEstacionamientoDAO estacionamientoDAOAsyncTask;
        insertAsyncTask(IEstacionamientoDAO dao){
            estacionamientoDAOAsyncTask = dao;
        }

        @Override
        protected Void doInBackground(EstacionamientoEntity... estacionamientoEntities) {
            estacionamientoDAOAsyncTask.insert(estacionamientoEntities[0]);
            return null;
        }
    }
}
