<%-- 
    Document   : index
    Created on : 8 feb. 2024, 22:09:13
    Author     : Candy Nohemi
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" 
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bungee&family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container-sm 5">
        <h1>SOA - Velazco 20490742</h1>
        <div>
            <a class="btn" href="NewController?accion=listar">Listar</a>
        </div>
        <br>
        <div style="display: flex; gap: 5em">
            <!-- Formulario para agregar persona -->
            <form action="NewController" method="POST">
                <div >
                    <b><label>Nombre</label></b>
                    <input type="text" name="form-nombre" class="form-control">
                </div>
                <div>
                    <b><label>Apellido</label></b>
                    <input type="text" name="form-apellido" class="form-control">
                </div>
                <br>
                <input type="submit" class="btn" value="Agregar" name="accion">
            </form>
            <!-- Formulario para editar persona -->
            <form action="NewController" method="POST">
                <div>
                    <b><label>ID</label></b>
                    <input type="text" name="edit-id" class="form-control">
                </div>
                <div>
                    <b><label>Nombre</label></b>
                    <input type="text" name="edit-nombre" class="form-control">
                </div>
                <div >
                    <b><label>Apellido</label></b>
                    <input type="text" name="edit-apellido" class="form-control">
                </div>
                <br>
                <input type="submit" class="btn" value="Editar" name="accion">
            </form>
            <!-- Formulario para buscar persona -->
            <form action="NewController" method="POST">
                <div>
                    <b><label>ID</label></b>
                    <input type="text" name="busc-id" class="form-control">
                </div>
                <br>
                <input type="submit" class="btn" value="Buscar" name="accion">
            </form>
        </div>
        <br>
        <table style="text-align: center">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterar sobre la lista de personas -->
                <c:forEach var="persona" items="${Personas}">
                    <tr>
                        <!-- Mostrar los detalles de la persona -->
                        <td>${persona.id}</td>
                        <td>${persona.nombre}</td>
                        <td>${persona.apellido}</td>
                        <td>
                                <a class="btn" href="NewController?accion=Eliminar&id=${persona.id}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                <c:if test="${empty Personas}">
                    <tr>
                        <td colspan="4">No hay personas para mostrar.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
    <br>
<footer>
    <h6>Candy Nohemí Velazco Mendiola - 20490742</h6>
    <center> © 2024 ITMexicali </center>
</footer>
</body>
</html>

