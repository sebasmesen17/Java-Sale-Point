
package Vista;


import Controlador.Controlador_FRM_Login;
import Modelo.ConexionBD;





public class FRM_Login extends javax.swing.JFrame  {

    Controlador_FRM_Login controlador;
    public FRM_MenuPrincipal principal;
  

    ConexionBD conexion;
    public FRM_Login(FRM_MenuPrincipal principal, ConexionBD conexion ) 
    {
        initComponents();
        this.conexion=conexion;
        this.principal=principal;
        controlador= new Controlador_FRM_Login(this,conexion, principal);
        btn_Ingresar.addActionListener(controlador);
        this.setLocationRelativeTo(null);
      
    }
    
     public String devolverUsuario()
    {
        return jt_Usuario.getText();
    }
     
     public String devolverContra(){
         return jpf_Contrasenia.getText();
     }//FIn del método
     
    public void mostrarMenu()
    {
        principal.setVisible(true);
      
  }
    
    public void limpiar(){
    jt_Usuario.setText("");
    jpf_Contrasenia.setText("");
    
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Usuario = new javax.swing.JLabel();
        jl_Contrasenia = new javax.swing.JLabel();
        btn_Ingresar = new javax.swing.JButton();
        jt_Usuario = new javax.swing.JTextField();
        jpf_Contrasenia = new javax.swing.JPasswordField();

        jl_Usuario.setFont(new java.awt.Font("DejaVu Sans Light", 0, 18)); // NOI18N
        jl_Usuario.setText("Usuario:");

        jl_Contrasenia.setFont(new java.awt.Font("DejaVu Sans Light", 0, 18)); // NOI18N
        jl_Contrasenia.setText("Contraseña:");

        btn_Ingresar.setFont(new java.awt.Font("DejaVu Sans Light", 0, 18)); // NOI18N
        btn_Ingresar.setText("Ingresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jl_Usuario)
                        .addGap(100, 100, 100)
                        .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(btn_Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jl_Contrasenia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpf_Contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Usuario)
                    .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpf_Contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Contrasenia))
                .addGap(26, 26, 26)
                .addComponent(btn_Ingresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Ingresar;
    private javax.swing.JLabel jl_Contrasenia;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jpf_Contrasenia;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables

}
