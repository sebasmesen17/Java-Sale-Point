package Vista;

import Controlador.Controlador_FRM_Facturacion;
import static Controlador.Controlador_FRM_Login.tipo;
import Modelo.ConexionBD;
import Modelo.DetalleFactura;
import Modelo.Factura;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FRM_Facturacion extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String columna[];
    Date fecha;
    Controlador_FRM_Facturacion controlador_frm_facturacion;
    
    int posicion;
    ConexionBD conexion;
    public FRM_Facturacion(ConexionBD conexion) 
    {
        initComponents();
        controlador_frm_facturacion= new Controlador_FRM_Facturacion(this, conexion);
        btn_Agregar.addActionListener(controlador_frm_facturacion);
        btn_BuscarCliente.addActionListener(controlador_frm_facturacion);
        btn_BuscarProducto.addActionListener(controlador_frm_facturacion);
        btn_Eliminar.addActionListener(controlador_frm_facturacion);
        btn_Pagar.addActionListener(controlador_frm_facturacion);
        fecha=new Date();
        jt_Fecha.setText(fecha.toLocaleString());
        modelo=new DefaultTableModel();
        jtbl_Reporte.setModel(modelo);
        btj_TipoPago.add(rb_Contado);
        btj_TipoPago.add(rb_Tarjeta);
        columna= new String[5];
        columna[0]="Código";
        columna[1]="Nombre";
        columna[2]="Descripcion";
        columna[3]="Cantidad";
        columna[4]="Sub Total";
        modelo.setColumnIdentifiers(columna);
        setLocationRelativeTo(null);
        
    }
    public void cargarInformacion(String matrizInformacion[][])
    {
          modelo.setDataVector(matrizInformacion, columna);
    }
    //-------------------------------------------------------
    
 public String getCedulaCliente()
 {
     return jt_CedulaCliente.getText();
 }
  public String getCodigoProductos()
 {
     return jt_CodigoProductos.getText();
 }
  //----------------------------------------------
 public void mostrarNombreCliente(String nombre)
 {
     jt_NombreCliente.setText(nombre);
 }
 
 public void mostrarNombreProducto(String nombre)
 {
     jt_NombreProducto.setText(nombre);
 }

 //---------------------------------------------------------------------------------------------------
 public void mostrarMensaje(String mensaje)
 {
     JOptionPane.showMessageDialog(null,mensaje);
 }
 //----------------------------------------------------
  public void agregarRegistro(Producto producto)
  {
       String registro[]=new String[5];
      if(verificarProductos())
      {
          modelo.setValueAt(Integer.parseInt(""+modelo.getValueAt(posicion, 3))+Integer.parseInt(""+jsp_Cantidad.getValue()), posicion, 3);
          modelo.setValueAt(Double.parseDouble(""+modelo.getValueAt(posicion, 4))+(producto.getPrecioVenta()*Double.parseDouble(""+jsp_Cantidad.getValue())), posicion, 4);
      }
      else
      {
     
            registro[0]=producto.getCodigo();
            registro[1]=producto.getNombre();
            registro[2]=producto.getDescripcion();
            registro[3]=""+jsp_Cantidad.getValue();
            registro[4]=""+(Double.parseDouble(registro[3])*producto.getPrecioVenta());
            modelo.addRow(registro);
            jt_CodigoProductos.setText("");
            jt_NombreProducto.setText("");
            jsp_Cantidad.setValue(0);
            
      }
  }
  
 public void estadoInicial()
  {
     jt_NumeroFactura.setText(String.valueOf(""+controlador_frm_facturacion.conexion.buscarTamanioFactura()));//devolverTamañoFactura
      jt_Usuario.setText(tipo);
      jt_Total.setText("0,0");
      jt_NombreCliente.setText("");
      jt_NombreCliente.setText("");
      jt_CedulaCliente.setText("");
      int tamanio=modelo.getRowCount();//Me devuelve la table
      for(int contador=0;contador<tamanio;contador++)
      {
          modelo.removeRow(0);
      }
                  
  }
  
  public void devolverFactura()
  {
      
      
      for(int i=0;i<modelo.getRowCount();i++)//Este for me recorre la tabla
      {
         controlador_frm_facturacion.conexion.registrarDetalleFactura(new DetalleFactura(Integer.parseInt(""+modelo.getValueAt(i, 0)),Integer.parseInt(""+modelo.getValueAt(i, 3)), Integer.parseInt(jt_NumeroFactura.getText())));
      }
      String tipo="";
      if(rb_Contado.isSelected())
      {
          tipo="Contado";
      }
      else
      {
          tipo="Tarjeta";
      }
      
 Factura factura = new Factura(Integer.parseInt(jt_NumeroFactura.getText()),jt_Fecha.getText(),jt_Usuario.getText(),jt_CedulaCliente.getText(),tipo);
   controlador_frm_facturacion.conexion.registrarFactura(factura);

  }
  
  
  public void calcularTotal()
  {
      double total=0;
      
      for(int i=0;i<modelo.getRowCount();i++)
      {
          total+=Double.parseDouble(""+modelo.getValueAt(i, 4));//posicion precio
      }
      jt_Total.setText(""+total);
  }
  public void limpiarProducto()
  {
      jt_CodigoProductos.setText("");
      jt_NombreProducto.setText("");
      jsp_Cantidad.setValue(0);
      
  }
  
  public boolean verificarProductos(){
      boolean estado=false;
  for(int i=0;i<modelo.getRowCount();i++)
  {
      if(jt_CodigoProductos.getText().equals(modelo.getValueAt(i,0)))
      {
        posicion=i;
        estado=true;  
      }
  }
  return estado;
  }
  
  public void eliminar(int pocision){
      
      modelo.removeRow(pocision);
       double total=0;
      
      for(int i=0;i<modelo.getRowCount();i++)
      {
          total+=Double.parseDouble(""+modelo.getValueAt(i, 4));//posicion precio
      }
      jt_Total.setText(""+total);
     
  }
  
  public int posicion(){
      return jtbl_Reporte.getSelectedRow();
  }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btj_TipoPago = new javax.swing.ButtonGroup();
        jl_numeroFactura = new javax.swing.JLabel();
        jl_Usuario = new javax.swing.JLabel();
        jl_CedulaCliente = new javax.swing.JLabel();
        jl_CodigoProductos = new javax.swing.JLabel();
        jt_NumeroFactura = new javax.swing.JTextField();
        jt_Usuario = new javax.swing.JTextField();
        jt_CedulaCliente = new javax.swing.JTextField();
        jt_CodigoProductos = new javax.swing.JTextField();
        btn_BuscarCliente = new javax.swing.JButton();
        btn_BuscarProducto = new javax.swing.JButton();
        jl_Fecha = new javax.swing.JLabel();
        jl_NombreCliente = new javax.swing.JLabel();
        jl_NombreProducto = new javax.swing.JLabel();
        jt_Fecha = new javax.swing.JTextField();
        jt_NombreCliente = new javax.swing.JTextField();
        jt_NombreProducto = new javax.swing.JTextField();
        jl_Cantidad = new javax.swing.JLabel();
        jsp_Cantidad = new javax.swing.JSpinner();
        btn_Agregar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbl_Reporte = new javax.swing.JTable();
        jl_Total = new javax.swing.JLabel();
        jt_Total = new javax.swing.JTextField();
        jl_TipoPago = new javax.swing.JLabel();
        rb_Contado = new javax.swing.JRadioButton();
        rb_Tarjeta = new javax.swing.JRadioButton();
        btn_Pagar = new javax.swing.JButton();

        jl_numeroFactura.setText("N° Factura");

        jl_Usuario.setText("Usuario:");

        jl_CedulaCliente.setText("Cédula Cliente:");

        jl_CodigoProductos.setText("Código Productos:");

        jt_NumeroFactura.setEditable(false);
        jt_NumeroFactura.setText("1");
        jt_NumeroFactura.setEnabled(false);
        jt_NumeroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_NumeroFacturaActionPerformed(evt);
            }
        });

        jt_Usuario.setEditable(false);
        jt_Usuario.setFocusable(false);
        jt_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_UsuarioActionPerformed(evt);
            }
        });

        btn_BuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btn_BuscarCliente.setActionCommand("BuscarCliente");
        btn_BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarClienteActionPerformed(evt);
            }
        });

        btn_BuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICONOS/buscar.png"))); // NOI18N
        btn_BuscarProducto.setActionCommand("BuscarProductos");

        jl_Fecha.setText("Fecha:");

        jl_NombreCliente.setText("Nombre Cliente:");

        jl_NombreProducto.setText("NombreProducto:");

        jt_Fecha.setEditable(false);
        jt_Fecha.setEnabled(false);
        jt_Fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_FechaActionPerformed(evt);
            }
        });

        jt_NombreCliente.setEditable(false);
        jt_NombreCliente.setEnabled(false);

        jt_NombreProducto.setEditable(false);
        jt_NombreProducto.setEnabled(false);

        jl_Cantidad.setText("Cantidad:");

        btn_Agregar.setText("Agregar");

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

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

        jl_Total.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jl_Total.setText("Total:");

        jt_Total.setEditable(false);
        jt_Total.setEnabled(false);

        jl_TipoPago.setText("Tipo de pago:");

        rb_Contado.setText("Contado");

        rb_Tarjeta.setText("Tarjeta");

        btn_Pagar.setText("Pagar");
        btn_Pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(rb_Contado)
                .addGap(30, 30, 30)
                .addComponent(rb_Tarjeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Usuario)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jt_NumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jl_numeroFactura)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_CedulaCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jt_CedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jl_CodigoProductos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jt_CodigoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jl_NombreCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jt_NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Fecha)
                                .addGap(18, 18, 18)
                                .addComponent(jt_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_NombreProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jt_NombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jl_Cantidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jsp_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Agregar)
                                .addGap(17, 17, 17)
                                .addComponent(btn_Eliminar)
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jl_TipoPago)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_NombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_NombreCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_NombreProducto)
                            .addComponent(jt_NombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_Cantidad)
                            .addComponent(jsp_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Agregar)
                            .addComponent(btn_Eliminar))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_BuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_numeroFactura)
                                    .addComponent(jt_NumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jl_Fecha)
                                    .addComponent(jt_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_Usuario)
                                    .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_CedulaCliente)
                                    .addComponent(jt_CedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jl_CodigoProductos)
                                    .addComponent(jt_CodigoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jl_TipoPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_Contado)
                    .addComponent(rb_Tarjeta)
                    .addComponent(btn_Pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jt_FechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_FechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_FechaActionPerformed

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void jt_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_UsuarioActionPerformed

    private void btn_PagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_PagarActionPerformed

    private void btn_BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_BuscarClienteActionPerformed

    private void jt_NumeroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_NumeroFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_NumeroFacturaActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btj_TipoPago;
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_BuscarCliente;
    private javax.swing.JButton btn_BuscarProducto;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Pagar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_Cantidad;
    private javax.swing.JLabel jl_CedulaCliente;
    private javax.swing.JLabel jl_CodigoProductos;
    private javax.swing.JLabel jl_Fecha;
    private javax.swing.JLabel jl_NombreCliente;
    private javax.swing.JLabel jl_NombreProducto;
    private javax.swing.JLabel jl_TipoPago;
    private javax.swing.JLabel jl_Total;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JLabel jl_numeroFactura;
    private javax.swing.JSpinner jsp_Cantidad;
    private javax.swing.JTextField jt_CedulaCliente;
    private javax.swing.JTextField jt_CodigoProductos;
    private javax.swing.JTextField jt_Fecha;
    private javax.swing.JTextField jt_NombreCliente;
    private javax.swing.JTextField jt_NombreProducto;
    private javax.swing.JTextField jt_NumeroFactura;
    private javax.swing.JTextField jt_Total;
    private javax.swing.JTextField jt_Usuario;
    private javax.swing.JTable jtbl_Reporte;
    private javax.swing.JRadioButton rb_Contado;
    private javax.swing.JRadioButton rb_Tarjeta;
    // End of variables declaration//GEN-END:variables
}
