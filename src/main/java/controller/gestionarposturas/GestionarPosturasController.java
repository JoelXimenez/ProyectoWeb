package controller.gestionarposturas;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.entities.Instructor;
import model.entities.Postura;
import model.service.PosturaService;

@WebServlet("/GestionarPosturasController")
public class GestionarPosturasController extends HttpServlet {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    private final PosturaService posturaService = new PosturaService();

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
            route = "listar";
        }

        // Verificar que el usuario sea un instructor
        if (!esInstructor(req)) {
            resp.sendRedirect(req.getContextPath() + "/LoginController?route=entrar");
            return;
        }

        switch (route) {
            case "listar":
                this.listarPosturas(req, resp);
                break;
            case "nuevo":
                this.mostrarFormularioNuevo(req, resp);
                break;
            case "guardar":
                this.guardarPostura(req, resp);
                break;
            case "editar":
                this.mostrarFormularioEditar(req, resp);
                break;
            case "actualizar":
                this.actualizarPostura(req, resp);
                break;
            case "eliminar":
                this.eliminarPostura(req, resp);
                break;
            case "buscar":
                this.buscarPosturas(req, resp);
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/GestionarPosturasController?route=listar");
        }
    }

    private boolean esInstructor(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session == null) return false;
        
        Object usuario = session.getAttribute("usuario");
        return usuario instanceof Instructor;
    }

    private void listarPosturas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Postura> posturas = posturaService.buscarTodas();
            req.setAttribute("posturas", posturas);
            req.getRequestDispatcher("/jsp/gestionPosturas.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Error al cargar las posturas: " + e.getMessage());
            req.getRequestDispatcher("/jsp/gestionPosturas.jsp").forward(req, resp);
        }
    }

    private void mostrarFormularioNuevo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accion", "guardar");
        req.setAttribute("tituloFormulario", "Nueva Postura");
        req.getRequestDispatcher("/jsp/formularioPostura.jsp").forward(req, resp);
    }

    private void guardarPostura(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Postura postura = construirPosturaDesdeRequest(req);
            
            if (posturaService.guardar(postura)) {
                req.setAttribute("success", "Postura guardada exitosamente");
            } else {
                req.setAttribute("error", "Error al guardar la postura. Es posible que ya exista una postura con ese nombre.");
            }
        } catch (Exception e) {
            req.setAttribute("error", "Error al procesar la postura: " + e.getMessage());
        }
        
        this.listarPosturas(req, resp);
    }

    private void mostrarFormularioEditar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Postura postura = posturaService.buscarPorId(id);
            
            if (postura != null) {
                req.setAttribute("postura", postura);
                req.setAttribute("accion", "actualizar");
                req.setAttribute("tituloFormulario", "Editar Postura");
                req.getRequestDispatcher("/jsp/formularioPostura.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Postura no encontrada");
                this.listarPosturas(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "ID de postura inválido");
            this.listarPosturas(req, resp);
        }
    }

    private void actualizarPostura(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Postura postura = construirPosturaDesdeRequest(req);
            int id = Integer.parseInt(req.getParameter("id"));
            postura.setId(id);
            
            if (posturaService.actualizar(postura)) {
                req.setAttribute("success", "Postura actualizada exitosamente");
            } else {
                req.setAttribute("error", "Error al actualizar la postura. Verifique que no exista otra postura con el mismo nombre.");
            }
        } catch (Exception e) {
            req.setAttribute("error", "Error al actualizar la postura: " + e.getMessage());
        }
        
        this.listarPosturas(req, resp);
    }

    private void eliminarPostura(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            
            if (posturaService.eliminar(id)) {
                req.setAttribute("success", "Postura eliminada exitosamente");
            } else {
                req.setAttribute("error", "Error al eliminar la postura");
            }
        } catch (NumberFormatException e) {
            req.setAttribute("error", "ID de postura inválido");
        } catch (Exception e) {
            req.setAttribute("error", "Error al eliminar la postura: " + e.getMessage());
        }
        
        this.listarPosturas(req, resp);
    }

    private void buscarPosturas(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String termino = req.getParameter("termino");
            List<Postura> posturas = posturaService.buscar(termino);
            
            req.setAttribute("posturas", posturas);
            req.setAttribute("terminoBusqueda", termino);
            req.getRequestDispatcher("/jsp/gestionPosturas.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("error", "Error en la búsqueda: " + e.getMessage());
            this.listarPosturas(req, resp);
        }
    }

    private Postura construirPosturaDesdeRequest(HttpServletRequest req) {
        String nombre = req.getParameter("nombre");
        String fotoUrl = req.getParameter("fotoUrl");
        String videoUrl = req.getParameter("videoUrl");
        String instrucciones = req.getParameter("instrucciones");
        String beneficios = req.getParameter("beneficios");

        // Validaciones básicas
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la postura es obligatorio");
        }

        if (instrucciones == null || instrucciones.trim().isEmpty()) {
            throw new IllegalArgumentException("Las instrucciones son obligatorias");
        }

        Postura postura = new Postura();
        postura.setNombre(nombre.trim());
        postura.setFotoUrl(fotoUrl != null ? fotoUrl.trim() : "");
        postura.setVideoUrl(videoUrl != null ? videoUrl.trim() : "");
        postura.setInstrucciones(instrucciones.trim());
        postura.setBeneficios(beneficios != null ? beneficios.trim() : "");

        return postura;
    }
}