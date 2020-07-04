<%---
    Document   : listarProductos
    Created on : 06-23-2020, 06:59:28 AM
    Author     : W. Hernandez
----%>
<%@page import="Model.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!--CODIGO AGREGADO PARA LA SESIÓN SI NO A INGRESADO EL USUARIO NO PODRA VISUALIZAR 
NI LAS LISTA NI AGREGAR UN NUEVO CAMPO-->
<%@page session="true"%>

<%
// Obtengo la session que cree en el Controlador.java
HttpSession sessionActiva = request.getSession();
// Verifico que la variable tiene valores para evitar el nullPointerException
if(sessionActiva.getAttribute("datosUsuario")!= null){
// Guardo los valores de la session en un objeto Usuario 
Usuarios usuarioLogeado = (Usuarios) sessionActiva.getAttribute("datosUsuario");
}else{
// Session nulla reenvio a index.jsp para que inicie session
response.sendRedirect("index.jsp");
}
%>


<!DOCTYPE html>
<%@page import = "Model.Producto" %> <!----Importar el modelo------>
<%@page import = "Model.Categoria" %> <!----Importar el modelo------>

<!-------VISTA TOTALMENTE FUNCIONAL---------->
<!-----El id debe ser el mismo que se le coloco de nombre a la sesion en el controlador----->
<jsp:useBean id="lista" scope="session" class="java.util.List"/>
<jsp:useBean id="categoria" scope="session" class="Model.Categoria"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de inventario</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>  
    </head>
    <body>
        <%@include file = "../WEB-INF/Vistas-Parciales/encabezado2.jspf" %>  
        
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-12 col-md-10 col-sm-10">
                    
                    <div style="">
            <a href="<%= request.getContextPath() %>/productos?opcion=crear" class="btn bg-success btn-sm" role="button"> Nuevo Producto</a>
            <a href="<%= request.getContextPath() %>/ReportePDF?opcion=Productos" class="btn btn-info btn-group-sm" role="button">PDF</a>
            <center>
            <h3>Listado de Productos Registrados</h3>
            </center>
            
            <table class="table table-striped table-hover">
            <tr>
                <th>ID</th><th>Nombre</th><th>Descripción</th><th>Stock</th><th>Precio</th><th>Medida</th><th>Estado</th><th>Categoría</th><th>Fecha Entrada</th><th>Acción</th>
            </tr>
            <%
                for (int i = 0; i < lista.size(); i++) {
                        Producto producto = new Producto();
                        producto = (Producto)lista.get(i); //(Producto) es para el casting
                    
            %>
            <tr>
                <td><%= producto.getId_producto()%></td>
                <td><%= producto.getNom_producto()%></td>
                <td><%= producto.getDes_producto()%></td>
                <td><%= producto.getStock()%></td>
                <td><%= producto.getPrecio()%></td>
                <td><%= producto.getUnidadMedida()%></td>
                <td><%= producto.getEstado()%></td>
                <td><%= producto.getCategoria_id()%></td>
                <td><%= producto.getFecha_entrada()%></td>
                <td>
                    <!-------Boton para invocar metodo editar------>
                    <a href="<%= request.getContextPath() %>/productos?opcion=modificar&&id_pro=<%= producto.getId_producto()%>&&nom_pro=<%= producto.getNom_producto()%>&&des_pro=<%= producto.getDes_producto()%>&&stock_pro=<%= producto.getStock()%>&&precio_pro=<%= producto.getPrecio()%>
                       &&unidad_pro=<%= producto.getUnidadMedida()%>&&estado_pro=<%= producto.getEstado()%>&&cat_pro=<%= producto.getCategoria_id()%>&&fecha_pro=<%= producto.getFecha_entrada()%>" 
                       class="btn btn-warning btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi"> Editar</a>
                    
                       <!------Boton para el metodo eliminar------>
                       <a href="<%= request.getContextPath() %>/productos?opcion=eliminar&&id=<%= producto.getId_producto()%>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button"> Eliminar</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        
        <!------- Formulario para generar reporte en PDF de los registros de la base de datos ----------->
        <!-------Parte de la investigacion de como realizar un reporte en pdf desde la base de datos ------->
        <!-------Para este proceso importamos la libreria itextpdf-5.5.9 para generar el documento ---------->
        <!-------Usamos un servlet para pasar los parametros con los cuales se generara el archivo -------->
        <!-----------
        <form name="reporte" action="../InventarioWeb/Pdf">
            <input type="submit" class="btn btn-primary btn-sm glyphicon glyphicon-book" value=" Generar PDF" name="btnver"> 
        </form>
        ------->
        
        <div class="container">
            <form name="reporte" action="../proyecto_final_aplicacion_web/Pdf">
            <input type="submit" class="btn btn-primary btn-sm glyphicon glyphicon-book" value=" PDF de inventario general" name="btnver"> 
            </form>
            </div>
            </div>
        </div>
    </div>
 </div>
<%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>  
</body>
</html>
