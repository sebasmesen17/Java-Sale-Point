
package Controlador;

import Modelo.ConexionBD;
import Modelo.Usuario;
import Vista.FRM_MantenimientoAdministracionUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Controlador_FRM_MantenimientoUsuarios implements ActionListener,MouseListener {
    

    FRM_MantenimientoAdministracionUsuarios frm_MantenimientoAdministracionUsuarios;
    Usuario administrador,cajero;
    public ConexionBD conexion;
    public Controlador_FRM_MantenimientoUsuarios( FRM_MantenimientoAdministracionUsuarios frm_MantenimientoAdministracionUsuarios, ConexionBD conexion) 
    {
        this.conexion=conexion;
        this.frm_MantenimientoAdministracionUsuarios=frm_MantenimientoAdministracionUsuarios;
    }


    public void actionPerformed(ActionEvent evento) 
    {
         if(evento.getActionCommand().equals("Consultar"))
         {
           if(conexion.buscarUsuario(frm_MantenimientoAdministracionUsuarios.devolverNombreUsuario()))
     {
         frm_MantenimientoAdministracionUsuarios.mostrarInformacion(conexion.getUsuarioTemporal());
         frm_MantenimientoAdministracionUsuarios.habilitarModificarEliminar();
     }//Fin if
     else
     {
        frm_MantenimientoAdministracionUsuarios.hablitarAgregar();
        
     }
         }
         
         
         
         if(evento.getActionCommand().equals("Agregar"))
         {
             conexion.registrarUsuarios(frm_MantenimientoAdministracionUsuarios.devolverInfo());
            frm_MantenimientoAdministracionUsuarios.estadoInicial();
            frm_MantenimientoAdministracionUsuarios.cargarInformacion(conexion.reporteUsuarios());
         }
         
         
         if(evento.getActionCommand().equals("Modificar"))
         {
             conexion.modificarUsuarios(frm_MantenimientoAdministracionUsuarios.devolverInfo());
            frm_MantenimientoAdministracionUsuarios.estadoInicial();
            frm_MantenimientoAdministracionUsuarios.cargarInformacion(conexion.reporteUsuarios());
         }
         
         
         if(evento.getActionCommand().equals("Eliminar"))
         {
             conexion.eliminarUsuarios(frm_MantenimientoAdministracionUsuarios.devolverNombreUsuario());
            frm_MantenimientoAdministracionUsuarios.estadoInicial();
            frm_MantenimientoAdministracionUsuarios.cargarInformacion(conexion.reporteUsuarios());
         }
         
    }

    
    public void mouseClicked(MouseEvent e) {
        conexion.buscarUsuario(frm_MantenimientoAdministracionUsuarios.devolverUsuario());
           frm_MantenimientoAdministracionUsuarios.mostrarInformacion(conexion.getUsuarioTemporal());
          frm_MantenimientoAdministracionUsuarios.habilitarModificarEliminar();
          
        }

    
    public void mousePressed(MouseEvent e) {
       }

    public void mouseReleased(MouseEvent e) {
      }

     public void mouseEntered(MouseEvent e) {
      }

   public void mouseExited(MouseEvent e) {
        }
    
    
    
    
}
