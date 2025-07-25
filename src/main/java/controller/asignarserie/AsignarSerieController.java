package controller.asignarserie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AsignarSerieController")
public class AsignarSerieController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void listarPacientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.-Obtener los parametros
		//2.-Hablar con el Modelo
		//3.-Llamar a la vista
	}

	private void listarSeriesTerapeuticas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.-Obtener los parametros
		//2.-Hablar con el Modelo
		//3.-Llamar a la vista
	}

	private void asignarSerie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.-Obtener los parametros
		//2.-Hablar con el Modelo
		//3.-Llamar a la vista
	}

}
