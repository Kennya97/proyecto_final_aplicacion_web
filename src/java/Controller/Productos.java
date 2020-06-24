
package Controller;

import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Productos extends HttpServlet {

    protected void listaProductos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//Crear instancia a CategoriaDAO
ProductoDAO producto = new ProductoDAOImplementar();
//Crear instancia de sesión; se le da true para crear la sesión.

HttpSession session = request.getSession(true);

session.setAttribute("lista", producto.Listar()); //lista es el nombre de la variable de sesión.

RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/listarProductos.jsp");
dispatcher.forward(request, response);


}
    
protected void borrarProducto(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
    
        
     
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Vistas-Productos/listarProductos.jsp");
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
        
if(parametro.equals("crear")){
            
//Vista o formulario para registrar nueva categoria.
            
String pagina = "/Vistas-Productos/crearProducto.jsp";

RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
dispatcher.forward(request, response);
            
}else if(parametro.equals("listar")){
this.listaProductos(request, response);
            
}else if(parametro.equals("modificar")){
            
//Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.
int id_producto = Integer.parseInt(request.getParameter("id_pro"));
String nombre_pro = request.getParameter("nombre_pro");
String desc_pro = request.getParameter("descuento_pro");
int id_catpro = Integer.parseInt(request.getParameter("cat_pro"));
float stock_pro = Float.parseFloat(request.getParameter("stock_pro"));
float precio_pro = Float.parseFloat(request.getParameter("precio_pro"));
String unidad_pro = request.getParameter("unidad_pro");
int estado_pro = Integer.parseInt(request.getParameter("estado_pro"));
String fecha_pro = request.getParameter("fecha_pro");

            
String pagina = "/Vistas-Productos/crearProducto.jsp?id_p="+id_producto+"&&nombre_p="+nombre_pro+"&&descuento_p="+desc_pro+"&&idcat_p="+id_catpro+
        "&&stock_p="+stock_pro+"&&precio_p="+precio_pro+"&&unidad_p="+unidad_pro+"&&estado_p="+estado_pro+"&&fecha_p="+fecha_pro+"&&senal=1";
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
dispatcher.forward(request, response);
            
}else if(parametro.equals("eliminar")){
int del_id = Integer.parseInt(request.getParameter("id"));
ProductoDAO producto = new ProductoDAOImplementar();
producto.borrarPro(del_id);    
this.listaProductos(request, response);
}
        
}

    
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
  
        
Producto producto = new Producto();


//Se efectua el casting o conversión de datos porque lo ingresado en el formulario es texto.

int id_producto = Integer.parseInt(request.getParameter("id_producto"));
String nombre_pro = request.getParameter("txtnombreproducto");
String desc_pro = request.getParameter("txtdescuentoproducto");
int id_catpro = Integer.parseInt(request.getParameter("txtidcatproducto"));
float stock_pro = Float.parseFloat(request.getParameter("txtstockproducto"));
float precio_pro = Float.parseFloat(request.getParameter("txtprecioproducto"));
String unidad_pro = request.getParameter("txtunidadproducto");
int estado_pro = Integer.parseInt(request.getParameter("txtestadoproducto"));
String fecha_pro = request.getParameter("txtfechaproducto");
      
producto.setId_producto(id_producto);
producto.setNom_producto(nombre_pro);
producto.setDes_producto(desc_pro);
producto.setCategoria_id(id_catpro); //dudas con el valor de la llave foranea
producto.setStock(stock_pro);
producto.setPrecio(precio_pro);
producto.setUnidadMedida(unidad_pro);
producto.setEstado(estado_pro);
producto.setFecha_entrada(fecha_pro);


//IMPLEMEMENTAR LA CLASE CategoriaDAO

ProductoDAO guardarProducto = new ProductoDAOImplementar();

guardarProducto.guardarPro(producto);
        
this.listaProductos(request, response);
        
}

    
@Override
public String getServletInfo() {
return "Short description";
}// </editor-fold>


}
