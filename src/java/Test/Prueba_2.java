
package Test;


import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;

import java.util.List;

/**
 *
 * @author castr
 */


public class Prueba_2 {
public static void main(String[] args) {
Prueba_2 holis = new Prueba_2();


//holis.editarProducto();
holis.guardarProducto();
holis.listarProducto();
//holis.eliminarProducto();
//holis.listarProducto();

}


//METODO PARA LISTAR CATEGORIA

public void listarProducto(){
ProductoDAO producto= new ProductoDAOImplementar();

List<Producto> listar = producto.Listar();
System.out.println("LISTADO DE PRODUCTOS");
for(Producto productoListar: listar){
 System.out.println("ID: "+ productoListar.getId_producto() +
                                "NOMBRE: " + productoListar.getNom_producto()+
                                "DESCRIPCION: " + productoListar.getDes_producto()+ 
                                "STOCK: " + productoListar.getStock()+
                                "PRECIO: " + productoListar.getPrecio()+
                                "UNIDAD DE MEDIDA: " + productoListar.getUnidadMedida()+
                                "ESTADO PRODUCTO " + productoListar.getEstado()+
                                "CATEGORIA PRODUCTO " + productoListar.getCategoria_id()+
                                 "FECHA: "+productoListar.getFecha_entrada());
                                
 //AQUI LO UNICO QUE NO ME MOSTRO AL EJECUTAR EL ID DE LA CATEGORIA A LA QUE PERTENECE ME APARECIO NULA  
}
}

/*

//METODO PARA EDITAR EL PRODUCTO
public void editarProducto(){
ProductoDAO producto = new ProductoDAOImplementar();
Producto pro_edit = producto.editarPro(1);
System.out.println("PRODUCTO A MODIFICAR");
System.out.println("ID: "+ pro_edit.getId_producto() +
                                "NOMBRE: " + pro_edit.getNom_producto()+
                                "DESCRIPCION: " + pro_edit.getDes_producto()+ 
                                "STOCK: " + pro_edit.getStock()+
                                "PRECIO: " + pro_edit.getPrecio()+
                                "UNIDAD DE MEDIDA: " +pro_edit.getUnidadMedida()+
                                "ESTADO PRODUCTO " + pro_edit.getEstado()+
                                "CATEGORIA PRODUCTO " + pro_edit.getCategoria()+
                                 "FECHA: "+pro_edit.getFecha_entrada());
}


*/
 
//METODO PARA GUARDAR EL PRODUCTO EN ESTE TENGO PROBLEMAS 


 public void guardarProducto(){
     
ProductoDAO producto = new ProductoDAOImplementar();

Producto guardar_pro = new Producto();

guardar_pro.setNom_producto("FLORES");

//guardar_pro.setId_producto(3);//ID_A MODIFICAR

guardar_pro.setDes_producto("Muy bonitas"); //DESCRIPCION
guardar_pro.setStock(12);
guardar_pro.setPrecio(2);
guardar_pro.setUnidadMedida("Docena");
guardar_pro.setEstado(1);
guardar_pro.setCategoria_id(10);//AQUI PUSE NULL PORQUE NOSE COMO LLAMARLO 
//guardar_pro.setFecha_entrada("2020-06-23 16:13:45");

producto.guardarPro(guardar_pro);
        
}


 //METODO ELIMINAR
 
/*
 public void eliminarProducto(){
ProductoDAO producto = new ProductoDAOImplementar();

producto.borrarPro(3);    //Se eliminará la categoria con id_producto = 3;
}
 */
}
