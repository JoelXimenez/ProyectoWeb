package controller.crearserieterapeutica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.PosturaDAO;
import model.entities.Instructor;
import model.entities.Postura;
import model.entities.Serie;
import model.service.SerieService;

@WebServlet("/CrearSerieTerapeutica")
public class CrearSerieTerapeuticaController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final SerieService serieService = new SerieService();
	
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
            route = "dashboard";
        }
		switch(route) {
			case "crearSerie":
				crearSerie(req, resp);
				break;
			case "seleccionarTipoTerapia":
				seleccionarTipoTerapia(req, resp);
				break;
			case "guardar":
				guardar(req, resp);
				break;
			default:
                resp.sendRedirect(req.getContextPath() + "/jsp/dashboard.jsp");
		}
	}
	
	private void crearSerie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/crearSerieTerapeutica.jsp").forward(req, resp);
	}
	
	private void seleccionarTipoTerapia(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipoTerapia = req.getParameter("tipoTerapia");

		PosturaDAO posturaDAO = new PosturaDAO();
		List<Postura> posturas = posturaDAO.obtenerPosturasPorTerapia(tipoTerapia);

		req.setAttribute("tipoSeleccionado", tipoTerapia);
		req.setAttribute("posturas", posturas);

		req.getRequestDispatcher("/jsp/crearSerieTerapeutica.jsp").forward(req, resp);
	}
	
	private void guardar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        String nombreSerie = req.getParameter("nombreSerie");
	        String tipoTerapia = req.getParameter("tipoTerapia");
	        String[] posturasSeleccionadas = req.getParameterValues("posturas");
	        String sesionesStr = req.getParameter("numSesiones");

	        if (nombreSerie == null || tipoTerapia == null || posturasSeleccionadas == null || sesionesStr == null ||
	            nombreSerie.isEmpty() || tipoTerapia.isEmpty() || sesionesStr.isEmpty()) {
	            req.setAttribute("error", "Faltan datos para crear la serie.");
	            req.getRequestDispatcher("/jsp/crearSerieTerapeutica.jsp").forward(req, resp);
	            return;
	        }

	        int numeroSesionesRecomendadas = Integer.parseInt(sesionesStr);

	        Instructor instructor = (Instructor) req.getSession().getAttribute("instructor");
	        if (instructor == null) {
	            req.setAttribute("error", "No se ha iniciado sesión correctamente.");
	            req.getRequestDispatcher("/jsp/inicioSesion.jsp").forward(req, resp);
	            return;
	        }

	        List<String> nombresPosturas = List.of(posturasSeleccionadas);

	        Serie serie = serieService.crearSerie(nombreSerie, tipoTerapia, numeroSesionesRecomendadas, nombresPosturas, instructor);
	        boolean guardadoExitoso = serieService.guardar(serie);

	        if (guardadoExitoso) {
	            req.setAttribute("serieCreada", serie);
	            req.getRequestDispatcher("/jsp/confirmacion.jsp").forward(req, resp);
	        } else {
	            req.setAttribute("error", "No se pudo guardar la serie.");
	            req.getRequestDispatcher("/jsp/crearSerieTerapeutica.jsp").forward(req, resp);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        req.setAttribute("error", "Error al guardar la serie: " + e.getMessage());
	        req.getRequestDispatcher("/jsp/crearSerieTerapeutica.jsp").forward(req, resp);
	    }
	}

}
