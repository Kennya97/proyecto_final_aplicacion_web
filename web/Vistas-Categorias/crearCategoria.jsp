<%-- 
    Document   : crearCategoria
    Created on : 06-22-2020, 11:29:14 PM
    Author     : castr
--%>

<%@page import="Model.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--CODIGO AGREGADO PARA LA SESIÓN SI NO A INGRESADO EL USUARIO NO PODRA VISUALIZAR 
NI LAS LISTA NI AGREGAR UN NUEVO REGISTRO-->
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

<!-- Para importar los datos de la clase Categoria -->

<jsp:useBean id="categoria" scope="session" class="Model.Categoria" />

<%
String id = "";
String nombre_cat = "";
String estado_cat = "";

if(request.getParameter("senal")!=null){
        
id = request.getParameter("id_c");
nombre_cat = request.getParameter("nombre_c");
estado_cat = request.getParameter("estado_c");
}else{
id = String.valueOf(categoria.getId_categoria());    //Id predeterminado cero definido en el constructor
nombre_cat = categoria.getNom_categoria();
estado_cat = String.valueOf(categoria.getEstado_categoria());
}
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Control de Inventario</title>

<%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        
<script type="text/javascript">
    
//Función para el botón regresar.

function regresar(url){
location.href = url;
}
</script>
</head>
<body>
    
<%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>

<div class="container">
    <div class="row justify-content-center">
       <div class="col-lg-10 col-md-10 col-sm-10">

 <center>
<h3>CREAR NUEVA CATEGORIA</h3>
</center>

<form class="form-horizontal" id="frmCategoria" name="frmCategoria" action="<%= request.getContextPath() %>/categorias" method="post">
<input type="hidden" name="id_categoria" value="<%= id %>" >
            
<div class="form-group">
<label for="txtNomCategoria" class="col-sm-2 control-label">Nombre:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtNomCategoria" value="<%= nombre_cat %>" required>
</div>
</div>
                
<div class="form-group">
<label for="txtEstadoCategoria" class="col-sm-2 control-label">Estado:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtEstadoCategoria" value="<%= estado_cat %>" required>
</div>
</div>
                
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10">
<%
if(request.getParameter("senal")!=null){
%>

<input type="submit" class="btn btn-success btn-sm" name="btnModificar" value="Actualizar" />
<%
 
}else{   

%>    
<input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" />
<%
}  
%> 
<input type="button" class="btn btn-info btn-sm" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')" 
name="btnRegresar" value="Regresar" />
</div>
</div>   
</form>

       </div>
    </div>
</div>

<%@include file="../WEB-INF/Vistas-Parciales/pie.jspf" %>
</body>
</html>