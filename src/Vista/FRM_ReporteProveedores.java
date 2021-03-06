
package Vista;

import Controlador.Controlador_FRM_MantenimientoProveedores;
import javax.swing.table.DefaultTableModel;

public class FRM_ReporteProveedores extends javax.swing.JFrame {

    /**
     * Creates new form FRM_ReporteProveedores
     */
    DefaultTableModel modelos;
    String columnas[];
    
    public FRM_ReporteProveedores(Controlador_FRM_MantenimientoProveedores controlador ) {
        initComponents();
         setLocation(800,200);
         modelos=new DefaultTableModel();
        jtbl_ReporteProveedores.setModel(modelos);
        columnas=new String[3];
         columnas[0]="Cedula";
         columnas[1]="Nombre Contacto";
         columnas[2]="Correo";
        jtbl_ReporteProveedores.addMouseListener(controlador);
    }
    
    public void cargarInformacion(String matrizInformacion[][])
    {
        modelos.setDataVector(matrizInformacion,columnas);
    }
    
    public  String devolverCedula()
    {
        return ""+modelos.getValueAt(jtbl_ReporteProveedores.getSelectedRow(), 0);
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
        jtbl_ReporteProveedores = new javax.swing.JTable();

        jtbl_ReporteProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtbl_ReporteProveedores);

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
    private javax.swing.JTable jtbl_ReporteProveedores;
    // End of variables declaration//GEN-END:variables
}
