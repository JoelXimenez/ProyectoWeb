package controller;

import jakarta.servlet.http.HttpServlet;
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
        
        default:
                throw new IllegalArgumentException("Ruta no encontrada: " + route);
        }
    }

    private void entrar(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("jsp/inicioSesion.jsp");
    }
    
}
