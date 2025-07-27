package controller.registrarinstructor;

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
 
	private static final long serialVersionUID = 1L;

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

        if (route == null) {
            // Puedes redirigir, lanzar un error más claro, o mostrar la vista por defecto
            resp.sendRedirect("view/registroInstructor.jsp");
            return;
        }

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
            req.getRequestDispatcher("view/registroInstructor.jsp").forward(req, resp);
        } else {
            boolean creado = instructorDAO.create(instructor);
            if (creado) {
                resp.sendRedirect("view/inicioSesion.jsp");
            } else {
                req.setAttribute("mensaje", "Error al registrar el instructor");
                req.getRequestDispatcher("view/registroInstructor.jsp").forward(req, resp);
            }
        }		
	}
 
	private Instructor parseInstructorFromRequest(HttpServletRequest req) throws IOException, ServletException {
	    String cedula = getValue(req.getPart("id"));
	    String nombre = getValue(req.getPart("nombre"));
	    String correo = getValue(req.getPart("correo"));
	    String telefono = getValue(req.getPart("telefono"));
	    String password = getValue(req.getPart("password"));

	    Part documentoPart = req.getPart("documento");
	    byte[] documentoBytes = null;

	    if (documentoPart != null && documentoPart.getSize() > 0) {
	        documentoBytes = documentoPart.getInputStream().readAllBytes();
	    }

	    Instructor instructor = new Instructor();
	    instructor.setCedula(cedula);
	    instructor.setNombre(nombre);
	    instructor.setCorreo(correo);
	    instructor.setTelefono(telefono);
	    instructor.setPassword(password);
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
        response.sendRedirect("view/inicioSesion.jsp");
 
		
	}
 
	private void mostrarRegistroFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.sendRedirect("view/registroInstructor.jsp");

	}
 
}