<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
       <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <hr>
        <center><h1>ELIMINAR PEDIDO</h1></center>
        <hr>
      <br>
        <center>
        <P>Id Pedido :<input type="text" id="id_pedido" />    <br>
        <P>Producto :<input type="text" id="producto" />    <br>
        <P>cantidad :<input type="text" id="cantidad" />    <br>
        <P>Precio :<input type="text" id="precio" />    <br>
            <br>
        <input type="button" value="Eliminar" id="boton-guardar">   
        <input type="button" id="boton-recobrar" value="Cancelar">    <br>
       </center>
        <select name="nombres" id="todos" hidden>
             
            </select>
       
        <script>
        
       $("#boton-recobrar").click(function(){ 
        $("#todos").show();/* Este hace que se vea la chingadera de menu */   
        $("#todos").empty(); /* con esta funcion empty vaciamos todo, si  no se te juntaran un chingo de registros en el select de html */   
  $.getJSON("http://localhost:8092/ProyectoFinalPedidos",function(result){
    $.each(result, function(i, campo){
      $("#todos").append("<option>"+campo.nombre + "</option> ");
    });
  });
});

$("#boton-guardar").click(function(){
    var producto=$("#producto").val();
    var cantidad=$("#cantidad").val();
    var precio=$("#precio").val();
                    $.ajax({
        method:'POST',
        url:"http://localhost:8092/ProyectoFinalPedidos"+producto+"/"+cantidad+"/"+precio,
        success:function(valor){
            alert(valor);
        },
        failure:function(e){
            alert(e);
        }
    });
});

        </script>
      
        <div></div>
    </body>
</html>
