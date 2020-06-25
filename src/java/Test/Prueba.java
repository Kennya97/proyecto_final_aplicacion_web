
package Test;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import Model.Categoria;
import java.util.List;

/**
 *
 * @author castr
 */

public class Prueba {
 
public static void main(String[] args) {
Prueba evaluar = new Prueba();

//evaluar.listarCategorias();
//evaluar.editarCategoria();
//evaluar.guardarCategoria();
evaluar.listarCategorias();
evaluar.eliminarCategoria();
evaluar.listarCategorias();

}

//METODO PARA LISTAR CATEGORIA

public void listarCategorias(){
CategoriaDAO categoria = new CategoriaDAOImplementar();
List<Categoria> listar = categoria.Listar();
System.out.println("LISTADO DE CATEGORIAS");
for(Categoria categoriaListar: listar){
 System.out.println("ID: "+ categoriaListar.getId_categoria() +
                                "NOMBRE: " + categoriaListar.getNom_categoria() +
                                "ESTADO: " + categoriaListar.getEstado_categoria());
 
}
}
  

//METODO PARA EDITAR LA CATEGORIA
public void editarCategoria(){
CategoriaDAO categoria = new CategoriaDAOImplementar();
Categoria cat_edit = categoria.editarCat(1);
System.out.println("CATEGORIA A GUARDAR");
System.out.println("ID: "+ cat_edit.getId_categoria() +
                                "  NOMBRE: " + cat_edit.getNom_categoria() +
                                "  ESTADO: " + cat_edit.getEstado_categoria());
}
  
//METODO PARA GUARDAR LA CATEGORIA
 public void guardarCategoria(){
     
CategoriaDAO categoria = new CategoriaDAOImplementar();

Categoria guardar_cat = new Categoria();
guardar_cat.setNom_categoria("FLORES");
guardar_cat.setId_categoria(3);
guardar_cat.setEstado_categoria(1); //Estado 1.
categoria.guardarCat(guardar_cat);
        
}

 //METODO ELIMINAR
 

 public void eliminarCategoria(){
CategoriaDAO categoria = new CategoriaDAOImplementar();
categoria.borrarCat(7);    //Se eliminará la categoria con id_categoria = 7;
}
}
