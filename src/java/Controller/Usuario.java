package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import Model.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class Usuario extends HttpServlet {

     protected void listaUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//Crear instancia a UsuarioDAO
        UsuarioDAO Usuario = new UsuarioDAOImplementar();
//Crear instancia de sesión; se le da true para crear la sesión.
        HttpSession session = request.getSession(true);
        session.setAttribute("lista", Usuario.Listar()); //lista es el nombre de la variable de sesión.

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuario/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void borrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Usuario/listarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//Se captura el parámetro que se esta enviando.
        String parametro = request.getParameter("opcion");

//Evaluar si el parámetro es crear o listar o cualquier otro.
        if (parametro.equals("crear")) {

//Vista o formulario para registrar nueva categoria.
            String pagina = "/Vistas-Usuario/crearUsuario.jsp";

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        } else if (parametro.equals("listar")) {
            this.listaUsuarios(request, response);

        } else if (parametro.equals("modificar")) {

//Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
            int id = Integer.parseInt(request.getParameter("id_u"));
            String nombre = request.getParameter("nombre_u");
            String apellido = request.getParameter("apellido_u");
            String correo = request.getParameter("correo_u");
            String usuario = request.getParameter("usuario_u");
            String clave = request.getParameter("clave_u");
            int tipo = Integer.parseInt(request.getParameter("tipo_u"));
            float estado = Float.parseFloat(request.getParameter("estado_u"));
            String pregunta = request.getParameter("pregunta_u");
            String respuesta = request.getParameter("respuesta_u");
            String fecha_registro = request.getParameter("fecha_registro_u");

            //Revisar el orden de todo este bloque
            String pagina = "/Vistas-Usuario/crearUsuario.jsp?id="+id+"&&nombre="+nombre+"&&apellido="+apellido+"&&correo="+correo+"&&usuario="+usuario+"&&clave="+clave+"&&tipo="+tipo+"&&estado="+estado+"&&pregunta="+pregunta+"&&respuesta="+respuesta+"&&fecha_registro="+fecha_registro+"&&senal=1";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);

        } else if (parametro.equals("eliminar")) {
            int del_id = Integer.parseInt(request.getParameter("id"));
            UsuarioDAOImplementar us = new UsuarioDAOImplementar() {};
            us.borrarUsu(del_id);
            this.listaUsuarios(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuarios us = new Usuarios();

//Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
        String redirigir = request.getParameter("cambio");
        String senal = request.getParameter("senal");
        int id = Integer.parseInt(request.getParameter("id_usuario"));
        String nombre = request.getParameter("txtNomUsuario");
        String apellido = request.getParameter("txtApellUsuario");
        String correo = request.getParameter("txtcorrUsuario");
        String usuario = request.getParameter("txtUsUsuario");
        String clave = request.getParameter("txtClaUsuario");
        int tipo = Integer.parseInt(request.getParameter("txtTipUsuario"));
        int estado= Integer.parseInt(request.getParameter("txtEstUsuario" ));
        String pregunta = request.getParameter("txtPreUsuario");
        String respuesta = request.getParameter("txtResUsuario");
        String fecha_entrada = request.getParameter("txtFechUsuario");

        us.setId(id);
        us.setNombre(nombre);
        us.setApellido(apellido);
        us.setCorreo(correo); //dudas con el valor de la llave foranea
        us.setUsuario(usuario);
        us.setClave(clave);
        us.setTipo(tipo);
        us.setEstado(estado);
        us.setPregunta(pregunta);
        us.setRespuesta(respuesta);
        us.setFecha_registro(fecha_entrada);

//IMPLEMEMENTAR LA CLASE ProductoDAO
        UsuarioDAOImplementar guardarUsuario = new UsuarioDAOImplementar();
        System.out.println("id " + us.getId());

         guardarUsuario.guardarUsu(us);   
        if(redirigir.equalsIgnoreCase("SI")){
            response.sendRedirect("index.jsp");
        }else{
            
            this.listaUsuarios(request, response);
        }


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
