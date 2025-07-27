package controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.entities.Instructor;
import model.entities.Paciente;
import model.entities.Usuario;
import model.service.PacienteService;
import model.service.UsuarioService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
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
        resp.sendRedirect("jsp/inicioSesion.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String correo = req.getParameter("correo");
        String contrasena = req.getParameter("contrasena");
        String rol = req.getParameter("rol");

        UsuarioService userService = new UsuarioService();
        Usuario usuario = userService.authenticate(correo, contrasena, rol);

        if (usuario != null) {
            HttpSession session = req.getSession();
            session.setAttribute("usuario", usuario);
            req.setAttribute("messageType", "info");
            req.setAttribute("message", "Login successful! Welcome to your dashboard.");

            if (usuario instanceof Instructor) {
                resp.sendRedirect(req.getContextPath() + "/jsp/dashboard.jsp");
            } else if (usuario instanceof Paciente) {
                resp.sendRedirect(req.getContextPath() + "/EjecutarSesionController?route=dashboardPaciente");
            }
        } else {
            req.setAttribute("messageType", "error");
            req.setAttribute("message", "Invalid credentials. Please try again.");
            req.getRequestDispatcher("jsp/iniciosesion.jsp").forward(req, resp);
        }
    }

    private void logOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        
        resp.sendRedirect(req.getContextPath() + "/jsp/inicioSesion.jsp");
    }

}
