
package Controller;

import DAO.ProductoDAO;
import DAO.ProductoDAOImplementar;
import Model.Producto;
import Model.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//CONTROLADOR FUNCIONA
//REVISAR UNICAMENTE LA VISTA DE GUARDAR

public class Productos extends HttpServlet {

    protected void listaProductos(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//Crear instancia a ProductoDAO
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
String nom_producto = request.getParameter("nom_pro");
String des_producto = request.getParameter("desc_pro");
float stock = Float.parseFloat(request.getParameter("stock_pro"));
float precio = Float.parseFloat(request.getParameter("precio_pro"));
String unidad_de_medida = request.getParameter("unidad_pro");
int estado_producto = Integer.parseInt(request.getParameter("estado_pro"));
int categoria = Integer.parseInt(request.getParameter("cat_pro"));
String fecha_entrada = request.getParameter("fecha_pro");


            //Revisar el orden de todo este bloque
String pagina = "/Vistas-Productos/crearProducto.jsp?id_p="+id_producto+"&&nombre_p="+nom_producto+"&&desc_p="+des_producto+"&&stock_p="+stock+
        "&&precio_p="+precio+"&&unidad_p="+unidad_de_medida+"&&estado_p="+estado_producto+"&&cat_p="+categoria+"&&fecha_p="+fecha_entrada+"&&senal=1";
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
String nom_producto = request.getParameter("txtNomProducto");
String des_producto = request.getParameter("txtDesProducto");
float stock = Float.parseFloat(request.getParameter("txtStockProducto"));
float precio = Float.parseFloat(request.getParameter("txtPrecioProducto"));
String unidad_de_medida = request.getParameter("txtUnidadProducto");
int estado_producto = Integer.parseInt(request.getParameter("txtEstadoProducto"));
int categoria = Integer.parseInt(request.getParameter("txtIdCategoria"));
String fecha_entrada = request.getParameter("txtFechaProducto");

      
producto.setId_producto(id_producto);
producto.setNom_producto(nom_producto);
producto.setDes_producto(des_producto);
producto.setStock(stock); //dudas con el valor de la llave foranea
producto.setPrecio(precio);
producto.setUnidadMedida(unidad_de_medida);
producto.setEstado(estado_producto);
producto.setCategoria_id(categoria);
producto.setFecha_entrada(fecha_entrada);


//IMPLEMEMENTAR LA CLASE ProductoDAO

ProductoDAO guardarProducto = new ProductoDAOImplementar();

guardarProducto.guardarPro(producto);
        
this.listaProductos(request, response);
        
}

    
@Override
public String getServletInfo() {
return "Short description";
}// </editor-fold>


}