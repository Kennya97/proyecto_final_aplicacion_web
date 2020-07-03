<%-- 
    Document   : CrearCuenta
    Created on : 07-03-2020, 01:37:29 PM
    Author     : DELL 1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <style>
            body{
                background:cornsilk;   
            }
       </style>
         <center>
        <h1>Registrar nueva cuenta!</h1>                     
<form class="form-horizontal" id="frmUsuario" name="frmUsuario" action="" method="post">
<input type="hidden" name="id_usuario" value="" >
<input type="hidden" name="senal" value="1">
<div class="form-group">
<label for="txtNomUsuario" class="col-sm-2 control-label">Nombre:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtNomUsuario" value="" required>
</div>
</div>
<div class="form-group">
<label for="txtApellUsuario" class="col-sm-2 control-label">Apellido:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtApellUsuario" value="" required>
</div>
</div>
                
<div class="form-group">
            <label for="txtcorrUsuario" class="col-sm-2 control-label">Correo:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtcorrUsuario" value="" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtUsUsuario" class="col-sm-2 control-label">Usuario:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtUsUsuario" value="" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtClaUsuario" class="col-sm-2 control-label">Clave:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtClaUsuario" value="" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtTipUsuario" class="col-sm-2 control-label">Tipo:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtTipUsuario" value="" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtEstUsuario" class="col-sm-2 control-label">Estado:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtEstUsuario" value="" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtPreUsuario" class="col-sm-2 control-label">Pregunta:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtPreUsuario" value="" required>
            </div>
        </div>
                
        <div class="form-group">
            <label for="txtResUsuario" class="col-sm-2 control-label">Respuesta:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtResUsuario" value="" required>
            </div>
        </div>
                
      <div class="form-group">
            <label for="txtFechUsuario" class="col-sm-2 control-label">Fecha de registro:</label>
            <div class="col-sm-10">
                <input type="datetime-local" class="form-control" name="txtFechUsuario" value="" required>
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
        </center>   
    </body>
</html>