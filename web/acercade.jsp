<%-- 
    Document   : index
    Created on : 06-22-2020, 10:38:23 PM
    Author     : castr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Control de Inventario</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Incluimos la vista parcial la cual contiene las url de las librerias  correspondientes a estilos y js -->
<%@include file="WEB-INF/Vistas-Parciales/css-js.jspf" %>

</head>
<body style="background-color: #f8f8f8">
    
 <!-- Vistar parciales de la parte superior de nuestra aplicación -->
<%@include file="WEB-INF/Vistas-Parciales/encabezado.jspf"%>

<!-- Todo el contenido de la aplicación -->
<center>
<br><br>

<div>
<img src="img/logo.png" alt="600px"/>
</div>
<br><br><br>
<div class="container marketing">


<div class="row">
<div class="col-lg-4">
<img class="img-circle" src="img/July.jpg" alt="Generic placeholder image" width="140" height="140">
<h2>JULISSA ESMERALDA SALINAS MELÉNDEZ</h2>
<p class="lead" style=" font-family: 15px">Carnet: 185419.<br>
Grupo: Sistema 21 "A".<br>
Modulo:Aplicación de metodologías ágiles y testeo de software.
</p>
</div>

<div class="row">
<div class="col-lg-4">
<img class="img-circle" src="img/Carlos.jpg" alt="Generic placeholder image" width="140" height="140">
<h2>CARLOS ALFREDO ÁLVAREZ LÓPEZ</h2>
<p  class="lead"style=" font-family: 25px">Carnet: 186019.<br>
Grupo: Sistema 21 "A".<br>
Modulo:Aplicación de metodologías ágiles y testeo de software.
</p>
</div>

<div class="row">
<div class="col-lg-4">
<img class="img-circle" src="img/carmen.jpg" alt="Generic placeholder image" width="140" height="140">
<h2>ESPERANZA DEL CARMEN ESPINOZA ROJAS</h2>
<p class="lead" style=" font-family: 25px">Carnet: 185119.<br>
Grupo: Sistema 21 "A".<br>
Modulo:Aplicación de metodologías ágiles y testeo de software.
</p>
</div>
<div class="row">
<div class="col-mg-4">
<img class="img-circle" src="img/Willian.jpg" alt="Generic placeholder image" width="140" height="140">
<h2>WILLIAN ADALBERTO HERNÁNDEZ AQUINO</h2>
<p class="lead" style=" font-family: 25px">Carnet: 184219<br>
Grupo: Sistema 21 "A".<br>
Modulo:Aplicación de metodologías ágiles y testeo de software.
</p>
</div>  
<br><br><br>  
<div class="row">
<div class="col-mg-4">
<img class="img-circle" src="img/Kennya.jpg" alt="Generic placeholder image" width="140" height="140">
<h2>KENNYA CLARISSA CASTRO GARCÍA</h2>
<p class="lead" style=" font-family: 25px">Carnet: 184519.<br>
Grupo: Sistema 21 "A".<br>
Modulo:Aplicación de metodologías ágiles y testeo de software.
</p>
</div>  
</div>
<br><br><br><br>
<hr class="featurette-divider">
<div class="row featurette">
<div class="col-md-7">
<h2 class="featurette-heading">Ingeniero Manuel de Jesús Gámez López.</h2>
<br><br>
<p class="lead">Facilitador del modulo Aplicación de Metodologías Ágiles y Testeo de Software
de la Institucion MEGATEC ITCA-FEPADE ZACATECOLUCA.
</p>
</div>
<div class="col-md-5">
<img class="featurette-image img-responsive center-block" data-src="holder.js/500x500/" alt="500x500" src="img/profe.jpg" data-holder-rendered="true">
</div>
</div>

</center>   

<br><br><br><br>

<!-- Vistar parciales de la parte inferior de nuestra aplicación -->
<%@include file="WEB-INF/Vistas-Parciales/pie.jspf" %>
</body>
</html>
