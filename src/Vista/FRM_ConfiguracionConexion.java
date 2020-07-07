
package Vista;

import Controlador.Controlador_FRM_ConfiguracionConexion;
import Modelo.ConexionBD;
import Modelo.DatosConexion;
import javax.swing.ButtonGroup;


public class FRM_ConfiguracionConexion extends javax.swing.JFrame {
ConexionBD conexion;
    Controlador.Controlador_FRM_ConfiguracionConexion controlador_FRM_ConfiguracionConexion;
    
    public FRM_ConfiguracionConexion(ConexionBD conexion, FRM_MenuPrincipal frm_MenuPrincipal) {
        initComponents();
        setLocationRelativeTo(null);
        controlador_FRM_ConfiguracionConexion = new Controlador_FRM_ConfiguracionConexion(conexion, this, frm_MenuPrincipal);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rb_Remoto);
        grupo.add(rb_local);
        rb_Remoto.addActionListener(controlador_FRM_ConfiguracionConexion);
        rb_local.addActionListener(controlador_FRM_ConfiguracionConexion);
        btn_realizarConexion.addActionListener(controlador_FRM_ConfiguracionConexion);
    }
    
    public DatosConexion returnDatos(){
        return new DatosConexion(txt_Puerto.getText(), txt_usuario.getText(), txt_passsword.getText(), txt_dirIP.getText(), txt_nombreBD.getText());
    }
    
    public void colocarServerLocal(){
        txt_dirIP.setText("127.0.0.1");
        txt_dirIP.setEnabled(false);
    }
    
    public void colocarServerRemoto(){
        txt_dirIP.setText("");
        txt_dirIP.setEnabled(true);
    }
    
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_dirIP = new javax.swing.JTextField();
        txt_passsword = new javax.swing.JTextField();
        txt_nombreBD = new javax.swing.JTextField();
        txt_Puerto = new javax.swing.JTextField();
        rb_local = new javax.swing.JRadioButton();
        rb_Remoto = new javax.swing.JRadioButton();
        btn_realizarConexion = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Informacion del servidor al que se realizará conexión");

        jLabel2.setText("Puerto:");

        jLabel3.setText("Usuario:");

        jLabel4.setText("Contraseña:");

        jLabel5.setText("Dirección IP:");

        jLabel6.setText("Nombre de la BD:");

        txt_usuario.setText("root");
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });

        txt_dirIP.setText("127.0.0.1");
        txt_dirIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dirIPActionPerformed(evt);
            }
        });

        txt_passsword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passswordActionPerformed(evt);
            }
        });

        txt_nombreBD.setText("facturacion");
        txt_nombreBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreBDActionPerformed(evt);
            }
        });

        txt_Puerto.setText("3306");
        txt_Puerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PuertoActionPerformed(evt);
            }
        });

        rb_local.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_local.setText("Local");

        rb_Remoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rb_Remoto.setText("Remoto");
        rb_Remoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_RemotoActionPerformed(evt);
            }
        });

        btn_realizarConexion.setText("Realizar Conexión");
        btn_realizarConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_realizarConexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombreBD, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txt_dirIP)
                            .addComponent(txt_Puerto)
                            .addComponent(txt_usuario)
                            .addComponent(txt_passsword))
                        .addGap(37, 37, 37)
                        .addComponent(rb_local)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_Remoto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(btn_realizarConexion)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Puerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_passsword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_dirIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_local)
                    .addComponent(rb_Remoto))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_nombreBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_realizarConexion)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

    private void txt_dirIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dirIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dirIPActionPerformed

    private void txt_passswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passswordActionPerformed

    private void txt_nombreBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreBDActionPerformed

    private void txt_PuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PuertoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PuertoActionPerformed

    private void rb_RemotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_RemotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_RemotoActionPerformed

    private void btn_realizarConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_realizarConexionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_realizarConexionActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_realizarConexion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton rb_Remoto;
    private javax.swing.JRadioButton rb_local;
    private javax.swing.JTextField txt_Puerto;
    private javax.swing.JTextField txt_dirIP;
    private javax.swing.JTextField txt_nombreBD;
    private javax.swing.JTextField txt_passsword;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    
    
}
