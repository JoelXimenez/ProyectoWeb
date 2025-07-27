package controller.login;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.Serial;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.dao.PacienteDAO;
import model.entities.Instructor;
import model.entities.Paciente;
import model.service.InstructorService;
import model.service.PacienteService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.router(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.router(req, resp);
    }

    private void router(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String route = req.getParameter("route");

        switch (route) {
            case "entrar":
                this.entrar(resp);
                break;
            case "login":
                this.login(req, resp);
                break;
            case "logOut":
                this.logOut(req, resp);
                break;
            default:
                throw new IllegalArgumentException("Ruta no encontrada: " + route);
        }
    }

    private void entrar(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("view/inicioSesion.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String correo = req.getParameter("correo");
        String contrasena = req.getParameter("contrasena");
        String rol = req.getParameter("rol");

        HttpSession session = req.getSession();

        if ("instructor".equalsIgnoreCase(rol)) {
            InstructorService instructorService = new InstructorService();
            Instructor instructor = instructorService.authenticate(correo, contrasena);
            if (instructor != null) {
                session.setAttribute("usuario", instructor);
                resp.sendRedirect(req.getContextPath() + "/view/dashboard.jsp");
                return;
            }
        } else if ("paciente".equalsIgnoreCase(rol)) {
            PacienteService pacienteService = new PacienteService();
            Paciente paciente = pacienteService.authenticate(correo, contrasena);
            if (paciente != null) {
                // ⚠️ Cargar paciente completo con serie y posturas
                PacienteDAO pacienteDAO = new PacienteDAO();
                Paciente pacienteCompleto = pacienteDAO.getPacienteConSerieYPosturas(paciente.getId());

                if (pacienteCompleto != null) {
                    session.setAttribute("paciente", pacienteCompleto); // ✅ GUARDAR COMO "paciente"
                    resp.sendRedirect(req.getContextPath() + "/EjecutarSesionController?route=dashboardPaciente");
                    return;
                }
            }
        }

        req.setAttribute("messageType", "error");
        req.setAttribute("message", "Credenciales inválidas. Intenta de nuevo.");
        req.getRequestDispatcher("view/inicioSesion.jsp").forward(req, resp);
    }

    private void logOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/view/inicioSesion.jsp");
    }
}
