package idat.edu.pe.s14appsqlliteroom.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import idat.edu.pe.s14appsqlliteroom.db.entity.TarjetaEntity;

@Dao
public interface ITarjetaDao {

    @Query("SELECT * FROM tarjeta ORDER BY titulo ASC")
    LiveData<List<TarjetaEntity>> getAll(); //

    @Query("SELECT * FROM tarjeta WHERE id=:idtarjeta")
    LiveData<TarjetaEntity> getTarjeta(int idtarjeta);

    @Insert
    void insert(TarjetaEntity tarjeta);

    @Update
    void update(TarjetaEntity tarjetaEntity);

    @Query("DELETE FROM tarjeta WHERE id=:idtarjeta")
    void deleteById(int idtarjeta);
}
