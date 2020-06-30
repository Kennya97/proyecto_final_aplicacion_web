
package Controller;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImplementar;
import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementar;
import Model.GenerarPDF;
import static Model.GenerarPDF.Generar_PDF;
import Model.Usuario;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.codec.Base64;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class ReportePDF extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DocumentException {
        String Opcion = request.getParameter("opcion");
        response.setContentType("application/PDF");
        OutputStream Salida = response.getOutputStream();
        //si opcion es diferente de vacio 
        if(Opcion != null){
            if(Opcion.equalsIgnoreCase("Categoria")){

                CategoriaDAO utilidadesCategoria = new CategoriaDAOImplementar();
                List tanLaCategorias = utilidadesCategoria.Listar();
                GenerarPDF.Generar_PDF(Salida, tanLaCategorias);
            }else if(Opcion.equalsIgnoreCase("Producto")){
                ProductoDAO utilidaProductosDAO = new ProductoDAOImplementar();
                List tablaProducto = utilidaProductosDAO.Listar();
                GenerarPDF.GeneraPDFProducto(Salida, tablaProducto);
            }else if(Opcion.equalsIgnoreCase("Usuarios")){
                UsuarioDAO utilidaUsuarioDAO = new UsuarioDAOImplementar();
                List tablaUsuario = utilidaUsuarioDAO.Listar();
                GenerarPDF.GeneraPDFUsuario(Salida, tablaUsuario);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(ReportePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
