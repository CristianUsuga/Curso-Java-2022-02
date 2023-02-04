/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ces2.clase2_taller_abstrac.controladores;

import ces2.clase2_taller_abstrac.entidades.Empleado;
import ces2.clase2_taller_abstrac.entidades.Independiente;
import ces2.clase2_taller_abstrac.entidades.Pensionado;
import ces2.clase2_taller_abstrac.entidades.Persona;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            HttpSession sesion = request.getSession(true);
            List<Persona> trabajadores;
            trabajadores = (List<Persona>) sesion.getAttribute("trabajadores");

            String nombre = request.getParameter("UserName");
            String tipo = request.getParameter("tipos");
          
            System.out.println(nombre);
            System.out.println(tipo);
            if (nombre != null && !nombre.isEmpty()
                    && tipo != null && !tipo.isEmpty()) {
            
                Empleado em;
                Pensionado contr;
                Independiente inde;
               
                if (tipo.equals("empleado")) {
                    em = new Empleado(nombre);
                    if (trabajadores == null) {
                        trabajadores = new ArrayList<>();
                        trabajadores.add(em);
                        sesion.setAttribute("trabajadores", trabajadores);
                    } else {
                        trabajadores.add(em);
                        
                    }
                } else if (tipo.equals("pensionado")) {
                    contr = new Pensionado(nombre);
                    if (trabajadores == null) {
                        trabajadores = new ArrayList<>();
                        trabajadores.add(contr);
                        sesion.setAttribute("trabajadores", trabajadores);
                       
                    } else {
                        trabajadores.add(contr);
                       
                    }
                }else if (tipo.equals("independiente")) {
                    inde = new Independiente(nombre);
                    if (trabajadores == null) {
                        trabajadores = new ArrayList<>();
                        trabajadores.add(inde);
                        sesion.setAttribute("trabajadores", trabajadores);
                       
                    } else {
                        trabajadores.add(inde);
                       
                    }
                }
                request.setAttribute("trabajadores", trabajadores);
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