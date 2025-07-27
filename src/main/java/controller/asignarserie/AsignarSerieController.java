package controller.asignarserie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import model.dao.PacienteDAO;
import model.dao.SerieDAO;
import model.entities.Instructor;
import model.entities.Paciente;
import model.entities.Serie;

@WebServlet("/AsignarSerieController")
public class AsignarSerieController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        router(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        router(request, response);
    }

    private void router(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        Instructor instructor = (session != null) ? (Instructor) session.getAttribute("usuario") : null;

        if (instructor == null) {
            response.sendRedirect(request.getContextPath() + "/LoginController?route=entrar");
            return;
        }

        String route = request.getParameter("route");

        switch (route == null ? "listar" : route) {
            case "listar":
                listarPacientes(request, response);
                listarSeries(request, response);
                request.getRequestDispatcher("view/AsignarSerie.jsp").forward(request, response);
                break;

            case "asignar":
                asignarSerie(request, response);
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ruta no válida: " + route);
        }
    }

    private void listarPacientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Instructor instructor = (session != null) ? (Instructor) session.getAttribute("usuario") : null;

        if (instructor != null) {
            String instructorId = instructor.getCedula();
            PacienteDAO pacienteDAO = new PacienteDAO();
            List<Paciente> pacientes = pacienteDAO.getPacientesByInstructor(instructorId);
            request.setAttribute("pacientes", pacientes);
        }
    }

    private void listarSeries(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Instructor instructor = (session != null) ? (Instructor) session.getAttribute("usuario") : null;

        if (instructor != null) {
            String instructorId = instructor.getCedula();
            SerieDAO serieDAO = new SerieDAO();
            List<Serie> series = serieDAO.getSeriesByInstructor(instructorId);
            request.setAttribute("series", series);
        }
    }

    private void asignarSerie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pacienteId = request.getParameter("pacienteId");
        String serieId = request.getParameter("serieId");

        if (pacienteId == null || serieId == null) {
            request.setAttribute("asignacionExitosa", false);
            request.setAttribute("messageType", "warning");
            request.setAttribute("message", " Faltan parámetros para asignar la serie.");
        } else {
            PacienteDAO pacienteDAO = new PacienteDAO();

            if (!pacienteDAO.tieneSerieAsignada(pacienteId)) {
                boolean resultado = pacienteDAO.guardarSerie(pacienteId, serieId);

                if (resultado) {
                    request.setAttribute("asignacionExitosa", true);
                    request.setAttribute("messageType", "success");
                    request.setAttribute("message", " Se asignó correctamente la serie al paciente.");
                } else {
                    request.setAttribute("asignacionExitosa", false);
                    request.setAttribute("messageType", "warning");
                    request.setAttribute("message", " Error al asignar la serie.");
                }

            } else {
                request.setAttribute("asignacionExitosa", false);
                request.setAttribute("messageType", "warning");
                request.setAttribute("message", " El paciente ya tiene una serie asignada.");
            }
        }

        request.getRequestDispatcher("view/mensaje.jsp").forward(request, response);
    }
}
