
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author castr
 */
public class CategoriaDAOImplementar implements CategoriaDAO{
    
ConexionDB conn;  //Crear el objeto tipo conexión.

public CategoriaDAOImplementar() {
//Definir a la base de datos que se conectará por defecto.
      
}
    
    
    
    
//METODO PARA LISTAR LA CATEGORIA
@Override
 public List<Categoria> Listar() {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
StringBuilder miSQL = new StringBuilder();
miSQL.append("SELECT * FROM tb_categoria;");
List<Categoria> lista = new ArrayList<Categoria>();
try{
            
//Se crea el objeto ResultSet implementando el método (consultaSQL) creado para la consulta.
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
    
Categoria categoria = new Categoria();

//Asignar cada campo consultado al atributo en la clase.
categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
lista.add(categoria); //Agregar al array cada registro encontrado.
}
}catch(Exception ex){
            
}finally{
this.conn.cerrarConexion();
}
        
return lista;
    
}

    
@Override
public List<Categoria> Listar2() {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}


//METODO PARA EDITAR LA CATEGORIA
@Override
public Categoria editarCat(int id_cat_edit) {
 this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
Categoria categoria = new Categoria();
StringBuilder miSQL = new StringBuilder();
//Agregar la consulta SQL.


miSQL.append("SELECT * FROM tb_categoria WHERE id_categoria = ").append(id_cat_edit);

//Realizar la consulta.
try{
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
while(resultadoSQL.next()){
categoria.setId_categoria(resultadoSQL.getInt("id_categoria"));
categoria.setNom_categoria(resultadoSQL.getString("nom_categoria"));
categoria.setEstado_categoria(resultadoSQL.getInt("estado_categoria"));
}

}catch(Exception e){
}finally{
this.conn.cerrarConexion();
}
        
return categoria;
}





@Override
public boolean guardarCat(Categoria categoria) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    



}

    @Override
    public boolean borrarCat(int id_cat_borrar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
