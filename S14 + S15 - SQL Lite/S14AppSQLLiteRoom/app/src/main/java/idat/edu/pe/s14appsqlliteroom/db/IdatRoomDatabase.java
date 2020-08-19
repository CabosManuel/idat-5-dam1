package idat.edu.pe.s14appsqlliteroom.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import idat.edu.pe.s14appsqlliteroom.db.dao.ITarjetaDao;
import idat.edu.pe.s14appsqlliteroom.db.entity.TarjetaEntity;

@Database(entities = {TarjetaEntity.class}, version = 1)
public abstract class IdatRoomDatabase extends RoomDatabase {

    public abstract ITarjetaDao tarjetaDao();

    private static volatile IdatRoomDatabase INSTANCIA;

    // Valida para solo instaciar una sola vez
    public static IdatRoomDatabase getDatabase(final Context context) {
        if (INSTANCIA == null) {
            synchronized (IdatRoomDatabase.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                            IdatRoomDatabase.class, "idatdatabase").build();
                }
            }
        }
        return INSTANCIA;
    }
}
