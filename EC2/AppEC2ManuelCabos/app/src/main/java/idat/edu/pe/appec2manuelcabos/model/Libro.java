package idat.edu.pe.appec2manuelcabos.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Libro implements Parcelable{
    private int id,imagen;
    Integer anio;
    private String titulo,descripcion;

    public Libro(int id, int imagen, int anio, String titulo, String descripcion) {
        this.id = id;
        this.imagen = imagen;
        this.anio = anio;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    protected Libro(Parcel in) {
        id = in.readInt();
        imagen = in.readInt();
        anio = in.readInt();
        titulo = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Libro> CREATOR = new Creator<Libro>() {
        @Override
        public Libro createFromParcel(Parcel in) {
            return new Libro(in);
        }

        @Override
        public Libro[] newArray(int size) {
            return new Libro[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(imagen);
        dest.writeInt(anio);
        dest.writeString(titulo);
        dest.writeString(descripcion);
    }
}