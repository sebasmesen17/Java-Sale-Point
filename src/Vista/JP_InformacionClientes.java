

package Vista;

import Modelo.Clientes;

public class JP_InformacionClientes extends javax.swing.JPanel {

    /**
     * Creates new form JP_InformacionClientes
     */
    public JP_InformacionClientes() {
        initComponents();
        llenarTipo();
    }
    public void llenarTipo()
    {
     jcb_Genero.removeAllItems();//Elimina todos los item de la lista
     jcb_Genero.addItem("Hombre");
     jcb_Genero.addItem("Mujer");
    }//Fin metodo llenar tipo
    
    public void mostrarInformacion(Clientes cliente)
    {
      jt_Cedulaa.setText(cliente.getCedula());
      jt_Direccion.setText(cliente.getDireccion());
      jt_Nombre.setText(cliente.getNombre());
      jt_Telefono.setText(cliente.getTelefono());
      jsp_Edad.setValue(cliente.getEdad());
      jcb_Genero.setSelectedItem(cliente.getGenero());
    }//Fin metodo mostrarInformacion
    
    public void habilitarAgregar()
    {
      jt_Cedulaa.setEnabled(false);
      jt_Direccion.setEnabled(true);
      jt_Nombre.setEnabled(true);
      jt_Telefono.setEnabled(true);
      jsp_Edad.setEnabled(true);
      jcb_Genero.setEnabled(true);
    }//Fin metodo habilitarAgregar
    
    public Clientes devolverInformacion()
    {
        Clientes cliente = new Clientes(jt_Cedulaa.getText(),jt_Nombre.getText(),jt_Direccion.getText(),jt_Telefono.getText(),Integer.parseInt(""+jsp_Edad.getValue()),""+jcb_Genero.getSelectedItem());
        return cliente;
    }//Fin metodo devolverInformacion

    public void estadoInicial()
    {
      jt_Cedulaa.setEnabled(true);
      jt_Direccion.setEnabled(false);
      jt_Nombre.setEnabled(false);
      jt_Telefono.setEnabled(false);
      jsp_Edad.setEnabled(false);
      jcb_Genero.setEnabled(false);
      
      jt_Cedulaa.setText("");
      jt_Direccion.setText("");
      jt_Nombre.setText("");
      jt_Telefono.setText("");
      jsp_Edad.setValue(0);
      jcb_Genero.setSelectedIndex(0);
    }//Fin metodo estado inicial
    
    public String devolverCedula()
    {
        return jt_Cedulaa.getText();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jl_Nombre = new javax.swing.JLabel();
        jl_Direccion = new javax.swing.JLabel();
        jl_Telefono = new javax.swing.JLabel();
        jl_Edad = new javax.swing.JLabel();
        jl_Genero = new javax.swing.JLabel();
        jt_Cedulaa = new javax.swing.JTextField();
        jt_Nombre = new javax.swing.JTextField();
        jt_Direccion = new javax.swing.JTextField();
        jt_Telefono = new javax.swing.JTextField();
        jsp_Edad = new javax.swing.JSpinner();
        jcb_Genero = new javax.swing.JComboBox();

        jl_Cedula.setText("Cedula:");

        jl_Nombre.setText("Nombre:");

        jl_Direccion.setText("Direccion:");

        jl_Telefono.setText("Telefono:");

        jl_Edad.setText("Edad:");

        jl_Genero.setText("Genero:");

        jt_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_TelefonoActionPerformed(evt);
            }
        });

        jcb_Genero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Cedula)
                    .addComponent(jl_Nombre)
                    .addComponent(jl_Direccion)
                    .addComponent(jl_Telefono)
                    .addComponent(jl_Edad)
                    .addComponent(jl_Genero))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jt_Cedulaa)
                    .addComponent(jt_Nombre)
                    .addComponent(jt_Direccion)
                    .addComponent(jt_Telefono)
                    .addComponent(jsp_Edad)
                    .addComponent(jcb_Genero, 0, 213, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Cedula)
                    .addComponent(jt_Cedulaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Nombre)
                    .addComponent(jt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Direccion)
                    .addComponent(jt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Telefono)
                    .addComponent(jt_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Edad)
                    .addComponent(jsp_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_Genero)
                    .addComponent(jcb_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jt_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_TelefonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcb_Genero;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_Direccion;
    private javax.swing.JLabel jl_Edad;
    private javax.swing.JLabel jl_Genero;
    private javax.swing.JLabel jl_Nombre;
    private javax.swing.JLabel jl_Telefono;
    private javax.swing.JSpinner jsp_Edad;
    private javax.swing.JTextField jt_Cedulaa;
    private javax.swing.JTextField jt_Direccion;
    private javax.swing.JTextField jt_Nombre;
    private javax.swing.JTextField jt_Telefono;
    // End of variables declaration//GEN-END:variables
}