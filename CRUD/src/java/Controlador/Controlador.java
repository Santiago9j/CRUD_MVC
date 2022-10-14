/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago
 */
public class Controlador extends HttpServlet {
    Conexion dao = new Conexion();
    Usuario persona = new Usuario();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dao.Conectar();
        String accion = request.getParameter("accion");
        switch (accion){
            case "Listar":{
                try{
                    ArrayList<Usuario> datos = dao.listar_usuarios();
                    System.out.println("Todo bien..,.");
                    request.setAttribute("datos", datos);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                
                    break;
                } catch (Exception e){
                    System.out.println("Error al listar los usuarios");
                }
                
            } case "Agregar":{
                
                String id = request.getParameter("tid");
                String nombre = request.getParameter("tnombre");
                String apellidos = request.getParameter("tape");
                String edad = request.getParameter("tedad");
                String telefono = request.getParameter("ttelefono");
                String correo = request.getParameter("temail");
                persona.setId(Integer.parseInt(id));
                persona.setNombre(nombre);
                persona.setApellidos(apellidos);
                persona.setEdad(Integer.parseInt(edad));
                persona.setTelefono(telefono);
                persona.setCorreo(correo);
                dao.agregar(persona);
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);   
                    
                    
                break;
            
            } case "Editar":{
                System.out.println("sdf");
                String id = request.getParameter("idU");
                
                persona = dao.listarId(Integer.parseInt(id));
                request.setAttribute("datosPerson", persona);
                request.getRequestDispatcher("edit.jsp").forward(request, response);
                break;
            
            } case "Guardar Cambios":{
                String idg = request.getParameter("tid");
                String nombreg = request.getParameter("tnombre");
                String apellidosg = request.getParameter("tape");
                String edadg = request.getParameter("tedad");
                String telefonog = request.getParameter("ttelefono");
                String correog = request.getParameter("temail");
                persona.setId(Integer.parseInt(idg));
                persona.setNombre(nombreg);
                persona.setApellidos(apellidosg);
                persona.setEdad(Integer.parseInt(edadg));
                persona.setTelefono(telefonog);
                persona.setCorreo(correog);
                System.out.println(persona.toString());
                dao.actualizar(persona);
                System.out.println("Actualizar");
                /*System.out.println(persona.toString());*/
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);  
                System.out.println("Acáaaaaaa");
                break;
            } case "Eliminar":{
                String idElim = request.getParameter("idU");
                dao.eliminar(Integer.parseInt(idElim));
                request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                break;
            }default:{
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
