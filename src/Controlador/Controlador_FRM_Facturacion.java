
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_Facturacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador_FRM_Facturacion implements ActionListener{
    
    FRM_Facturacion frm_Facturacion;
    public ConexionBD conexion;
    public Controlador_FRM_Facturacion(FRM_Facturacion frm_Facturacion,ConexionBD conexion ) {
        this.frm_Facturacion= frm_Facturacion;
        this.conexion=conexion;
        
    }
    
    
    public void actionPerformed(ActionEvent evento)
    {
      
        if(evento.getActionCommand().equals("Eliminar"))
        {
            frm_Facturacion.eliminar(frm_Facturacion.posicion());
        }
        if(evento.getActionCommand().equals("BuscarCliente"))
        {
            if(conexion.buscarCliente(frm_Facturacion.getCedulaCliente()))
            {
              frm_Facturacion.mostrarNombreCliente(conexion.getClienteTemporal().getNombre());
               
            }
            else
            {
            frm_Facturacion.mostrarMensaje("Cliente no se encuentra registrado");
            }
           
        }
        if(evento.getActionCommand().equals("BuscarProductos"))
        {
            if(conexion.buscarProducto(frm_Facturacion.getCodigoProductos()))
            {
              frm_Facturacion.mostrarNombreProducto(conexion.getProductoTemporal().getNombre());
            }
            else
            {
            frm_Facturacion.mostrarMensaje("Producto no se encuentra registrado");
            }
        }
        if(evento.getActionCommand().equals("Pagar"))
        {
            frm_Facturacion.devolverFactura();
            frm_Facturacion.estadoInicial();
           
        }
        if(evento.getActionCommand().equals("Agregar"))
        {
            frm_Facturacion.agregarRegistro(conexion.getProductoTemporal());
            frm_Facturacion.calcularTotal();
        }
    }
}
