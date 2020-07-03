<%-- 
    Document   : listarUsuario
    Created on : 06-28-2020, 11:14:23 AM
    Author     : ADMIN
--%>

<%@page import="Model.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
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
<div class="col-lg-12 col-md-7 col-sm-3">
<a href="<%= request.getContextPath() %>/Usuario?opcion=crear" class="btn bg-success btn-sm " role="button"> Nuevo Usuario</a>
<a href="<%= request.getContextPath() %>/ReportePDF?opcion=Usuarios" class="btn btn-info btn-group-sm" role="button">PDF</a>

<center>
<h3>Listado De Usuario</h3>
</center>

<table class="table table- justify-content-center table-hover">
    
<tr>
<th>ID</th>
<th>NOMBRE</th>
<th>APELLIDO</th>
<th>CORREO</th>
<th>USUARIO</th>
<th>CLAVE</th>
<th>TIPO</th>
<th>ESTADO</th>
<th>PREGUNTA</th>
<th>RESPUESTA</th>
<th>REGRISTRO</th>
<th> </th>
<th >ACCIONES </th>
</tr>

<% 
for(int i = 0; i< lista.size(); i++){
Usuarios us = (Usuarios) lista.get(i);
                    
%>
<tr>                    
<td><%=us.getId()%></td>
<td><%=us.getNombre()%></td>
<td><%=us.getApellido()%></td>
<td><%=us.getCorreo()%></td>
<td><%=us.getUsuario()%></td>
<td><%=us.getClave()%></td>
<td><%=us.getTipo()%></td>
<td><%=us.getEstado()%></td>
<td><%=us.getPregunta()%></td>
<td><%=us.getRespuesta()%></td>
<td><%=us.getFecha_registro()%></td>
<td>
 <!-- /Vistas-Categorias/crearCategoria.jsp -->
 <a href="<%= request.getContextPath() %>/Usuario?opcion=modificar&&id_u=<%= us.getId()%>&&nombre_u=<%= us.getUsuario()%>&&apellido_u=<%= us.getApellido()%>&&correo_u=<%=us.getCorreo()%>
&&usuario_u=<%=us.getUsuario()%>&&clave_u=<%=us.getClave()%>&&tipo_u=<%=us.getTipo()%>&&estado_u=<%=us.getEstado()%>&&pregunta_u=<%=us.getPregunta()%>&&respuesta_u=<%=us.getRespuesta()%>
&&fecha_registro=<%=us.getFecha_registro()%>" class="btn btn-warning small glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
</td>
<td>
<a href="<%= request.getContextPath() %>/Usuario?opcion=eliminar&&id=<%= us.getId()%>" class="btn btn-danger small glyphicon glyphicon-remove" role="button"> Eliminar</a>
</td>
</tr>
                
 <% }%>
</tbody>
</table>
</div>
</div>
</div>
<%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>  
</body>
</html>
