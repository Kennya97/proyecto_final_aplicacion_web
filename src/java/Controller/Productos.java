
package Controller;

import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author W. Hernandez
 */
public class Productos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Productos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Productos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String parametro = request.getParameter("opcion"); //Capturar el parametro que se esta enviando
        if (parametro.equals("crear")) { //Evaluar si el parametro es crear o listar o cualquier otro
            String pagina = "/Vistas-Productos/crearProducto.jsp"; //Vista o formulario para registrar una nueva categoria
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
       }else{
            this.listaProductos(request, response);
        }
    }
    
    protected void listaProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        //Crear instancia de CategoriaDAO
        ProductoDAO producto = new ProductoDAOImplementar();
        //Crear instancia de session; se le da true para crear la sesion
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("lista", producto.Listar2()); //Lista es el nombre de la sesion
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/listarProductos.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto producto = new Producto(); //Agregar las demas propiedades
        //Se efectua el casting o conversion de datos porque lo ingresado en el formulario es texto
        producto.setId_producto(Integer.parseInt(request.getParameter("idproducto")));
        producto.setNom_producto(request.getParameter("txtnombre"));
        producto.setDes_producto(request.getParameter("txtdescripcion"));
        producto.setStock(Float.parseFloat(request.getParameter("txtstock")));
        producto.setPrecio(Float.parseFloat(request.getParameter("txtprecio")));
        producto.setUnidadMedida(request.getParameter("txtunidad"));
        producto.setEstado(Integer.parseInt(request.getParameter("txtestado")));
        producto.setCategoria_id(Integer.parseInt(request.getParameter("idcategoria")));
        producto.setFecha_entrada(request.getParameter("fecha"));
        
        ProductoDAO guardaproducto = new ProductoDAOImplementar();
        guardaproducto.guardarPro(producto);
        this.listaProductos(request, response);
    }

}
