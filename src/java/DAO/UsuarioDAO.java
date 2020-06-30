
package DAO;

import Model.Usuarios;
import java.util.List;

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
 
}
