package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.dao.InstructorDAO;
import model.entities.Instructor; 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
 
@WebServlet("/RegistroInstructorController")
@MultipartConfig
public class RegistroInstructorController extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.router(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.router(request, response);
    }
 
    
    private void router(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String route = req.getParameter("route");
 
        switch (route) {
            case "registrarInstructor":
                this.mostrarRegistroFormulario(req, resp);
                break;
            case "regresar":
                this.regresar(req,resp);
                break;
            case "guardarRegistro":
                this.existeInstructor(req,resp);
                break;         
        
        default:
                throw new IllegalArgumentException("Ruta no encontrada: " + route);
        }
    }
 
	private void existeInstructor(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Instructor instructor = parseInstructorFromRequest(req);
		// Hasta Aqui funciona perfecto
		
		InstructorDAO instructorDAO = new InstructorDAO();
 
        // Verifica si ya existe un instructor con ese correo
        if (instructorDAO.findByCorreo(instructor.getCorreo()) != null) {
            req.setAttribute("mensaje", "Ya existe un instructor con ese correo");
            req.getRequestDispatcher("jsp/registroInstructor.jsp").forward(req, resp);
        } else {
            boolean creado = instructorDAO.create(instructor);
            if (creado) {
                resp.sendRedirect("jsp/inicioSesion.jsp");
            } else {
                req.setAttribute("mensaje", "Error al registrar el instructor");
                req.getRequestDispatcher("jsp/registroInstructor.jsp").forward(req, resp);
            }
        }		
	}
 
	private Instructor parseInstructorFromRequest(HttpServletRequest req) throws IOException, ServletException {
		// TODO Auto-generated method stub

        int idUsuario = 0;
		String cedula = getValue(req.getPart("id"));
	    String nombreCompleto = getValue(req.getPart("nombre"));
	    String correo = getValue(req.getPart("correo"));
	    String telefono = getValue(req.getPart("telefono"));
	    String contrasena = getValue(req.getPart("password"));
 
	    Part documentoPart = req.getPart("documento");
	    byte[] documentoBytes = null;
 
	    if (documentoPart != null && documentoPart.getSize() > 0) {
	        documentoBytes = documentoPart.getInputStream().readAllBytes();
	    }
 
	    Instructor instructor = new Instructor();
	    instructor.setIdUsuario(idUsuario);
        instructor.setCedula(cedula);
	    instructor.setNombreCompleto(nombreCompleto);
	    instructor.setCorreo(correo);
	    instructor.setTelefono(telefono);
	    instructor.setContrasena(contrasena);
	    instructor.setDocumentoEspecialidad(documentoBytes);
 
	    return instructor;
	}
 
	private String getValue(Part part) throws UnsupportedEncodingException, IOException {
		// TODO Auto-generated method stub
		if (part == null) return null;
	    return new String(part.getInputStream().readAllBytes(), "UTF-8").trim();
	}
 
	private void regresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.sendRedirect("jsp/inicioSesion.jsp");
 
		
	}
 
	private void mostrarRegistroFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.sendRedirect("jsp/registroInstructor.jsp");

	}
 
}
