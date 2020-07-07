

package Controlador;

import Modelo.ConexionBD;
import Modelo.Usuario;
import Vista.FRM_Login;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class Controlador_FRM_Login implements ActionListener {

    Usuario usuario;
    FRM_Login frm_login;
    ConexionBD conexion;
    public static String tipo="";
    Controlador_FRM_MantenimientoUsuarios controador_FRM_AdministracionUsuarios;
    FRM_MenuPrincipal frm_principal;
    
    public Controlador_FRM_Login(FRM_Login frm_login, ConexionBD conexion, FRM_MenuPrincipal frm_principal) 
    {
        this.conexion= conexion;
        this.frm_login=frm_login;
        this.frm_principal=frm_principal;
     //   frm_principal= new FRM_MenuPrincipal();

    }
    
   public void mostrarLogin(){
       frm_login.mostrarMenu();
 }
    
    public void actionPerformed(ActionEvent e) {
       
   
         if(e.getActionCommand().equals("Ingresar"))
         {
              
           if(conexion.verificarUsuario(frm_login.devolverUsuario(), frm_login.devolverContra()))
           {

                  frm_login.mostrarMenu();
                  frm_login.setVisible(false);
                  tipo=conexion.getUsuarioTemporal().getTipo();
                  
                  if(tipo.equals("admin")){
                      frm_principal.jmiONAdmin();
                  }else{
                      frm_principal.jmiONCajeros();
                  }
              
           }else {
              
              
              JOptionPane.showMessageDialog(null,"Los datos no coinciden, vuelava a ingresarlos");
           }
           frm_login.principal.evaluarUsuarios();
                    
         }
    }
        
    }//class
    

