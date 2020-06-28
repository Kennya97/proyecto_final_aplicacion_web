
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import Model.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author castr
 */
public class ProductoDAOImplementar implements ProductoDAO {
    
ConexionDB conn;  //Crear el objeto tipo conexión.


public ProductoDAOImplementar() {
//Definir a la base de datos que se conectará por defecto.   
}



//METODO PARA LISTAR LOS PRODUCTOS
//NO MODIFICAR NADA DE ESTE METODO POR FAVOOOOOOOOR
@Override
public List<Producto> Listar() {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
StringBuilder miSQL = new StringBuilder();

miSQL.append("SELECT * FROM tb_producto;");//LA CONSULTA

List<Producto> lista = new ArrayList<Producto>();
try{
            
//Se crea el objeto ResultSet implementando el método (consultaSQL) creado para la consulta.
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
    
Producto producto = new Producto();

//Asignar cada campo consultado al atributo en la clase.

producto.setId_producto(resultadoSQL.getInt("id_producto"));
producto.setNom_producto(resultadoSQL.getString("nom_producto"));
producto.setDes_producto(resultadoSQL.getString("des_producto"));
producto.setStock(resultadoSQL.getFloat("stock"));
producto.setPrecio(resultadoSQL.getFloat("precio"));
producto.setUnidadMedida(resultadoSQL.getString("unidad_de_medida"));
producto.setEstado(resultadoSQL.getInt("estado_producto"));
producto.setCategoria_id(resultadoSQL.getInt("categoria")); 
producto.setFecha_entrada(resultadoSQL.getString("fecha_entrada"));



lista.add(producto); //Agregar al array cada registro encontrado.
}
}catch(Exception ex){
            
}finally{
this.conn.cerrarConexion();
}
        
return lista;
    
}

    

@Override
public List<Producto> Listar2() {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

    
    
    
    
//METODO PARA EDITAR 
//POR FAVOR REVISAR ESTE METODO
//ACA SI NECESITA MODIFICACIONES YA QUE NO SE EJECUTA A LA HORA DE ACTUALIZAR
@Override
public Producto editarPro(int id_pro_edit) {
    
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);

Producto producto = new Producto();
StringBuilder miSQL = new StringBuilder();
//Agregar la consulta SQL.


miSQL.append("SELECT * FROM tb_producto WHERE id_producto = ").append(id_pro_edit);

//Realizar la consulta.
try{
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
producto.setId_producto(resultadoSQL.getInt("id_producto"));
producto.setNom_producto(resultadoSQL.getString("nom_producto"));
producto.setDes_producto(resultadoSQL.getString("des_producto"));
producto.setStock(resultadoSQL.getFloat("stock"));
producto.setPrecio(resultadoSQL.getFloat("precio"));
producto.setUnidadMedida(resultadoSQL.getString("unidad_de_medida"));
producto.setEstado(resultadoSQL.getInt("estado_producto"));
producto.setCategoria_id(resultadoSQL.getInt("categoria"));
producto.setFecha_entrada(resultadoSQL.getString("fecha_entrada"));


}

}catch(Exception e){
}finally{
this.conn.cerrarConexion();
}      
return producto;
}




//METODO PARA GUARDAR LOS PRODUCTOS
//NECESITA MODIFICARSE NO SE EJECUTA A LA HORA DE GUARDAR
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
@Override
public boolean guardarPro(Producto producto){
 this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
 
 boolean guardar = false; // Bandera De Resultado 
 
 try{
  // Condicional if else
     if(producto.getId_producto() == 0)
     {// Para cuando es un nuevo produto 
         
         //Instania del objeto 
         StringBuilder miSQL = new StringBuilder();
         //Agregar una consulta SQL el ID_Producto es auntoincremento 
         
         //Aqui creo esta el poblema 
         miSQL.append("INSERT INTO tb_producto(nom_producto, des_producto, stock, precio, unidad_de_medida, estado_producto, fecha_entrada)VALUES('");
         miSQL.append(producto.getNom_producto() + "', ").append(producto.getDes_producto() + "',").append(producto.getStock() 
                 + "',").append(producto.getPrecio() + "',").append(producto.getUnidadMedida() + "',").append(producto.getEstado() 
                 + "',").append(producto.getCategoria_id() + "',").append(producto.getFecha_entrada());
         miSQL.append(");");
         
         //Invocar metodo para ejecutar la consulta.
         this.conn.ejecutarSQL(miSQL.toString());
         System.out.println("Registro Guardado...");
         //fin de si
         
         //este es un if else.
     }else if(producto.getId_producto()>0){//Actualizar ID MAYORES A 0
         System.out.println("Entramos...");
         
         //Mas Codigo Agregado 
         //Instancia del objecto 
         StringBuilder miSQL = new StringBuilder();
         //listado
         miSQL.append("UPDATE tb_producto SET ");
         miSQL.append(" nom_producto = '").append(producto.getNom_producto());
         miSQL.append("', des_producto = '").append(producto.getDes_producto());
         miSQL.append("', stock = ").append(producto.getStock());
         miSQL.append(" , precio = ").append(producto.getPrecio());
         miSQL.append(" , unidad_de_medida = '").append(producto.getUnidadMedida());
         miSQL.append("', estado_producto = ").append(producto.getEstado());
         miSQL.append(", categoria = ").append(producto.getCategoria_id());
         miSQL.append(" , fecha_entrada = '").append(producto.getFecha_entrada());
         miSQL.append("' WHERE id_producto = ").append(producto.getId_producto()).append(";");
         
         //invocar metodo para ejecutar la consulta 
         this.conn.ejecutarSQL(miSQL.toString());
         
         //aqui ira un sout 
         System.out.println("Registro modificado correctamente!");
     }
     guardar = true;//Esto es para comprobar si se a modificado como es debido 
 }catch(Exception e){
    
 }finally{
    this.conn.cerrarConexion();
 }
   return guardar; 
}

//METODO PARA ELIMINAR
//>>>>>>>>>>>>>>>>>>>>POR FAVOR NO MODIFICAR NADA
@Override
public boolean borrarPro(int id_pro_borrar) {
    
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);

boolean borrar = false;//Bandera de resultados
try{
    
StringBuilder miSQL = new StringBuilder();

miSQL.append("DELETE FROM tb_producto WHERE id_producto = ").append(id_pro_borrar);
this.conn.ejecutarSQL(miSQL.toString());
borrar = true;
}catch(Exception e){
            
}finally{
this.conn.cerrarConexion();  //Cerrar la conexión.
}
       
return borrar;
}
}
    