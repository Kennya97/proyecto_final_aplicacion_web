
package Test;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import Model.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author castr
 */
public class Prueba_3 {
     
public static void main(String[] args) {
Prueba_3 us = new Prueba_3();

//us.guardarUsuario();
//us.editarUsuario();
us.listarUsuarios();
us.eliminarUsuario();
us.listarUsuarios();
}
//METODO PARA LISTAR LOS USUARIOS

public void listarUsuarios(){
UsuarioDAO usuarios = new UsuarioDAOImplementar();
List<Usuario> listar = usuarios.Listar();
System.out.println("LISTADO DE USUARIOS");
for(Usuario usuarioListar: listar){
 System.out.println("ID: "+ usuarioListar.getId() +
                                "NOMBRE: " + usuarioListar.getNombre() +
                                "APELLIDO : " + usuarioListar.getApellido()+
                                "CORREO : " + usuarioListar.getCorreo()+
                                 "USUARIO : " + usuarioListar.getUsuario()+
                                 "CLAVE : " + usuarioListar.getClave()+
                                  "TIPO: " + usuarioListar.getTipo()+
                                  "ESTADO : " + usuarioListar.getEstado()+
                                 "PREGUNTA : " + usuarioListar.getPregunta()+
                                  "RESPUESTA: " + usuarioListar.getRespuesta()+
                                   "FECHA REGISTRO : " + usuarioListar.getFecha_registro());
 
}
}


//METODO PARA EDITAR USUARIO

public void editarUsuario(){
UsuarioDAO usuario = new UsuarioDAOImplementar();
Usuario us_edit = usuario.editarUsu(1);

System.out.println("USUARIO A MODIFICAR");
System.out.println("ID: "+ us_edit.getId() +
                                "  NOMBRE: " + us_edit.getNombre() +
                                "  APELLIDO: " + us_edit.getApellido() +
                                "CORREO : " + us_edit.getCorreo()+
                                 "USUARIO : " + us_edit.getUsuario()+
                                 "CLAVE : " + us_edit.getClave()+
                                  "TIPO: " + us_edit.getTipo()+
                                  "ESTADO : " + us_edit.getEstado()+
                                 "PREGUNTA : " + us_edit.getPregunta()+
                                  "RESPUESTA: " + us_edit.getRespuesta()+
                                   "FECHA REGISTRO : " + us_edit.getFecha_registro());
}


//METODO PARA GUARDAR LA CATEGORIA
 public void guardarUsuario(){
     
UsuarioDAO usuario = new UsuarioDAOImplementar();

Usuario guardar_us = new Usuario();

guardar_us.setNombre("William");

guardar_us.setId(1);

guardar_us.setApellido("Hernandez");
guardar_us.setCorreo("willian123@gmail.com");
guardar_us.setUsuario("Cliente");
guardar_us.setClave("113");
guardar_us.setTipo(1);
guardar_us.setEstado(1); //Estado 1.
guardar_us.setPregunta("willian123");
guardar_us.setRespuesta("willian");
guardar_us.setFecha_registro(LocalDateTime.now());

usuario.guardarUsu(guardar_us);
        
}


 
 //METODO ELIMINAR
 

 public void eliminarUsuario(){
UsuarioDAO usuario = new UsuarioDAOImplementar();
usuario.borrarUsu(3);    //Se eliminará la categoria con id_usuario = 3;
}
}
 



