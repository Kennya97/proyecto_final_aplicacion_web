
package DAO;

import Model.Usuarios;
import Model.Validar;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author castr
 */
public interface UsuarioDAO {
public List<Usuarios> Listar();
public List<Usuarios> Listar2();
public Usuarios editarUsu(int id_usu_edit);
public boolean guardarUsu(Usuarios usuario);
public boolean borrarUsu(int id_usu_borrar);
public int validar(Usuarios usu)throws SQLException;
 
 
}
/*
public class UsuarioDAO implements Validar{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStAtement ps;
    ResultSet rs;
      
   
}
*/