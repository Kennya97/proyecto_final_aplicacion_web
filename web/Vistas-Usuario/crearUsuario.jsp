<%-- 
    Document   : crearUsuario
    Created on : 06-28-2020, 12:10:17 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Usuario" scope="session" class="Model.Usuarios" />
    <%
String id = "";
String nombre_u = "";
String apellido_u = "";
String correo_u = "";
String usuario_u = "";
String clave_u = "";
String tipo_u = "";
String estado_u = "";
String pregunta_u = "";
String respuesta_u = "";
String fecha_registro_u = "";

if(request.getParameter("senal")!=null){
        
id = request.getParameter("id");
nombre_u = request.getParameter("nombre");
apellido_u = request.getParameter("apellido");
correo_u = request.getParameter("correo");
usuario_u = request.getParameter("usuario");
clave_u = request.getParameter("clave");
tipo_u = request.getParameter("tipo");
estado_u = request.getParameter("estado");
pregunta_u = request.getParameter("pregunta");
respuesta_u = request.getParameter("respuesta");
fecha_registro_u = request.getParameter("fecha_registro");
}else{
id = String.valueOf(Usuario.getId());    //Id predeterminado cero definido en el constructor
nombre_u = Usuario.getNombre();
apellido_u = Usuario.getApellido();
correo_u = Usuario.getCorreo();
usuario_u = Usuario.getUsuario();
clave_u = Usuario.getClave();
tipo_u = String.valueOf(Usuario.getTipo());
estado_u = String.valueOf(Usuario.getEstado());
pregunta_u = Usuario.getFecha_registro();
respuesta_u =Usuario.getRespuesta();
fecha_registro_u = Usuario.getFecha_registro();
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        <title>JSP Page</title>
    </head>
    <body>
        
<%@include file="../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
<h3>CREAR NUEVO USUARIO</h3>
        
                 
<form class="form-horizontal" id="frmUsuario" name="frmUsuario" action="<%= request.getContextPath() %>/Usuario" method="post">
<input type="hidden" name="id_usuario" value="<%= id %>" >
<input type="hidden" name="senal" value="1">
<div class="form-group">
<label for="txtNomUsuario" class="col-sm-2 control-label">Nombre:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtNomUsuario" value="<%= nombre_u %>" required>
</div>
</div>
<div class="form-group">
<label for="txtApellUsuario" class="col-sm-2 control-label">Apellido:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtApellUsuario" value="<%= apellido_u %>" required>
</div>
</div>
                
<div class="form-group">
            <label for="txtcorrUsuario" class="col-sm-2 control-label">Correo:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtcorrUsuario" value="<%= correo_u %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtUsUsuario" class="col-sm-2 control-label">Usuario:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtUsUsuario" value="<%= usuario_u %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtClaUsuario" class="col-sm-2 control-label">Clave:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtClaUsuario" value="<%= clave_u %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtTipUsuario" class="col-sm-2 control-label">Tipo:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtTipUsuario" value="<%= tipo_u %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtEstUsuario" class="col-sm-2 control-label">Estado:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtEstUsuario" value="<%= estado_u %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtPreUsuario" class="col-sm-2 control-label">Pregunta:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtPreUsuario" value="<%= pregunta_u %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtResUsuario" class="col-sm-2 control-label">Respuesta:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtResUsuario" value="<%= respuesta_u %>" required>
            </div>
        </div>
                
      <div class="form-group">
            <label for="txtFechUsuario" class="col-sm-2 control-label">Fecha de registro:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtFechUsuario" value="<%= fecha_registro_u %>" required>
            </div>
        </div>
                
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
            <%
                if(request.getParameter("senal")!=null){
            %>

            <input type="submit" class="btn btn-primary btn-sm" name="btnModificar" value="Actualizar" />
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
        
        <script type="text/javascript">
    
        //Función para el botón regresar.

        function regresar(url){
        location.href = url;
        }
        </script>
    </body>

</html>
