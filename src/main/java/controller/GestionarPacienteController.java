package controller;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.entities.Instructor;
import model.entities.Paciente;
import model.service.PacienteService;

@WebServlet("/PacientesController")
public class GestionarPacienteController extends HttpServlet {
    
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.router(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.router(req, resp);
    }

    private void router(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String route = (req.getParameter("route") != null) ? "listar" : req.getParameter("route");

        switch (route) {
            case "guardar":
                this.registrarPaciente(req, resp);
                break;
            
            case "registrarPacienteFormulario":
                this.registrarPacienteFormulario(resp);
                break;
        
        default:
                throw new IllegalArgumentException("Ruta no encontrada: " + route);
        }
    }

    private void registrarPacienteFormulario(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("jsp/registroPaciente.jsp");
    }

    private void registrarPaciente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Paciente paciente = parseAddressFromRequest(req);
        PacienteService pacienteService = new PacienteService();
        if (pacienteService.guardar(paciente)) {
            req.setAttribute("mensaje", "Paciente registrado exitosamente");
        } else {
            req.setAttribute("mensaje", "Error al registrar paciente");
        }
    }

    private Paciente parseAddressFromRequest(HttpServletRequest req) {

        HttpSession session = req.getSession();
        Instructor instructor = (Instructor) session.getAttribute("usuario");
        int idUsuario = 0;
        String cedula = req.getParameter("cedula");
        String nombreCompleto = req.getParameter("nombre");
        String correo = req.getParameter("correo");
        String contrasena = req.getParameter("contrasena");
        String telefono = req.getParameter("telefono");
        String genero = req.getParameter("genero");
        LocalDate fechaNacimiento = LocalDate.parse(req.getParameter("fechaNacimiento"));

        return new Paciente(idUsuario, cedula, nombreCompleto, correo, contrasena, telefono, genero, fechaNacimiento, instructor);

    }

}