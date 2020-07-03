<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Inicio de Sesion</title>
    </head>
    <style>
        body{
            background-image:url("img/fon.jpg");
             background-size: 1425px;
            background-repeat: no-repeat;
        }
    </style>
    <body>
        <br><br><br><br>
        <div class="container col-lg-3">
            <form action="Controlador" method="POST" >
                <div class="from-goup text-center">
                    <img src="img/usua.png" height="130" width="130"/>
                    <p><strong>Bienvenidos a Sistema Login</strong></p>
                </div>
                <div class="form-group">
                <label>Correo:</label>
                <input class="form-control" type="email" name="txtCorreo" placeholder="Ingrese Correo" required=""> 
               </div>
        <div class="form-group">
            <label>Contraseña:</label>
            <input type="password" name="txtPass" placeholder="Ingrese su Contraseña" class="form-control">
        </div>
                <input type="hidden" name="accion" value="Ingresar">
                <input class="btn btn-danger btn-block" type="submit" name="accion" value="Ingresar"> 
                <!--Nuevo cambio-->
                <center>
        <a href="http://localhost:8080/proyecto_final_aplicacion_web/CrearCuenta.jsp">Crear Cuenta</a>     
        <br><a href="http://localhost:8080/proyecto_final_aplicacion_web/Recupera.jsp">Restaurar Contraseña</a>
                </center>
            </form>
            
        </div>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>