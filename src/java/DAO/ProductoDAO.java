
package DAO;

import Model.Producto;
import java.util.List;

/**
 *
 * @author castr
 */


public interface ProductoDAO {
   
//Definir los métodos, como la clase en interface. Los métodos no se implementan 
    
//aqui, los métodos son de tipo abstractos.
   
public List<Producto> Listar();
public List<Producto> Listar2();
public Producto editarPro(int id_pro_edit);
public boolean guardarPro(Producto producto);
public boolean borrarPro(int id_pro_borrar);


}