<%-- 
    Document   : crearProducto
    Created on : 06-23-2020, 06:59:58 AM
    Author     : W. Hernandez
--%>
<!--El desplegue de categoria, esta en la linea 115-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-----Para importar los datos de la clase Producto------>
<jsp:useBean id="producto" scope="session" class="Model.Producto"/>
<jsp:useBean id="categoria" scope="session" class="Model.Categoria"/>

<%
String id = "";
String nombre_pro = "";
String des_pro = "";
String stock_pro = "";
String precio_pro = "";
String unidad_pro = "";
String estado_pro = "";
String categoria_pro = "";
String fecha_pro = "";

if(request.getParameter("senal")!=null){
        
id = request.getParameter("id_p");
nombre_pro = request.getParameter("nombre_p");
des_pro = request.getParameter("desc_p");
stock_pro = request.getParameter("stock_p");
precio_pro = request.getParameter("precio_p");
unidad_pro = request.getParameter("unidad_p");
estado_pro = request.getParameter("estado_p");
categoria_pro = request.getParameter("cat_p");
fecha_pro = request.getParameter("fecha_p");
}else{
id = String.valueOf(producto.getId_producto()); //Id predeterminado cero definido en el constructor
nombre_pro = producto.getNom_producto();
des_pro = producto.getDes_producto();
stock_pro = String.valueOf(producto.getStock());
precio_pro = String.valueOf(producto.getPrecio());
unidad_pro = producto.getUnidadMedida();
estado_pro = String.valueOf(producto.getEstado());
categoria_pro = String.valueOf(producto.getCategoria_id());
fecha_pro = producto.getFecha_entrada();
}
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de inventario</title>
        <%@include file = "../WEB-INF/Vistas-Parciales/css-js.jspf" %>
        
<script type="text/javascript">
function regresar(url){ //Funcion para el boton regresar
location.href = url;
}
</script>
        
</head>
<body>
<%@include file = "../WEB-INF/Vistas-Parciales/encabezado.jspf" %>
        
 <div class="container">
    <div class="row">
       <div class="col-lg-8 col-md-6 col-sm-4">
           
           <h3 class="alert-primary">Nuevo Producto</h3>
            <form class="form-horizontal" id="frmProducto" name="frmProducto" action="<%= request.getContextPath() %>/productos" method="post">
<input type="hidden" name="id_producto" value="<%= id %>" >
            
<div class="form-group">
<label for="txtNomProducto" class="col-sm-2 control-label">Nombre:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtNomProducto" value="<%= nombre_pro %>" required>
</div>
</div>
                
<div class="form-group">
<label for="txtDesProducto" class="col-sm-2 control-label">Descripcion:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtDesProducto" value="<%= des_pro %>" required>
</div>
</div>

<div class="form-group">
<label for="txtStockProducto" class="col-sm-2 control-label">Stock:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtStockProducto" value="<%= stock_pro %>" required>
</div>
</div>

<div class="form-group">
<label for="txtPrecioProducto" class="col-sm-2 control-label">Precio:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtPrecioProducto" value="<%= precio_pro %>" required>
</div>
</div>

<div class="form-group">
<label for="txtUnidadProducto" class="col-sm-2 control-label">Unidad de medida:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtUnidadProducto" value="<%= unidad_pro %>" required>
</div>
</div>

<div class="form-group">
<label for="txtEstadoProducto" class="col-sm-2 control-label">Estado:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtEstadoProducto" value="<%= estado_pro %>" required>
</div>
</div>

<div class="form-group">
<label for="txtIdCategoria" class="col-sm-2 control-label">Categoria:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtIdCategoria" value="<%= categoria_pro %>" required>
</div>
</div>
<!--Aqui esta el despliegue lo comente porque al intentar guardar con este select tan error 500
asi que,si van probar este select no borrer el input text txtIdCategoria,cuando termine de probar
comentelo de nuevo,PD: Se supone que esto deberia ser una Arraylist pero esta solamente es una prueba
de como se veria con el arraylist,bueno intente ver como se puede solucionar,ya me estoy preguntado 
como se tendria que conectar la conexion del la bd para quede los datos de categoria pueda funcionar
al momento de seleccionar en el producto,bueno eso es todo, y lo de comentar este select es para prevenir el error 500
por eso lo deje asi..
<select name="tb_categoria" id = "tb_categoria">
      <option value="">Elige una opción</option>
	<option value = "7">Leche </option>
	<option value = "8">Carnes </option>
        <option value = "9" >Frutas</option>
        <option value = "10">Bebidas</option>
        <option value = "12">Licores</option>
        <option value = "13">Boquitas</option>
        <option value = "15">Galletas</option>
        <option value = "16">Limon</option>
</select>
</div>
</div>
-->
<div class="form-group">
<label for="txtFechaProducto" class="col-sm-2 control-label">Fecha:</label>
<div class="col-sm-10">
<input type="text" class="form-control" name="txtFechaProducto" value="<%= fecha_pro %>">
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
<input type="button" class="btn btn-info btn-sm" onclick="regresar('<%= request.getContextPath() %>/productos?opcion=listar')" 
name="btnRegresar" value="Regresar" />
</div>
</div>   
</form>
</div>
</div>
</div>

              
<%@include file = "../WEB-INF/Vistas-Parciales/pie.jspf" %>
    </body>
</html>

