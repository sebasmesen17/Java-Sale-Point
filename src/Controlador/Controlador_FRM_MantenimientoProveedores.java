
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_MantenimientoProveedores;
import Vista.FRM_ReporteProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Controlador_FRM_MantenimientoProveedores implements ActionListener,MouseListener{

    FRM_ReporteProveedores frm_ReporteProveedores;
    FRM_MantenimientoProveedores frm_MantenimientoProveedores;
    ConexionBD conexion;
    public Controlador_FRM_MantenimientoProveedores(FRM_MantenimientoProveedores frm_MantenimientoProveedores, ConexionBD conexion) {
        this.conexion=conexion;

        frm_ReporteProveedores= new FRM_ReporteProveedores(this);
        this.frm_MantenimientoProveedores= frm_MantenimientoProveedores;
    }//Fin constructor
    
    public void actionPerformed(ActionEvent evento)
{
if(evento.getActionCommand().equals("Consultar"))
{
  if(conexion.buscarProveedor(frm_MantenimientoProveedores.devolverCedula()))
  {
      frm_MantenimientoProveedores.habilitarModificarEliminar();
      frm_MantenimientoProveedores.mostrarInformacion(conexion.getProveedoresTemporal());
  }//Fin if
  else
  {
      frm_MantenimientoProveedores.habilitarAgregar();
  }//Fin else
}//Fin if 1

if(evento.getActionCommand().equals("Agregar"))
{
   conexion.registrarProveedores(frm_MantenimientoProveedores.devolverInformacion());
   frm_MantenimientoProveedores.estadoInicial();
}//Fin if 2

if(evento.getActionCommand().equals("Modificar"))
{
   conexion.modificarProveedores(frm_MantenimientoProveedores.devolverInformacion());
   frm_MantenimientoProveedores.estadoInicial();
}//Fin if 3

if(evento.getActionCommand().equals("Eliminar"))
{
   conexion.eliminarProveedor(frm_MantenimientoProveedores.devolverCedula());
   frm_MantenimientoProveedores.estadoInicial();
}//Fin if 4
if(evento.getActionCommand().equals("Reporte"))
{
  frm_ReporteProveedores.cargarInformacion(conexion.reporteProveedores());
  frm_ReporteProveedores.setVisible(true);
}//Fin if 4

}//Fin actionPerformed

    public void mouseClicked(MouseEvent e) {
     conexion.buscarProveedor(frm_ReporteProveedores.devolverCedula());
           frm_MantenimientoProveedores.mostrarInformacion(conexion.getProveedoresTemporal());
          frm_MantenimientoProveedores.habilitarModificarEliminar();
          frm_MantenimientoProveedores.setVisible(true);
          frm_ReporteProveedores.setVisible(false);
    }//Fin mouseClicked

   
    public void mousePressed(MouseEvent e) {
      
    }//Fin mousePressed

    public void mouseReleased(MouseEvent e) {
        
    }

   
    public void mouseEntered(MouseEvent e) {
        
    }//Fin mouseEntered

   
    public void mouseExited(MouseEvent e) {
      
    }//Fin mouseExited
    
    
    
}//Fin class

