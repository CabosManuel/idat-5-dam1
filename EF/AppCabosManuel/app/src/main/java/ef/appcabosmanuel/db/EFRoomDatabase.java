package ef.appcabosmanuel.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ef.appcabosmanuel.db.dao.IEstacionamientoDAO;
import ef.appcabosmanuel.db.entity.EstacionamientoEntity;

@Database(entities = {EstacionamientoEntity.class}, version = 1)
public abstract class EFRoomDatabase extends RoomDatabase {
    public abstract IEstacionamientoDAO estacionamientoDAO();

    private static volatile EFRoomDatabase INSTANCIA;

    public static EFRoomDatabase getDatabase(final Context context) {
        if (INSTANCIA == null) {
            synchronized (EFRoomDatabase.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(),
                            EFRoomDatabase.class, "BDPlayaEstacionamiento").build();
                }
            }
        }
        return INSTANCIA;
    }
}
