package model.service;

import model.dao.PosturaDAO;
import model.dao.SerieDAO;
import model.entities.Serie;
import model.entities.Instructor;
import model.entities.Postura;
import java.util.List;
import java.util.UUID;

public class SerieService {
    private final SerieDAO serieDAO;

    public SerieService() {
        this.serieDAO = new SerieDAO();
    }

    public boolean guardar(Serie serie) {
        return serieDAO.create(serie);
    }

    public Serie buscarPorId(String id) {
        return serieDAO.findById(id);
    }

    public List<Serie> buscarTodas() {
        return serieDAO.findAll();
    }

    public Serie crearSerie(String nombre, int sesiones, List<String> nombresPosturas, Instructor instructor) {
        Serie serie = new Serie();
        serie.setId(UUID.randomUUID().toString()); // 👈 Aquí generas un ID único

        serie.setNombre(nombre);
        serie.setNumeroSesionesRecomendadas(sesiones);
        serie.setInstructor(instructor);
        serie.setSesionesCompletadas(0);
        serie.setSesionesTotales(0);

        // cargar posturas por nombre...
        PosturaDAO posturaDAO = new PosturaDAO();
        List<Postura> posturas = nombresPosturas.stream()
            .map(posturaDAO::findByNombre)
            .filter(p -> p != null)
            .toList();

        serie.setPosturas(posturas);
        return serie;
    }
    
    public List<Postura> obtenerPosturasDeSerie(String idSerie) {
        Serie serie = serieDAO.findById(idSerie);
        if (serie != null) {
            return serie.getPosturas();
        }
        return List.of();
    }
}