<%-- 
    Document   : Recupera
    Created on : 07-03-2020, 01:41:01 PM
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
        <h1>Hola usted necesita ayuda para recupera su cuenta!</h1>
        <form action="Preguntasecret" method="post">
<div class="form-group">
            <label for="txtPreUsuario" class="col-sm-2 control-label">Pregunta:</label>
            <label for="txtResUsuario" class="col-sm-2 control-label">Respuesta:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="txtPreUsuario" value="" required>
                
                
                <input type="text" class="form-control" name="txtResUsuario" value="" required>
            </div>
        </div>
<br><br>

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
 
            <input type="submit" class="btn btn-success btn-sm" name="btnGuardar" value="Guardar" />
            <input type="button" class="btn btn-info btn-sm" onclick="regresar('<%= request.getContextPath() %>/categorias?opcion=listar')" 
                name="btnRegresar" value="Regresar" />
            </div>      
          </div>
<!--respuesta-->  
<div class="form-group">
            
            <div class="col-sm-10">
        </div>
</div>
        </form>
        <%
           HttpSession sesion = request.getSession();
           String sicon = "";
                 
                 if (sesion.getAttribute("contraRecuperar") != null) {
                 sicon = sesion.getAttribute("contraRecuperar").toString() ;
  
        %>
        <div class="bg-success">
            <h3>Su contra es :  <%= sicon  %> </h3>          
        </div>
        
        <%  
        } else{
        String nocon = "";
            if(sesion.getAttribute("message") != null){
                nocon = sesion.getAttribute("message").toString();
 
            }
        %>
        <div class="bg-success" >
            <h3> Error: <%= nocon  %> </h3>          
        </div>
        <%
        }
        session.invalidate();
        %>
        <script type="text/javascript">
    
        //Función para el botón regresar.

        function regresar(url){
        location.href = url;
        }
        </script>  
</center>
    </body>
</html>