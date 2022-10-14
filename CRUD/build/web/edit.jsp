<%-- 
    Document   : edit
    Created on : 13/10/2022, 12:25:22 PM
    Author     : Santiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="editar.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <body>
        <div>
            <div class="products-preview"> 
                <div class="preview">
                    <form action="Controlador" method="POST">
                        <label>
                            <i class='far fa-times-circle'></i>  
                            <input type="submit" name="accion" value="Listar" id='botonTrans'>
                            
                        </label>
                        
                       
                            
                         
                    </form>
                    
                    
                    <div>
                        <form action="Controlador" method="POST">
                            <h1>Editar a ${datosPerson.getNombre()}</h1>
                            <input type='text' placeholder='Id' required id='ide' name='tid' readonly value="${datosPerson.getId()}">
                            <input type='text' placeholder='Nombre' required id='nombre' name='tnombre' value="${datosPerson.getNombre()}">
                            <input type='text' placeholder='Apellidos' required id='apellido' name='tape' value="${datosPerson.getApellidos()}">
                            <input type='number' placeholder='Edad' required id='edad' name='tedad' value="${datosPerson.getEdad()}">
                            <input type='number' placeholder='Telefono' required id='telefono' name='ttelefono' value="${datosPerson.getTelefono()}">
                            <input type='email' placeholder='Correo' required id='email' name='temail' value="${datosPerson.getCorreo()}">
                            <input type='submit' name='accion' value='Guardar Cambios' id='boton'>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
