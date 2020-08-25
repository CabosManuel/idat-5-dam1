package ef.appcabosmanuel.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="estacionamiento")
public class EstacionamientoEntity {
    @PrimaryKey(autoGenerate = true)
    public int codEstacionamiento;
    public String nombreEstacionamiento;
    public int aforoMax;
    public String incluyeLavado;
    public String estado;

    public EstacionamientoEntity(int codEstacionamiento, String nombreEstacionamiento, int aforoMax, String incluyeLavado, String estado) {
        this.codEstacionamiento = codEstacionamiento;
        this.nombreEstacionamiento = nombreEstacionamiento;
        this.aforoMax = aforoMax;
        this.incluyeLavado = incluyeLavado;
        this.estado = estado;
    }

    public int getCodEstacionamiento() {
        return codEstacionamiento;
    }

    public void setCodEstacionamiento(int codEstacionamiento) {
        this.codEstacionamiento = codEstacionamiento;
    }

    public String getNombreEstacionamiento() {
        return nombreEstacionamiento;
    }

    public void setNombreEstacionamiento(String nombreEstacionamiento) {
        this.nombreEstacionamiento = nombreEstacionamiento;
    }

    public int getAforoMax() {
        return aforoMax;
    }

    public void setAforoMax(int aforoMax) {
        this.aforoMax = aforoMax;
    }

    public String getIncluyeLavado() {
        return incluyeLavado;
    }

    public void setIncluyeLavado(String incluyeLavado) {
        this.incluyeLavado = incluyeLavado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
