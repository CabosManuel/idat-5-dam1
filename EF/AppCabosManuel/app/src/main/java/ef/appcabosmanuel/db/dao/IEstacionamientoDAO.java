package ef.appcabosmanuel.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ef.appcabosmanuel.db.entity.EstacionamientoEntity;

@Dao
public interface IEstacionamientoDAO {

    @Query("SELECT * FROM estacionamiento ORDER BY codEstacionamiento ASC")
    LiveData<List<EstacionamientoEntity>> getAll();

    @Query("SELECT * FROM estacionamiento WHERE codEstacionamiento=:cod")
    LiveData<EstacionamientoEntity> getEstacionamiento(int cod);

    @Insert
    void insert(EstacionamientoEntity estacionamiento);
}
