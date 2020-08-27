package idat.edu.pe.appmanuelcabos.model;

public class Dato {
    private Integer albumId;
    private Integer id;
    private String titulo;
    private String miniaturaUrl;

    public Dato(Integer albumId, Integer id, String titulo, String miniaturaUrl) {
        this.albumId = albumId;
        this.id = id;
        this.titulo = titulo;
        this.miniaturaUrl = miniaturaUrl;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMiniaturaUrl() {
        return miniaturaUrl;
    }

    public void setMiniaturaUrl(String miniaturaUrl) {
        this.miniaturaUrl = miniaturaUrl;
    }
}
