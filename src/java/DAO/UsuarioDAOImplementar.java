
package DAO;

import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import Model.Conexion;
import Model.Usuarios;
import Model.Validar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author castr
 */
public class UsuarioDAOImplementar implements UsuarioDAO {

ConexionDB conn;  //Crear el objeto tipo conexión.
Conexion cn = new Conexion();
PreparedStatement ps;
ResultSet rs;

public UsuarioDAOImplementar() {
    
//Definir a la base de datos que se conectará por defecto.
      
}



//METODO PARA LISTAR
    
@Override
 public List<Usuarios> Listar() {
     
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);

StringBuilder miSQL = new StringBuilder();

miSQL.append("SELECT * FROM tb_usuario;");
List<Usuarios> lista = new ArrayList<Usuarios>();
try{
            
//Se crea el objeto ResultSet implementando el método (consultaSQL) creado para la consulta.
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());

while(resultadoSQL.next()){
    
Usuarios Usu = new Usuarios();

//Asignar cada campo consultado al atributo en la clase.
Usu.setId(resultadoSQL.getInt("id"));
Usu.setNombre(resultadoSQL.getString("nombre"));
Usu.setApellido(resultadoSQL.getString("apellido"));
Usu.setCorreo(resultadoSQL.getString("correo"));
Usu.setUsuario(resultadoSQL.getString("usuario"));
Usu.setClave(resultadoSQL.getString("clave"));
Usu.setTipo(resultadoSQL.getInt("tipo"));
Usu.setEstado(resultadoSQL.getInt("estado"));
Usu.setPregunta(resultadoSQL.getString("pregunta"));
Usu.setRespuesta(resultadoSQL.getString("respuesta"));
Usu.setFecha_registro(resultadoSQL.getString("fecha_registro"));

lista.add(Usu); //Agregar al array cada registro encontrado.
}
}catch(Exception ex){
            
}finally{
this.conn.cerrarConexion();
}
        
return lista;
    
}
    

@Override
public List<Usuarios> Listar2() {
throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}




//METODO PARA EDITAR 
@Override
public Usuarios editarUsu(int id_usu_edit) {
 this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
 
Usuarios usuario = new Usuarios();
StringBuilder miSQL = new StringBuilder();
//Agregar la consulta SQL.


miSQL.append("SELECT * FROM tb_usuario  WHERE id = ").append(id_usu_edit);

//Realizar la consulta.
try{
ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
while(resultadoSQL.next()){
    
usuario.setId(resultadoSQL.getInt("id"));
usuario.setNombre(resultadoSQL.getString("nombre"));
usuario.setApellido(resultadoSQL.getString("apellido"));
usuario.setCorreo(resultadoSQL.getString("correo"));
usuario.setUsuario(resultadoSQL.getString("usuario"));
usuario.setClave(resultadoSQL.getString("clave"));
usuario.setTipo(resultadoSQL.getInt("tipo"));
usuario.setEstado(resultadoSQL.getInt("estado"));
usuario.setPregunta(resultadoSQL.getString("pregunta"));
usuario.setRespuesta(resultadoSQL.getString("respuesta"));
usuario.setFecha_registro(resultadoSQL.getString("fecha_registro"));

}

}catch(Exception e){
}finally{
this.conn.cerrarConexion();
}
        
return usuario;
}




//METODO PARA GUARDAR
    @Override
public boolean guardarUsu(Usuarios usuario) {
 this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
     
boolean guardar = false; //BANDERA DE RESULTADO
try{
    
if(usuario.getId() ==0){

StringBuilder miSQL = new StringBuilder();
//AGREGA CONSULTA SQL EL ID_CATEGORIA ES AUTOINCREMNTABLE

miSQL.append("INSERT INTO tb_usuario(nombre,  apellido, correo, usuario, clave, tipo, estado, pregunta, respuesta) VALUES ('");
miSQL.append(usuario.getNombre() + "', '").append(usuario.getApellido() +"','").append(usuario.getCorreo()+"','")
        .append(usuario.getUsuario()+"','").append(usuario.getClave()+"',").append(usuario.getTipo()+",").append
        (usuario.getEstado()+",'").append(usuario.getPregunta()+"','").append(usuario.getRespuesta()+"'");
        miSQL.append(");");
    
//Invocar método para ejecutar la consulta.
                
this.conn.ejecutarSQL(miSQL.toString());

System.out.println("Registro Guardado...");

}else if(usuario.getId()>0){//ACTUALIZAR ID MAYORES A 0
    
System.out.println("Entramos...");
    
//MAS CODIGO AGREGADO
    
StringBuilder miSQL = new StringBuilder();
miSQL.append("UPDATE tb_usuario SET id = ").append(usuario.getId());
miSQL.append(", nombre =  '").append(usuario.getNombre());
miSQL.append(" ', apellido =  '").append(usuario.getApellido());
miSQL.append("', correo =  '").append(usuario.getCorreo());
miSQL.append("', usuario =  '").append(usuario.getUsuario());
miSQL.append("', clave =  '").append(usuario.getClave());
miSQL.append("', tipo =  ").append(usuario.getTipo());
miSQL.append(", estado =  ").append(usuario.getEstado());
miSQL.append(", pregunta =  '").append(usuario.getPregunta());
miSQL.append("', respuesta =  '").append(usuario.getRespuesta());
miSQL.append("' ");
 

miSQL.append(" WHERE id = ").append(usuario.getId()).append(";");
                
//Invocar método para ejecutar la consulta.
this.conn.ejecutarSQL(miSQL.toString());

//AQUI IRA UN SOUT

System.out.println("Registro modificado correctamente!");
}
//guardar =true;  //ESTO LO MODIFICAMOS
            
}catch(Exception e){
            
}finally{
this.conn.cerrarConexion();
}
return guardar;
}
    
   

    @Override
    public boolean borrarUsu(int id_usu_borrar) {
this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
boolean borrar = false;//Bandera de resultados
try{
StringBuilder miSQL = new StringBuilder();
miSQL.append("DELETE FROM tb_usuario WHERE id = ").append(id_usu_borrar);
this.conn.ejecutarSQL(miSQL.toString());
borrar = true;
}catch(Exception e){
            
}finally{
this.conn.cerrarConexion();  //Cerrar la conexión.
}
return borrar;
} 
    
    
@Override
 public int validar(Usuarios usu) throws SQLException{
    String sql = "Select nombre , correo from tb_usuario where correo = '"+ usu.getCorreo() +"' AND clave = '" + usu.getClave() + "' ";
    this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
    int estado;
    rs = conn.consultaSQL(sql);
    rs.next();
    Usuarios resulUs = new Usuarios();
    resulUs.setNombre(rs.getString("nombre"));
    resulUs.setCorreo(rs.getString("correo"));
       if(resulUs.getNombre().equalsIgnoreCase("")){
            estado = 0;
        }else{
            estado = 1;
        }
    return estado;
  }
}
