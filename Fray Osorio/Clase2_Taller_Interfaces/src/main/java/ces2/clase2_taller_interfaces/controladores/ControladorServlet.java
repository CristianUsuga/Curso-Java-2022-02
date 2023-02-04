/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ces2.clase2_taller_interfaces.controladores;

import ces2.clase2_taller_interfaces.entidades.Empleado;
import ces2.clase2_taller_interfaces.entidades.Independiente;
import ces2.clase2_taller_interfaces.entidades.Pensionado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author usuga
 */
public class ControladorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession sesion = request.getSession(true);
            List<Pensionado> trabajadores;
            trabajadores = (List<Pensionado>) sesion.getAttribute("trabajadores");
            
            List<Empleado> empleados;
            empleados = (List<Empleado>) sesion.getAttribute("empleados");
            
            List<Independiente> independientes;
            independientes = (List<Independiente>) sesion.getAttribute("independientes");
            
            
            String nombre = request.getParameter("UserName");
            String tipo = request.getParameter("tipos");
            
            if (nombre != null && !nombre.isEmpty()
                    && tipo != null && !tipo.isEmpty()) {
                Pensionado pen;
                Empleado emp;
                Independiente ind;
                
                if (tipo.equals("pensionado")) {
                    pen = new Pensionado(nombre);
                    if (trabajadores == null) {
                        trabajadores = new ArrayList<>();
                        trabajadores.add(pen);
                        sesion.setAttribute("trabajadores", trabajadores);
                         System.out.println(nombre);    
                    } else {
                        trabajadores.add(pen);
                        
                    }
                }
                
                if (tipo.equals("empleado")) {
                    emp = new Empleado(nombre);
                    if (empleados == null) {
                        empleados = new ArrayList<>();
                        empleados.add(emp);
                        sesion.setAttribute("empleados", empleados);
                         System.out.println(nombre);    
                    } else {
                        empleados.add(emp);
                        
                    }
                }
                
                if (tipo.equals("independiente")) {
                    ind = new Independiente(nombre);
                    if (independientes == null) {
                        independientes = new ArrayList<>();
                        independientes.add(ind);
                        sesion.setAttribute("independientes", independientes);
                        System.out.println(nombre);    
                    } else {
                        independientes.add(ind);
                    }
                }
                System.out.println(nombre);
                System.out.println(tipo);
//              
                
                
                request.setAttribute("trabajadores", trabajadores);
                request.setAttribute("empleados", empleados);
                request.setAttribute("independientes", independientes);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                out.println("Se debe ingresar el nombre y el tipo");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
