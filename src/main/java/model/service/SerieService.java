package model.service;

import model.dao.SerieDAO;
import model.entities.Serie;
import model.entities.Instructor;
import model.entities.Postura;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SerieService {
    private final SerieDAO serieDAO;

    public SerieService() {
        this.serieDAO = new SerieDAO();
    }
    
    public Serie crearSerie(String nombreSerie, String tipoTerapia, int sesiones, List<String> nombresPosturas, Instructor instructor) {
        String id = UUID.randomUUID().toString();

        List<Postura> posturas = new ArrayList<>();
        for (String nombre : nombresPosturas) {
            Postura p = new Postura();
            p.setNombre(nombre);
            posturas.add(p);
        }

        int sesionesCompletadas = 0;
        int sesionesTotales = sesiones;

        return new Serie(id, instructor, nombreSerie, sesiones, posturas, sesionesCompletadas, sesionesTotales);
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