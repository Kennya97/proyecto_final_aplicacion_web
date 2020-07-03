
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import Model.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
return null;
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


@Override
public boolean guardarPro(Producto producto){
 this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
 
 boolean guardar = false; // Bandera De Resultado 
 
 try{
  // Condicional if else
     System.out.println("Producto "+ producto.getId_producto());
     if(producto.getId_producto() == 0)
     {// Para cuando es un nuevo produto 
         
         //Instania del objeto 
         StringBuilder miSQL = new StringBuilder();
         //Agregar una consulta SQL el ID_Producto es auntoincremento 
         
         //Aqui creo esta el poblema 
         miSQL.append("INSERT INTO tb_producto(nom_producto, des_producto, stock, precio, unidad_de_medida, estado_producto, categoria, fecha_entrada) VALUES ");
         miSQL.append("('"+producto.getNom_producto()+ "', ");
         miSQL.append("'"+producto.getDes_producto()+"', ");
         miSQL.append(producto.getStock()+", ");
         miSQL.append(producto.getPrecio()+", '");
         miSQL.append(producto.getUnidadMedida()+"', ");
         miSQL.append(producto.getEstado()+", ");
         miSQL.append(producto.getCategoria_id()+", ");
         miSQL.append("'"+producto.getFecha_entrada()+"');");
         //(");");
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
//Metodo de prueba
//no funcional
/*
    @Override
    public boolean guardarproduc(Producto producto) {
         boolean guardar = false;
       try{
        if(producto.getId_producto() == 0){
            
        Connection miConexcion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_inventario?zeroDateTimeBehavior=convertToNull", "root", "");
        
                
            String sSQL = "INSERT INTO tb_producto"
            + "(nom_producto, des_producto, stock, precio, unidad_de_medida, estado_producto, categoria, fecha_entrada)" 
            + " VALUES (?,?,?,?,?,?,?,?);";

           PreparedStatement preparedStatement = (PreparedStatement) miConexcion.prepareStatement(sSQL);
            
            preparedStatement.setString(1, producto.getNom_producto());
            preparedStatement.setString(2, producto.getDes_producto());
            preparedStatement.setFloat(3, producto.getStock());
            preparedStatement.setFloat(4, producto.getPrecio());
            preparedStatement.setString(5, producto.getUnidadMedida());
            preparedStatement.setInt(6, producto.getEstado());
            preparedStatement.setInt(7, producto.getCategoria_id());
            preparedStatement.setString(8, producto.getFecha_entrada());
             
           preparedStatement.executeUpdate();
        }
           } catch (SQLException ex) {
            ex.getMessage();
            
        }
       
        return guardar;

    }   */
}
    