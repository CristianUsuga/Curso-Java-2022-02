<%@page import="ces2.clase2_taller_abstrac.entidades.Persona"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h1>Prestamo</h1>
    <body>
        <%
            List<Persona> trabajadores = (List<Persona>) request.getAttribute("trabajadores");
            
            
            if(trabajadores !=null){
                for (Persona p : trabajadores) {
                        
        %>
        <span><%= p.condicionesCredito(230, 110) %></span>
        <% 
                }
            }   
        %>
        <br>
        <br>
        <h2>Ingrese aqu&iacute;</h2>
        <form action="ControladorServlet" method="POST">
            <label for="UserName">Nombre Usuario:</label><br>
            <input type="text" id="UserName" name="UserName" placeholder="Nombre de Usuario">
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