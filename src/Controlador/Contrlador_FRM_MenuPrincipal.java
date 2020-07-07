//duda controlador_FRM_MEnuPrincipal

package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_AcercaDe;
import Vista.FRM_ConfiguracionConexion;
import Vista.FRM_Facturacion;
import Vista.FRM_Login;
import Vista.FRM_MantenimientoAdministracionUsuarios;
import Vista.FRM_MantenimientoClientes;
import Vista.FRM_MantenimientoProductos;
import Vista.FRM_MantenimientoProveedores;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controlador.ArchivosBaseDtos;


public class Contrlador_FRM_MenuPrincipal implements ActionListener {
    
    ConexionBD conexion;
     FRM_MantenimientoProductos  frm_MantenimientoProductos;
     FRM_MantenimientoProveedores frm_MantenimientoProveedores;
     FRM_MantenimientoClientes frm_MantenimientoClientes;
     FRM_Facturacion frm_Facturacion;
     FRM_MenuPrincipal frmPrincipal;
     FRM_MantenimientoAdministracionUsuarios frm_mantenimientoUsuarios;
     public FRM_Login frm_login;
     FRM_ConfiguracionConexion frm_adminBD;
     public FRM_MantenimientoAdministracionUsuarios frm_MantenimientoUsuarios;// hago´publicos tembien en la vista
     ArchivosBaseDtos archivosBD;
     FRM_AcercaDe frm_acercaDe;
     
    public Contrlador_FRM_MenuPrincipal(FRM_MenuPrincipal frm_MenuPrincipal) 
    {
       conexion = new ConexionBD();
       this.frmPrincipal=frm_MenuPrincipal;
       frm_MantenimientoProductos = new FRM_MantenimientoProductos(conexion);
       frm_MantenimientoProveedores = new FRM_MantenimientoProveedores(conexion);
       frm_MantenimientoClientes = new FRM_MantenimientoClientes(conexion);
       frm_MantenimientoUsuarios = new FRM_MantenimientoAdministracionUsuarios(conexion);
       frm_Facturacion = new FRM_Facturacion(conexion);
       frm_login = new FRM_Login(frmPrincipal, conexion);
       frm_adminBD = new FRM_ConfiguracionConexion(conexion,frm_MenuPrincipal);
       frm_MenuPrincipal.setVisible(true);
       frm_acercaDe = new FRM_AcercaDe();
      
      archivosBD = new ArchivosBaseDtos();
     
      
      if(archivosBD.recargarArchivos()){
         
          if(conexion.realizarConexion(archivosBD.getDetalle())){
              frm_MenuPrincipal.jmiONLogin();
          }else{
              frm_MenuPrincipal.jmiONAdminConexion();
          }
          
      }else{
              frm_MenuPrincipal.jmiONAdminConexion();
              
              }
      
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
        
         if(e.getActionCommand().equals("Productos"))
         {
           frm_MantenimientoProductos.setVisible(true);
           frm_MantenimientoProductos.estadoInicial();
        }
          if(e.getActionCommand().equals("Cliente"))
        {
            frm_MantenimientoClientes.setVisible(true);
            frm_MantenimientoClientes.estadoInicial();
        }
           if(e.getActionCommand().equals("Provedores"))
        {
           frm_MantenimientoProveedores.setVisible(true);
           frm_MantenimientoProveedores.estadoInicial();
        }
            if(e.getActionCommand().equals("Administracion de Usuarios"))
        {
            frm_MantenimientoUsuarios.setVisible(true);
            frm_MantenimientoUsuarios.estadoInicial();
            frm_MantenimientoUsuarios.cargarInformacion(conexion.reporteUsuarios());
        }
           
            if(e.getActionCommand().equals("Facturacion"))
        {
            frm_Facturacion.setVisible(true);
            frm_Facturacion.estadoInicial();
           
        }
             if(e.getActionCommand().equals("Administración BD"))
        {
            frm_adminBD.setVisible(true);
           
        }
             
             if(e.getActionCommand().equals("Login / Cambiar de usuario"))
        {
             frm_login.setVisible(true);
             frm_login.limpiar();
             frmPrincipal.setVisible(false);
           frmPrincipal.evaluarUsuarios();
          frmPrincipal.cambiarUsuario();
       
           
        }
        
             if(e.getActionCommand().equals("Caja"))
        {
           System.out.println("Caja");
        }
              if(e.getActionCommand().equals("Acerca de"))
        {
           frm_acercaDe.setVisible(true);
        }
               if(e.getActionCommand().equals("Manual de usuarios"))
        {
            System.out.println("Manual");
        }
        
    }
    
}
    
    

