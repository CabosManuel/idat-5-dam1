package idat.edu.pe.s09appfragmentmenu.model;

public class Flor {
    private String etiquetas;
    private String urlImagen;

    public Flor(String etiquetas, String urlImagen) {
        this.etiquetas = etiquetas;
        this.urlImagen = urlImagen;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
