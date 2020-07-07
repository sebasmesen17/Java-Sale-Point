

package Vista;

import Controlador.Controlador_FRM_MantenimientoProductos;
import Modelo.ConexionBD;
import Modelo.Producto;


public class FRM_MantenimientoProductos extends javax.swing.JFrame {

    /**
     * Creates new form FRM_MantenimientoProductos
     */
    
    public Controlador_FRM_MantenimientoProductos controlador_productos;
    public FRM_MantenimientoProductos(ConexionBD conexion) {
        initComponents();
        setLocationRelativeTo(null);
        controlador_productos= new Controlador_FRM_MantenimientoProductos(this, conexion);
        btn_Reporte.addActionListener(controlador_productos);
        jP_Botones1.agregarEventos(controlador_productos);
        
    }
    public Producto devolverInformacion()
    {
      return jP_InformacionProdutos1.devolverInformacion();
    }
    
    public String devolverCodigo()
    {
       return jP_InformacionProdutos1.devolverCodigo();
    }
    
    public void mostrarInformacion(Producto producto)
    {
        jP_InformacionProdutos1.mostrarInformacion(producto);
    }
    
    public void habilitarAgregar()
    {
        jP_InformacionProdutos1.habilitarAgregar();
        jP_Botones1.habilitarAgregar();
    }
    public void estadoInicial()
    {
    jP_InformacionProdutos1.estadoInicial();
    jP_Botones1.estadoInicial();
    }
    public void habilitarModificarEliminar()
    {
    jP_InformacionProdutos1.habilitarAgregar();
    jP_Botones1.habilitarModificarEliminar();
    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_Botones1 = new Vista.JP_Botones();
        jP_InformacionProdutos1 = new Vista.JP_InformacionProdutos();
        btn_Reporte = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_Reporte.setText("Reporte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jP_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jP_InformacionProdutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Reporte)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jP_InformacionProdutos1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btn_Reporte)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jP_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Reporte;
    private Vista.JP_Botones jP_Botones1;
    private Vista.JP_InformacionProdutos jP_InformacionProdutos1;
    // End of variables declaration//GEN-END:variables
}
