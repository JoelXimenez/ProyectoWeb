package model.service;

import model.dao.SerieDAO;
import model.entities.Serie;
import model.entities.Postura;
import java.util.List;

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

    public List<Postura> obtenerPosturasDeSerie(String idSerie) {
        Serie serie = serieDAO.findById(idSerie);
        if (serie != null) {
            return serie.getPosturas();
        }
        return List.of();
    }
}