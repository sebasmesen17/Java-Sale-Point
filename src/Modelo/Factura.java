

package Modelo;

import java.util.ArrayList;


public class Factura {
    
  private int numero;
  private String fecha;
  private String usuario;
  private String cedulaCliente;
  private String tipoPago;


    public Factura(int numero, String fecha, String usuario, String cedulaCliente, String tipoPago) {
        this.numero = numero;
        this.fecha = fecha;
        this.usuario = usuario;
        this.cedulaCliente = cedulaCliente;
        this.tipoPago = tipoPago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

  
}
