package controlador;

import Modelo.DatosConexion;
import Modelo.DetalleFactura;
import java.io.*;


public class ArchivosBaseDtos 
{
    ObjectOutputStream archSal;
    ObjectInputStream archEnt;
    DatosConexion detalle;

    public ArchivosBaseDtos() 
    {
       // recargarArchivos();
        //setDetalle(new DatosConexion("3306", "root", "", "127.0.0.1", "facturacion"));
    }//Fin del constructor
    
    
    
    
    public boolean recargarArchivos()
    {   
        boolean estado=false;
        if(cargarArchivo())
        {
            leerInfo();
            estado=true;
        }//Fin del if
        
        else
        {
            crearArchivo();
        }//Fin del else
        return estado;
        
    }//Fin del metodo
    
    public void crearArchivo()
    {
        try
        {
            archSal = new ObjectOutputStream(new FileOutputStream("detalleDB.dat"));
            System.out.println("Archivo creado de forma correcta ");
        }//Fin del try
        
        catch(Exception e)
        {
            System.out.println("Error creando el archivo " + e);
        }//Fin del catch
    }//Fin del metodo
    
    public boolean cargarArchivo()
    {
        boolean existe;
        
        try
        {
            archEnt = new ObjectInputStream( new FileInputStream("detalleDB.dat"));
            System.out.println("Archivo cargado de forma correcta");
            existe = true;
        }//Fin del try
        
        catch(Exception e)
        {
            System.out.println("Error cargando en el archivo " + e);
            existe = false;
        }//Fin del catch
        
        return existe;
    }//Fin del metodo
    
    public void leerInfo()
    {
        try
        {
                detalle = ((DatosConexion) archEnt.readObject());
        }//Fin del try
        
        catch(EOFException e)
        {
            System.out.println("Fin del archivo");
        }//Fin del catch
        
        catch(Exception e)
        {
            System.out.println("Error leyendo el archivo " + e);
        }//Fin del catch
    }//Fin del metodo
    
    public DatosConexion getDetalle()
    {
        return detalle;
    }//Fin del metodo
    
    public void setDetalle(DatosConexion detalle)
    {
        crearArchivo();
        
        try
        {
            archSal.writeObject(detalle);
            System.out.println("Informacion escrita de forma correcta");
        }//Fin del try
        
        catch(Exception e)
        {
            System.out.println("Error escribiendo el archivo");
        }//Fin del catch
    }//Fin del metodo
}//Fin de la clase
