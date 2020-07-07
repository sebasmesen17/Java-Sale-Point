
package Vista;

import Modelo.Usuario;

/**
 *
 * @author Fabricio Vargas
 */
public class JP_InformacionAdministracionUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form JP_InformacionAdministracionUsuarios
     */
    public JP_InformacionAdministracionUsuarios() {
        initComponents();
        llenarTipo();
    }
    public void llenarTipo()
    {
        jcb_Tipo.removeAllItems();
        jcb_Tipo.addItem("admin");
        jcb_Tipo.addItem("cajero");
    }
    
    
    
    public void mostrarInfromacion(Usuario usuario)
    {
        jt_Contrasenia.setText(usuario.getContrasenia());
        jt_NombreCompleto.setText(usuario.getNombreCompleto());
        jt_Usuario.setText(usuario.getUsuario());
        jcb_Tipo.setSelectedItem(usuario.getTipo());
    }
    
    public void habilitarAgregar()
    {
        jt_Contrasenia.setEnabled(true);
        jt_NombreCompleto.setEnabled(true);
        jt_Usuario.setEnabled(false);
        jcb_Tipo.setEnabled(true);
    }
    
    public void estadoInicial()
    {
        jt_Contrasenia.setEnabled(false);
        jt_NombreCompleto.setEnabled(false);
        jt_Usuario.setEnabled(true);
        jcb_Tipo.setEnabled(false); 
        
        jt_Contrasenia.setText("");
        jt_NombreCompleto.setText("");
        jt_Usuario.setText("");
        jcb_Tipo.setSelectedIndex(0);
    }
    public Usuario devolverInformacion()
    {
         Usuario usua = new Usuario(jt_Usuario.getText(),jt_Contrasenia.getText(),jt_NombreCompleto.getText(),""+jcb_Tipo.getSelectedItem());
         return usua;
    }
    public String devolverUsuario()
    {
        return jt_Usuario.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Usuario = new javax.swing.JLabel();
        jl_Contrasenia = new javax.swing.JLabel();
        jl_NombreCompleto = new javax.swing.JLabel();
        jl_Tipo = new javax.swing.JLabel();
        jt_Usuario = new javax.swing.JTextField();
        jt_Contrasenia = new javax.swing.JTextField();
        jt_NombreCompleto = new javax.swing.JTextField();
        jcb_Tipo = new javax.swing.JComboBox();

        jl_Usuario.setText("Usuario:");

        jl_Contrasenia.setText("Contraseña:");

        jl_NombreCompleto.setText("Nombre Completo:");

        jl_Tipo.setText("Tipo:");

        jcb_Tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Usuario)
                    .addComponent(jl_Contrasenia)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jl_Tipo))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jt_Usuario)
                    .addComponent(jt_Contrasenia)
                    .addComponent(jt_NombreCompleto)
                    .addComponent(jcb_Tipo, 0, 142, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Usuario)
                    .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Contrasenia)
                    .addComponent(jt_Contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jl_Tipo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jcb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcb_Tipo;
    private javax.swing.JLabel jl_Contrasenia;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JLabel jl_Tipo;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JTextField jt_Contrasenia;
    private javax.swing.JTextField jt_NombreCompleto;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables
}
