
package Vista;

import Controlador.Controlador_FRM_MantenimientoProductos;
import javax.swing.table.DefaultTableModel;


public class FRM_ReporteProductos extends javax.swing.JFrame {

    /**
     * Creates new form FRM_ReporteProductos
     */
    DefaultTableModel modelo;
    String columnas[];
    public FRM_ReporteProductos(Controlador_FRM_MantenimientoProductos controlador) {
        initComponents();
        setLocationRelativeTo(null);
       modelo = new DefaultTableModel();
       jtbl_Reporte.setModel(modelo);//Se le asigna modelo a la table
       columnas=new String [3];
       columnas[0]="Codigo";
       columnas[1]="Nombre";
       columnas[2]="Descripcion";
       jtbl_Reporte.addMouseListener(controlador);
     
        
    }

    public void cargarInformacion(String matrizInformacion[][])
    {
          modelo.setDataVector(matrizInformacion, columnas);
    }
    public String devolverCodigo()
    {
        return  ""+modelo.getValueAt(jtbl_Reporte.getSelectedRow(), 0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Reporte = new javax.swing.JTable();

        jtbl_Reporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtbl_Reporte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtbl_Reporte;
    // End of variables declaration//GEN-END:variables
}
