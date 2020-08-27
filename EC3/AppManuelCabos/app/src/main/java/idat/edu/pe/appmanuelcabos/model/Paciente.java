package idat.edu.pe.appmanuelcabos.model;

public class Paciente {
    private int codPaciente;
    private String contraseña;
    private String nombreApellido;
    private String celular;

    public Paciente(int codPaciente, String contraseña, String nombreApellido, String celular) {
        this.codPaciente = codPaciente;
        this.contraseña = contraseña;
        this.nombreApellido = nombreApellido;
        this.celular = celular;
    }

    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
