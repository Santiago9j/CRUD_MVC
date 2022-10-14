<%-- 
    Document   : index
    Created on : 13/10/2022, 09:21:19 AM
    Author     : Santiago
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="estilos.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <body>
        <div class="principal">
            <h1>Personas</h1>
            <form action = "Controlador" method="POST">
                    <input type="submit" name="accion" value="Listar">
            </form>
            <table class="dwr-table" width="100%" cellpadding="0" cellspacing="0" border="1" align="center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>NOMBRE</th>
                        <th>APELLIDOS</th>
                        <th>EDAD</th>
                        <th>TELEFONO</th>
                        <th>CORREO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dato" items="${datos}">
                        <tr>
                            <td>${dato.getId()}</td>
                            <td>${dato.getNombre()}</td>
                            <td>${dato.getApellidos()}</td>
                            <td>${dato.getEdad()}</td>
                            <td>${dato.getTelefono()}</td>
                            <td>${dato.getCorreo()}</td>
                            <td>
                                <form action="Controlador" method="POST">
                                    <input type="hidden" name="idU" value="${dato.getId()}">
                                    <input type="submit" name="accion" value="Editar" id="editar">
                                    <input type="submit" name="accion" value="Eliminar" id="eliminar">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    
                </tbody>

            </table>
            <input type="button" value="Añadir una persona" id="agregar" class="botton">
        </div>
        <script src="fun.js"></script>
    </body>
</html>
