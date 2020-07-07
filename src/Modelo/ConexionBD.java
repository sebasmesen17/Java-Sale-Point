
package Modelo;

import Controlador.Controlador_FRM_Login;
import Vista.FRM_ConfiguracionConexion;
import Vista.FRM_MenuPrincipal;
import controlador.ArchivosBaseDtos;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD{
    
    Producto productoTemporal;
   Clientes clienteTemporal;
   Proveedores proveedoresTemporal;
   Usuario usuarioTemporal;
   DetalleFactura detalleFacturaTemporal;
   Factura facturaTemporal;
    Connection con = null;
    String informacion[];
    FRM_MenuPrincipal frm_principal;
    FRM_ConfiguracionConexion frmConexion;
    
    public ConexionBD()
    {
        informacion=new String[4];

    }
    public boolean realizarConexion(DatosConexion datos)
    {
        boolean encontrado=false;
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://"+datos.getIp()+":"+datos.getPuerto()+"/"+datos.getNombreBD();
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, datos.getUsuario(), datos.getPassword());
            System.out.println("Conexión Realizada");
            encontrado=true;
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
        return encontrado;
    }
    
    
    
    public boolean registrarProducto(Producto producto)
    {
        ResultSet rs = null; //variable que guarda el resultado de la consulta
        Statement cmd = null; //variable que permite construir la consulta en código transac
        boolean ejecuto;
        try {
                cmd = con.createStatement();//permite guardar la consulta sql
                //                      INSERT INTO `productos`(`codigo`, `nombre`, `descripcion`, `tipo`, `cantidad`, `precioCompra`, `precioVenta`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7])
                ejecuto = cmd.execute("INSERT INTO productos(codigo, nombre, descripcion, tipo, cantidad, precioCompra, precioVenta) VALUES ('"+producto.getCodigo()+"','"+producto.getNombre()+"','"+producto.getDescripcion()+"','"+producto.getTipo()+"',"+producto.getCantidad()+","+producto.getPrecioCompra()+","+producto.getPrecioVenta()+")");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarProducto(String codigo)//modificar productos, usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
              //ejecuto = cmd.execute("DELETE FROM `productos` WHERE codigo='"+codigo+"'");
                ejecuto = cmd.execute("DELETE FROM `productos` WHERE codigo='"+codigo+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    

    
    public boolean modificarProducto(Producto producto)//modificar productos, usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                //ejecuto = cmd.execute("UPDATE `productos` SET `codigo`='"+producto.getCodigo()+"',`nombre`='"+producto.getNombre()+"',`descripcion`='"+producto.getDescripcion()+"',`tipo`='"+producto.getTipo()+"',`cantidad`="+producto.getCantidad()+",`precioCompra`="+producto.getPrecioCompra()+",`precioVenta`="+producto.getPrecioVenta()+" WHERE codigo='"+producto.getCodigo()+"'");

                ejecuto = cmd.execute("UPDATE `productos` SET `codigo`='"+producto.getCodigo()+"',`nombre`='"+producto.getNombre()+"',`descripcion`='"+producto.getDescripcion()+"',`tipo`='"+producto.getTipo()+"',`cantidad`="+producto.getCantidad()+",`precioCompra`="+producto.getPrecioCompra()+",`precioVenta`="+producto.getPrecioVenta()+" WHERE codigo='"+producto.getCodigo()+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean buscarProducto(String codigo)//  Este es de verificar usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
        boolean encontrado=false;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM productos");//Seleccione todo lo de productos 
                
                while (rs.next()) 
                {
                    
                    String codigoConsultado = rs.getString("codigo");
                    if(codigoConsultado.equals(codigo))
                    {
                         encontrado=true;
                        productoTemporal = new Producto(codigo,rs.getString("nombre"),rs.getString("descripcion"),rs.getString("tipo"),rs.getInt("cantidad"),rs.getDouble("precioCompra"),rs.getDouble("precioVenta"));//Esta linea saca los detos del registro
                    } 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontrado;
    }


    public Producto getProductoTemporal() {
        return productoTemporal;
    }
    
    public String [][] reporteProductos()
    {
     
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
        boolean encontrado=false;
        String [][] matriz=null;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(codigo) FROM productos");
                rs.next();
                int cantidad = rs.getInt("COUNT(codigo)");
                matriz= new String [cantidad][3];
                
                 cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM productos");
                int contador=0;
                while (rs.next()) 
                {
                 matriz[contador][0]=rs.getString("codigo");
                 matriz[contador][1]=rs.getString("nombre");
                 matriz[contador][2]=rs.getString("descripcion");
                 contador++;
                }
                rs.close();
             }
        
         catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
           
        }
         return matriz;
    }
    
    /*producto-------------------------------------------------------------------------------------------*/
    
     public boolean registrarFactura(Factura factura)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                //                     INSERT INTO `facturas`(`numero`, `fecha`, `usuario`, `cedulaCliente`, `tipoPago`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])
                ejecuto = cmd.execute("INSERT INTO facturas(numero, fecha, usuario, cedulaCliente, tipoPago) VALUES ('"+factura.getNumero()+"','"+factura.getFecha()+"','"+factura.getUsuario()+"','"+factura.getCedulaCliente()+"','"+factura.getTipoPago()+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
     public int buscarTamanioFactura()
    {
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
       int variable=0;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(numero) FROM facturas");//Seleccione todo lo de productos 
                
               rs.next();
               
               variable=rs.getInt("COUNT(numero)");
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return variable+1;

    }
     
       public boolean registrarDetalleFactura(DetalleFactura detalle)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                //                     INSERT INTO `detallefactura`(`numero`, `codigo`, `cantidad`) VALUES ([value-1],[value-2],[value-3])
                ejecuto = cmd.execute("INSERT INTO detallefactura(numero, codigo, cantidad) VALUES ('"+detalle.getNumFactura()+"','"+detalle.getCodigo()+"',"+detalle.getCantidad()+")");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
       
       
       /******************************************************/
       
       public boolean registrarCliente(Clientes cliente)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                //                    INSERT INTO `clientes`(`cedula`, `nombre`, `direccion`, `telefono`, `edad`, `genero`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6])
                ejecuto = cmd.execute("INSERT INTO clientes(cedula, nombre, direccion, telefono, edad, genero) VALUES ('"+cliente.getCedula()+"','"+cliente.getNombre()+"','"+cliente.getDireccion()+"','"+cliente.getTelefono()+"',"+cliente.getEdad()+",'"+cliente.getGenero()+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarCliente(String cedula)//modificar productos, usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
             
                ejecuto = cmd.execute("DELETE FROM `clientes` WHERE cedula='"+cedula+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    

    
    public boolean modificarCliente(Clientes cliente)//modificar productos, usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                //ejecuto = cmd.execute(UPDATE `clientes` SET `cedula`=[value-1],`nombre`=[value-2],`direccion`=[value-3],`telefono`=[value-4],`edad`=[value-5],`genero`=[value-6] WHERE 1)
                ejecuto = cmd.execute("UPDATE `clientes` SET `cedula`='"+cliente.getCedula()+"',`nombre`='"+cliente.getNombre()+"',`direccion`='"+cliente.getDireccion()+"',`telefono`='"+cliente.getTelefono()+"',`edad`="+cliente.getEdad()+",`genero`='"+cliente.getGenero()+"' WHERE cedula='"+cliente.getCedula()+"'");
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean buscarCliente(String cedula)//  Este es de verificar usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
        boolean encontrado=false;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM clientes");//Seleccione todo lo de productos 
                
                while (rs.next()) 
                {
                    
                    String codigoConsultado = rs.getString("cedula");
                    if(codigoConsultado.equals(cedula))
                    {
                         encontrado=true;
                         //ejecuto = cmd.execute(UPDATE `clientes` SET `cedula`=[value-1],`nombre`=[value-2],`direccion`=[value-3],`telefono`=[value-4],`edad`=[value-5],`genero`=[value-6] WHERE 1)
               
                        clienteTemporal = new Clientes(cedula,rs.getString("nombre"),rs.getString("direccion"),rs.getString("telefono"),rs.getInt("edad"),rs.getString("genero"));//Esta linea saca los detos del registro
                    } 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontrado;
    }


    public Clientes getClienteTemporal() {
        return clienteTemporal;
    }
    
    public String [][] reporteClientes()
    {
     
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
        boolean encontrado=false;
        String [][] matriz=null;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(cedula) FROM clientes");//Seleccione todo lo de productos 
                rs.next();
                int cantidad = rs.getInt("COUNT(cedula)");
                matriz= new String [cantidad][3];
                
                 cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM clientes");
                int contador=0;
                while (rs.next()) 
                {
                 matriz[contador][0]=rs.getString("cedula");
                 matriz[contador][1]=rs.getString("nombre");
                 matriz[contador][2]=rs.getString("telefono");
                 contador++;
                }
                rs.close();
             }
        
         catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
           
        }
         return matriz;
    }
    
    
    /******************************************************************************************************/
    
    
    //-----------------------------Usuarios---------------------------------------------------------
    
     public boolean registrarUsuarios(Usuario usuario)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                //                    INSERT INTO `usuarios`(`usuario`, `contrasenia`, `nombreCompleto`, `tipo`) VALUES ([value-1],[value-2],[value-3],[value-4])
                ejecuto = cmd.execute("INSERT INTO usuarios(usuario, contrasenia, nombreCompleto, tipo) VALUES ('"+usuario.getUsuario()+"','"+usuario.getContrasenia()+"','"+usuario.getNombreCompleto()+"','"+usuario.getTipo()+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: registrar" + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarUsuarios(String usuario)//modificar productos, usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
              
                ejecuto = cmd.execute("DELETE FROM `usuarios` WHERE usuario='"+usuario+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: eliminar " + e.getMessage());
            return false;
        }
        
    }
    
    
    public boolean modificarUsuarios(Usuario usuario)//modificar productos, usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                                     //UPDATE `usuarios` SET `usuario`=[value-1],`contrasenia`=[value-2],`nombreCompleto`=[value-3],`tipo`=[value-4] WHERE 1
               ejecuto = cmd.execute("UPDATE `usuarios` SET `usuario`='"+usuario.getUsuario()+"',`contrasenia`='"+usuario.getContrasenia()+"',`nombreCompleto`='"+usuario.getNombreCompleto()+"',`tipo`='"+usuario.getTipo()+"' WHERE usuario='"+usuario.getUsuario()+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: modificar" + e.getMessage());
            return false;
        }
        
    }
    public boolean verificarUsuario(String usuario, String contrasenia)
    {

      // this.con=conex.getConexion();
        //lenguaje de bases de datos
        
        boolean encontrado=false;
        
        try {
                Statement cmd = con.createStatement();
                ResultSet rs  = cmd.executeQuery("SELECT * FROM usuarios");//Seleccione todo lo de productos 
                
                while (rs.next()) 
                {                    
                    String usuarioConsultar = rs.getString("usuario");
                    String contraseniaConsultar = rs.getString("contrasenia");
                    if(usuarioConsultar.equals(usuario)&& contraseniaConsultar.equals(contrasenia))
                    {
                        
                         encontrado=true;
                        usuarioTemporal = new Usuario(usuario,rs.getString("contrasenia"),rs.getString("nombreCompleto"),rs.getString("tipo"));//Esta linea saca los detos del registro
                    } 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia verificar: " + e.getMessage());
        }
        
        return encontrado;
    }

   

     public boolean buscarUsuario(String usuario)
    {
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
        boolean encontrado=false;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios");//Seleccione todo lo de productos 
                
                while (rs.next()) 
                {
                    
                    String codigoConsultado = rs.getString("usuario");
                    if(codigoConsultado.equals(usuario))
                    {
                         encontrado=true;
                         
                        usuarioTemporal = new Usuario(usuario,rs.getString("contrasenia"),rs.getString("nombreCompleto"),rs.getString("tipo"));//Esta linea saca los detos del registro
                        
                    } 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("SQLException ejecutando sentencia: Buscar usuario" + e.getMessage());
        }
        return encontrado;
    }
     
     public Usuario getUsuarioTemporal() {
        return usuarioTemporal;
    }
     
     public String [][] reporteUsuarios()
    {
     
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
        boolean encontrado=false;
        String [][] matriz=null;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(usuario) FROM usuarios");//Seleccione todo lo de productos 
                rs.next();
                int cantidad = rs.getInt("COUNT(usuario)");
                matriz= new String [cantidad][4];
                
                 cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM usuarios");
                int contador=0;
                while (rs.next()) 
                {
                 matriz[contador][0]=rs.getString("usuario");
                 matriz[contador][1]=rs.getString("contrasenia");
                 matriz[contador][2]=rs.getString("nombreCompleto");
                 matriz[contador][3]=rs.getString("tipo");
                 contador++;
                }
                rs.close();
             }
        
         catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
           
        }
         return matriz;
    }
   
  /***********************************proveedores*********************************************************/
     
      public boolean registrarProveedores(Proveedores  proveedores)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                //                    INSERT INTO `proveedores`(`cedula`, `nombreEmpresa`, `telefono`, `correo`, `nombreContacto`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])
                ejecuto = cmd.execute("INSERT INTO proveedores(cedula, nombreEmpresa, telefono, correo, nombreContacto) VALUES ('"+proveedores.getCedula()+"','"+proveedores.getNombreEmpresa()+"','"+proveedores.getTelefono()+"','"+proveedores.getCorreo()+"','"+proveedores.getNombreContacto()+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
     public boolean eliminarProveedor(String cedula)//modificar productos, usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
              //ejecuto = cmd.execute("DELETE FROM `productos` WHERE codigo='"+codigo+"'");
               
                //DELETE FROM `proveedores` WHERE 0
                ejecuto = cmd.execute("DELETE FROM `proveedores` WHERE cedula='"+cedula+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    
    

    
    public boolean modificarProveedores(Proveedores proveedores)//modificar productos, usuarios
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                //ejecuto = cmd.execute("UPDATE `productos` SET `codigo`='"+producto.getCodigo()+"',`nombre`='"+producto.getNombre()+"',`descripcion`='"+producto.getDescripcion()+"',`tipo`='"+producto.getTipo()+"',`cantidad`="+producto.getCantidad()+",`precioCompra`="+producto.getPrecioCompra()+",`precioVenta`="+producto.getPrecioVenta()+" WHERE codigo='"+producto.getCodigo()+"'");
                //             UPDATE `proveedores` SET `cedula`=[value-1],`nombreEmpresa`=[value-2],`telefono`=[value-3],`correo`=[value-4],`nombreContacto`=[value-5] WHERE 1
                ejecuto = cmd.execute("UPDATE `proveedores` SET `cedula`='"+proveedores.getCedula()+"',`nombreEmpresa`='"+proveedores.getNombreEmpresa()+"',`telefono`='"+proveedores.getTelefono()+"',`correo`='"+proveedores.getCorreo()+"',`nombreContacto`='"+proveedores.getNombreContacto()+"' WHERE cedula='"+proveedores.getCedula()+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public boolean buscarProveedor(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
        boolean encontrado=false;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM proveedores");//Seleccione todo lo de productos 
                
                while (rs.next()) 
                {
                    
                    String codigoConsultado = rs.getString("cedula");
                    if(codigoConsultado.equals(cedula))
                    {
                         encontrado=true;
                        proveedoresTemporal = new Proveedores(cedula,rs.getString("nombreEmpresa"),rs.getString("telefono"),rs.getString("correo"),rs.getString("nombreContacto"));//Esta linea saca los detos del registro
                       
                        
                    } 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return encontrado;
    }

    public Proveedores getProveedoresTemporal() {
        return proveedoresTemporal;
    }
    
    public String [][] reporteProveedores()
    {
     
        ResultSet rs = null;
        Statement cmd = null;//lenguaje de bases de datos
        boolean encontrado=false;
        String [][] matriz=null;
        
        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT COUNT(cedula) FROM proveedores");//Seleccione todo lo de productos 
                rs.next();
                int cantidad = rs.getInt("COUNT(cedula)");
                matriz= new String [cantidad][3];
                
                 cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM proveedores");
                int contador=0;
                while (rs.next()) 
                {
                 matriz[contador][0]=rs.getString("cedula");
                 matriz[contador][1]=rs.getString("nombreContacto");
                 matriz[contador][2]=rs.getString("correo");
                 contador++;
                }
                rs.close();
             }
        
         catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
           
        }
         return matriz;
    }
    
}//class
