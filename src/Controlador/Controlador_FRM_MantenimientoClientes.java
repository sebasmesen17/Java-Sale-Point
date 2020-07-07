
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_MantenimientoClientes;
import Vista.FRM_ReporteClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Controlador_FRM_MantenimientoClientes implements ActionListener,MouseListener{

    FRM_MantenimientoClientes frm_MantenimientoClientes;
    FRM_ReporteClientes frm_ReporteClientes;
    ConexionBD conexion;
    public Controlador_FRM_MantenimientoClientes(FRM_MantenimientoClientes frm_MantenimientoClientes, ConexionBD conexion) 
    {
        this.frm_MantenimientoClientes=  frm_MantenimientoClientes;
        frm_ReporteClientes= new FRM_ReporteClientes(this);
        this.conexion=conexion;
    }//Fin constructor

public void actionPerformed(ActionEvent evento)
{
 if(evento.getActionCommand().equals("Consultar"))
 {
     if(conexion.buscarCliente(frm_MantenimientoClientes.devolverCedula()))
     {
         frm_MantenimientoClientes.mostrarInformacion(conexion.getClienteTemporal());
         frm_MantenimientoClientes.habilitarModificarEliminar();
     }//Fin if
     else
     {
        frm_MantenimientoClientes.habilitarAgregar();
     }//Fin del else
 }//Fin if
 if(evento.getActionCommand().equals("Agregar"))
 {
     conexion.registrarCliente(frm_MantenimientoClientes.devolverInformacion());
     frm_MantenimientoClientes.estadoInicial();
 }//Fin if
 if(evento.getActionCommand().equals("Modificar"))
 {
     conexion.modificarCliente(frm_MantenimientoClientes.devolverInformacion());
     frm_MantenimientoClientes.estadoInicial();
 }//Fin if
 if(evento.getActionCommand().equals("Eliminar"))
 {
     conexion.eliminarCliente(frm_MantenimientoClientes.devolverCedula());
     frm_MantenimientoClientes.estadoInicial();
 }//Fin if
 
 if(evento.getActionCommand().equals("Reporte"))
 {
   frm_ReporteClientes.cargarInformacion(conexion.reporteClientes());
     frm_ReporteClientes.setVisible(true); 
 }//Fin if
 
}//Fin actionPerformed

    
    public void mouseClicked(MouseEvent e) 
    {
       conexion.buscarCliente(frm_ReporteClientes.devolverCedula());
       frm_MantenimientoClientes.mostrarInformacion(conexion.getClienteTemporal());
       System.out.println("temporal");
       frm_MantenimientoClientes.habilitarModificarEliminar();
        System.out.println("temporal1");
       frm_MantenimientoClientes.setVisible(true);
        System.out.println("temporal2");
        frm_ReporteClientes.setVisible(false);
    }//Fin mouseClicked

    public void mousePressed(MouseEvent e) {
         
    }//Fin mousePressed

    public void mouseReleased(MouseEvent e) {
       
    }//Fin mouseReleased

    public void mouseEntered(MouseEvent e) {
         
    }//Fin mouseEntered

    
    public void mouseExited(MouseEvent e) {
        
    }//Fin mouseExited
    
}//Fin class
