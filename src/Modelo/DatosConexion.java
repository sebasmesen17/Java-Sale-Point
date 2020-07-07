
package Modelo;

import java.io.Serializable;

public class DatosConexion implements Serializable{
    private String puerto, usuario, password, ip, nombreBD;

    public DatosConexion(String puerto, String usuario, String password, String ip, String nombreBD) {
        this.puerto = puerto;
        this.usuario = usuario;
        this.password = password;
        this.ip = ip;
        this.nombreBD = nombreBD;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }
    
    
}
