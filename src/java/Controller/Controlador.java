package Controller;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import Model.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controlador extends HttpServlet {
    UsuarioDAO dao = new UsuarioDAOImplementar();
    Usuarios p = new Usuarios();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
       response.setContentType("text/html;charset=UTF-8");
       String accion = request.getParameter("accion");
        System.out.println("Accion " + accion);
            if(accion.equals("Ingresar")){
                    String correo =request.getParameter("txtCorreo");
                    String Clave =request.getParameter("txtPass");
                    p.setCorreo(correo);
                    p.setClave(Clave);
                    try {
                        System.out.println("Estado busqueda " + dao.validar(p));
                    } catch (SQLException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
if(dao.validar(p) == 1){
// ESTA ES LA VARIABLE QUE CONTENDRA LA SESION
                        
HttpSession Logeado = request.getSession(true);
// SE LE ASIGNA VALORES A LA SESION

Logeado.setAttribute("datosUsuario", p); // objeto de tipo persona con los valores
                                                                        // nombre y correo asignados
                                                                        // Revisar vista principal el codigo de ahi lo penga en donde quiere que
                                                                         // que se compruebe que hay una session activa
request.getRequestDispatcher("Principal.jsp").forward(request, response);
}else{
request.getRequestDispatcher("index.jsp").forward(request, response);
}
}else if(accion.equalsIgnoreCase("Salir")){
// Guardo obtengo la session que cree
HttpSession sessionActiva = request.getSession();

// Mato la session Si no es valida
sessionActiva.invalidate();
// Llamo a la vista index
response.sendRedirect("index.jsp");
}else{
request.getRequestDispatcher("index.jsp").forward(request, response);
}
}

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}