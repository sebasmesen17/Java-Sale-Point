

package Modelo;


public class DetalleFactura {
    
   int codigo;
   int cantidad;
   int numFactura;

    public DetalleFactura(int codigo, int cantidad,  int numFactura) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.numFactura=numFactura;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
   
}
