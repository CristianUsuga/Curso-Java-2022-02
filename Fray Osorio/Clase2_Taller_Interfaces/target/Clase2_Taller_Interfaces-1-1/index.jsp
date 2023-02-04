<%-- 
    Document   : index
    Created on : 9/09/2022, 5:48:06 a. m.
    Author     : usuga
--%>



<%@page import="ces2.clase2_taller_interfaces.entidades.AutorizaPrestamo"%>
<%@page import="ces2.clase2_taller_interfaces.entidades.CreditoHipotecario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


<h1>Prestamo</h1>
        <%
            List<AutorizaPrestamo> trabajadores = (List<AutorizaPrestamo>) request.getAttribute("trabajadores");
            List<AutorizaPrestamo> empleados = (List<AutorizaPrestamo>) request.getAttribute("empleados");
            List<AutorizaPrestamo> independientes = (List<AutorizaPrestamo>) request.getAttribute("independientes");

            if (trabajadores != null) {
                for (AutorizaPrestamo p : trabajadores) {
        %>
        <span><%= p.condicionesCredito(300, 10)%></span><br> 
        <%
                }
            }

            if (empleados != null) {
                for (AutorizaPrestamo p : empleados) {
        %>
        <span><%= p.condicionesCredito(500, 100)%></span><br>
        <%
                }
            }

            if (independientes != null) {
                for (AutorizaPrestamo p : independientes) {
        %>
        <span><%= p.condicionesCredito(190, 24) %></span><br>
        <%
                }
            }

        %>

        <br>
        <br>
        <h2>Ingrese aqu&iacute;</h2>
        <form action="ControladorServlet" method="POST" >
            <label for="UserName ">Nombre Usuario:</label><br>
            <input type="text" id="UserName" name="UserName" placeholder="Nombre Usuario">
            <br>
            <br>
            <label for="tipos">Seleccione un tipo:</label>
            <select id="tipos" name="tipos">

                <option value="pensionado">Pensionado</option>
                <option value="empleado">Empleado</option>
                <option value="independiente">Independiente</option>
            </select>
            <br>
            <br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
