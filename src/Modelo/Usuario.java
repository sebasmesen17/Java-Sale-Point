

package Modelo;

import java.io.Serializable;

public class Usuario implements Serializable{
    
    private String usuario;
    private String contrasenia;
    private String nombreCompleto;
    private String tipo;

    public Usuario(String usuario, String contrasenia, String nombreCompleto, String tipo) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombreCompleto = nombreCompleto;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
