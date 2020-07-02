package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
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
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            float correo = Float.parseFloat(request.getParameter("correo"));
            String usuario = request.getParameter("usuario");
            int clave = Integer.parseInt(request.getParameter("clave"));
            int tipo = Integer.parseInt(request.getParameter("tipo"));
            float estado = Float.parseFloat(request.getParameter("estado"));
            String pregunta = request.getParameter("pregunta");
            String respuesta = request.getParameter("respuesta");
            String fecha_registro = request.getParameter("fecha_registro");

            //Revisar el orden de todo este bloque
            String pagina = "/Vistas-Usuario/crearUsuario.jsp?id=" + id + "&&nombre=" + nombre + "&&apellido=" + apellido + "&&correo=" + correo + "&&usuario=" + usuario + "&&clave=" + clave + "&&tipo=" + tipo  + "&&estado=" + estado + "&&pregunta=" + pregunta  + "&&respuesta=" + respuesta +  "&&fecha_registro=" + fecha_registro + "&&senal=1";
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

        Usuario us = new Usuario();

//Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("txtnombre");
        String apellido = request.getParameter("txtApellido");
        float correo = Float.parseFloat(request.getParameter("txtcorreo"));
        float usuario = Float.parseFloat(request.getParameter("txtusuario"));
        String clave = request.getParameter("txtclave");
        int tipo = Integer.parseInt(request.getParameter("txttipo"));
        int estado= Integer.parseInt(request.getParameter("txtestado"));
        String pregunta = request.getParameter("txtpregunta");
        String respuesta = request.getParameter("txtrespuesta");
        String fecha_entrada = request.getParameter("txtFechaProducto");

        
        //us.(nombre);
        //us.(apellido);
        //us.(correo); //dudas con el valor de la llave foranea
        //us.(usuario);
        //us.(clave);
        //us.(tipo);
        //us.(estado);
        //us.(pregunta);
        //us.(respuesta);
        //us.(fecha_entrada);

//IMPLEMEMENTAR LA CLASE ProductoDAO
        UsuarioDAOImplementar guardarUsuario = new UsuarioDAOImplementar();

        //guardarUsuario.guardarUsu(us);

        this.listaUsuarios(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
