
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_MantenimientoProductos;
import Vista.FRM_ReporteProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Controlador_FRM_MantenimientoProductos implements ActionListener,MouseListener{

    

    FRM_MantenimientoProductos frm_MantenimientoProductos;
    FRM_ReporteProductos frm_ReporteProductos;
    ConexionBD conexion;
    public Controlador_FRM_MantenimientoProductos(FRM_MantenimientoProductos frm_MantenimientoProductos, ConexionBD conexion) 
    {
        this.conexion=conexion;
        this.frm_MantenimientoProductos= frm_MantenimientoProductos;
        frm_ReporteProductos= new FRM_ReporteProductos(this);
        
    }
    
    
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Consultar"))
        {
          if( conexion.buscarProducto (frm_MantenimientoProductos.devolverCodigo()))
          {
            frm_MantenimientoProductos.mostrarInformacion(conexion.getProductoTemporal()); 
            frm_MantenimientoProductos.habilitarModificarEliminar();
          }
          else
          {
              frm_MantenimientoProductos.habilitarAgregar();
          }
        }
        if(evento.getActionCommand().equals("Agregar"))
        {
            conexion.registrarProducto(frm_MantenimientoProductos.devolverInformacion());
            frm_MantenimientoProductos.estadoInicial();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            conexion.modificarProducto(frm_MantenimientoProductos.devolverInformacion());
            frm_MantenimientoProductos.estadoInicial();
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            conexion.eliminarProducto(frm_MantenimientoProductos.devolverCodigo());
            frm_MantenimientoProductos.estadoInicial();
        }
        
        if(evento.getActionCommand().equals("Reporte"))
        {
           frm_ReporteProductos.cargarInformacion(conexion.reporteProductos());
           frm_ReporteProductos.setVisible(true);
           
        }
        }

    public void mouseClicked(MouseEvent ev) 
    {
          conexion.buscarProducto(frm_ReporteProductos.devolverCodigo());
           frm_MantenimientoProductos.mostrarInformacion(conexion.getProductoTemporal());
          frm_MantenimientoProductos.habilitarModificarEliminar();
          frm_MantenimientoProductos.setVisible(true);
          frm_ReporteProductos.setVisible(false);
          
    }

    public void mousePressed(MouseEvent ev) 
    {
        
    }

    
    public void mouseReleased(MouseEvent ev) 
    {
       
    }

    
    public void mouseEntered(MouseEvent ev) 
    {
        
    }

    
    public void mouseExited(MouseEvent ev) 
    {
      
    }
    
    }
    
    
    

