
package DAO;

import Model.Usuario;
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
public List<Usuario> Listar();
public List<Usuario> Listar2();
public Usuario editarUsu(int id_usu_edit);
public boolean guardarUsu(Usuario usuario);
public boolean borrarUsu(int id_usu_borrar);
public int validar(Usuario usu)throws SQLException;
 
 
}
/*
public class UsuarioDAO implements Validar{
    Connection con;
    Conexion cn = new Conexion();
    PreparedStAtement ps;
    ResultSet rs;
      
   
}
*/