package controller.EjecutarSesionController;

import java.io.IOException;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.entities.Paciente;
import model.entities.Postura;
import model.entities.Serie;
import model.entities.Sesion;
import model.service.SesionService;

@WebServlet("/EjecutarSesionController")
public class EjecutarSesionController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    private final SesionService sesionService = new SesionService();

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
        if (route == null) {
            route = "dashboardPaciente";
        }

        switch (route) {
            case "dashboardPaciente":
                req.getRequestDispatcher("/jsp/dashboardPaciente.jsp").forward(req, resp);
                break;
            case "iniciar":
                req.getRequestDispatcher("/jsp/dolorInicial.jsp").forward(req, resp);
                break;
            case "registrarDolor":
                registrarDolorEIniciar(req, resp);
                break;
            case "siguientePostura":
                avanzarSiguientePostura(req, resp);
                break;
            case "verInstrucciones":
                mostrarInstrucciones(req, resp);
                break;
            case "volverAEjecucion":
                volverAEjecucion(req, resp);
                break;
            case "registrarEvaluacion":
                registrarEvaluacionFinal(req, resp);
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/jsp/dashboardPaciente.jsp");
        }
    }

    private void registrarDolorEIniciar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("dolorInicial", req.getParameter("dolorInicio"));

        Paciente paciente = (Paciente) session.getAttribute("usuario");
        Serie serie = paciente.getSerieAsignada();

        if (serie != null && serie.getPosturas() != null && !serie.getPosturas().isEmpty()) {
            List<Postura> posturas = serie.getPosturas();
            session.setAttribute("posturasDeLaSesion", posturas);
            session.setAttribute("indicePosturaActual", 0);

            req.setAttribute("posturaActual", posturas.get(0));
            req.setAttribute("numeroPosturaActual", 1);
            req.setAttribute("totalPosturas", posturas.size());

            req.getRequestDispatcher("/jsp/posturaEjecucion.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/EjecutarSesionController?route=dashboardPaciente");
        }
    }

    private void avanzarSiguientePostura(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Postura> posturas = (List<Postura>) session.getAttribute("posturasDeLaSesion");
        int indiceActual = (int) session.getAttribute("indicePosturaActual");

        int indiceSiguiente = indiceActual + 1;

        if (indiceSiguiente < posturas.size()) {
            session.setAttribute("indicePosturaActual", indiceSiguiente);
            req.setAttribute("posturaActual", posturas.get(indiceSiguiente));
            req.setAttribute("numeroPosturaActual", indiceSiguiente + 1);
            req.setAttribute("totalPosturas", posturas.size());
            req.getRequestDispatcher("/jsp/posturaEjecucion.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/jsp/evaluacionFinal.jsp").forward(req, resp);
        }
    }

    private void registrarEvaluacionFinal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();

        Paciente paciente = (Paciente) session.getAttribute("usuario");
        Serie serie = paciente.getSerieAsignada();
        String dolorInicial = (String) session.getAttribute("dolorInicial");

        Sesion nuevaSesion = new Sesion();
        nuevaSesion.setPaciente(paciente);
        nuevaSesion.setSerie(serie);
        nuevaSesion.setFecha(LocalDateTime.now());
        nuevaSesion.setDolorInicial(dolorInicial);
        nuevaSesion.setDolorFinal(req.getParameter("dolorFinal"));
        nuevaSesion.setComentario(req.getParameter("comentario"));

        sesionService.guardar(nuevaSesion);

        session.invalidate();
        resp.sendRedirect(req.getContextPath() + "/LoginController?route=login"); // Redirigir al login para recargar datos
    }

    private void mostrarInstrucciones(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Postura> posturas = (List<Postura>) session.getAttribute("posturasDeLaSesion");
        int indiceActual = (int) session.getAttribute("indicePosturaActual");

        req.setAttribute("posturaDetallada", posturas.get(indiceActual));
        req.getRequestDispatcher("/jsp/visualizarPostura.jsp").forward(req, resp);
    }

    private void volverAEjecucion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Postura> posturas = (List<Postura>) session.getAttribute("posturasDeLaSesion");
        int indiceActual = (int) session.getAttribute("indicePosturaActual");

        req.setAttribute("posturaActual", posturas.get(indiceActual));
        req.setAttribute("numeroPosturaActual", indiceActual + 1);
        req.setAttribute("totalPosturas", posturas.size());

        req.getRequestDispatcher("/jsp/posturaEjecucion.jsp").forward(req, resp);
    }
}