package idat.edu.pe.s10appvolleyrecyclerpicasso.modelo;

public class Flor {
    private String etiqueta;
    private String usuario;
    private String urlImagen;

    public Flor(String etiqueta, String usuario, String urlImagen) {
        this.etiqueta = etiqueta;
        this.usuario = usuario;
        this.urlImagen = urlImagen;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
