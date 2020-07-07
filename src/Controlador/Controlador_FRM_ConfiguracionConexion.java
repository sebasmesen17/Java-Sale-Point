/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_ConfiguracionConexion;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author sebas
 */
public class Controlador_FRM_ConfiguracionConexion implements ActionListener{
    
    ConexionBD conexion;
    FRM_ConfiguracionConexion frmBD;
    controlador.ArchivosBaseDtos archivos;
    FRM_MenuPrincipal frm_principal;

    public Controlador_FRM_ConfiguracionConexion(ConexionBD conexion, FRM_ConfiguracionConexion frm,FRM_MenuPrincipal frm_principal) {
        this.conexion = conexion;
        this.frmBD = frm;
        this.frm_principal=frm_principal;
        archivos = new controlador.ArchivosBaseDtos();
    }


    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Realizar Conexión")){
            if(conexion.realizarConexion(frmBD.returnDatos())){
                JOptionPane.showMessageDialog(null,"Conexión realizada correctamente");
                archivos.setDetalle(frmBD.returnDatos());
                frm_principal.jmiONLogin();
                frmBD.setVisible(false);
                
            }else{
                JOptionPane.showMessageDialog(null,"Conexión realizada incorrectamente");
            }
        }
        
        if(e.getActionCommand().equals("Local")){
            frmBD.colocarServerLocal();
        }
        
       if(e.getActionCommand().equals("Remoto")){
            frmBD.colocarServerRemoto();
        }
    
    }
    
   
    
}
