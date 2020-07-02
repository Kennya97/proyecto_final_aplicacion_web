<%-- 
    Document   : listarCategorias
    Created on : 06-22-2020, 11:22:29 PM
    Author     : castr
--%>
<%@page import="Model.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- El id debe ser el mismo que se le colocó de nombre a la sesión en el controlador -->
<jsp:useBean id="lista" scope="session" class="java.util.List" />

<html>
<head>
<title>Control de Inventario</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>

</head>
<body>
       
<%@include file="../WEB-INF/Vistas-Parciales/encabezado2.jspf" %>
        
<!-- Todo el contenido de la aplicación -->
        
<div class="container">
    <div class="row justify-content-center">
       <div class="col-lg-10 col-md-10 col-sm-10">
           
<div style="">
<!--<a href="#" cla<center>ss="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button">Nueva categoria</a>-->
<br>
<a href="<%= request.getContextPath() %>/categorias?opcion=crear" class="btn bg-success btn-sm" role="button">Nueva Categoria</a>
<a href="<%= request.getContextPath() %>/ReportePDF?opcion=Categoria" class="btn btn-info btn-group-sm" role="button">PDF</a>

<center>
<h2>Listado de Categorias Registradas</h2>
<table class="table table-striped table-hover">
 <center>
     
<tr>
<th>ID</th>
<th>NOMBRE</th>
<th>ESTADO</th>
<th>ACCION</th>
</tr>

<%
for(int i=0;i < lista.size(); i++){
Categoria categoria = new Categoria();
categoria = (Categoria)lista.get(i);
%>
<tr>
<td><%= categoria.getId_categoria() %></td>
<td><%= categoria.getNom_categoria() %></td>
<td><%= categoria.getEstado_categoria() %></td>
<td>
 <!-- /Vistas-Categorias/crearCategoria.jsp -->
<a href="<%= request.getContextPath() %>/categorias?opcion=modificar&&id_cat=<%= categoria.getId_categoria() %>&&nombre_cat=<%= categoria.getNom_categoria() %>&&estado_cat=<%= categoria.getEstado_categoria() %>" class="btn btn-warning  btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
<a href="<%= request.getContextPath() %>/categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>
</td>
</tr>

<%
}
%>
</table>
</center>
</center>  

</div>
       </div>
    </div>
</div>


 <!--FIN DEL CONTENIDO -->
<%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
</body>
</html>