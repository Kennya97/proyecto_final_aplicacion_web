<%-- 
    Document   : listarUsuario
    Created on : 06-28-2020, 11:14:23 AM
    Author     : ADMIN
--%>

<%@page import="Model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" scope="session" class="java.util.ArrayList"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <a href="<%= request.getContextPath() %>/Usuario?opcion=crear" class="btn bg-success btn-sm glyphicon glyphicon-pencil" role="button"> Nuevo Usuario</a>
        <a href="<%= request.getContextPath() %>/ReportePDF?opcion=Usuarios" class="btn btn-info btn-group-sm" role="button">PDF</a>
        <table>
            <thead>
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
                <th>ACCIONES</th
                
            </thead>
            <tbody>
                <% 
                    for(int i = 0; i< lista.size(); i++){
                        Usuario us = (Usuario) lista.get(i);
                    
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
<a href="<%= request.getContextPath() %>/usuario?opcion=modificar&&id=<%= us.getId()%>&&nombre=<%= us.getUsuario()%>&&apellido=<%= us.getApellido()%>&&correo=<%=us.getCorreo()%>&&usuario=<%=us.getUsuario()%>&&clave=<%=us.getClave()%>&&tipo=<%=us.getTipo()%>&&estado=<%=us.getEstado()%>&&pregunta=<%=us.getPregunta()%>&&respuesta=<%=us.getRespuesta()%>&&fecha_registro=<%=us.getFecha_registro()%>" class="btn btn-info btn-sm glyphicon glyphicon-edit" role="button" name="btnmodi">Editar</a>
<a href="<%= request.getContextPath() %>/usuario?opcion=eliminar&&id=<%= us.getId() %>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button">Eliminar</a>
</td>
                </tr>
                
                <% }%>
            </tbody>
        </table>
    </body>
</html>
