
package Modelo;


public class Proveedores {

private String cedula;
private String nombreEmpresa;
private String telefono;
private String correo;
private String nombreContacto;

    public Proveedores(String cedula, String nombreEmpresa, String telefono, String correo, String nombreContacto) {
        this.cedula = cedula;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
        this.correo = correo;
        this.nombreContacto = nombreContacto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    
}
