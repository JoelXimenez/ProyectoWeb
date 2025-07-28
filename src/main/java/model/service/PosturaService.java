package model.service;

import java.util.List;

import model.dao.PosturaDAO;
import model.entities.Postura;

public class PosturaService {
    private final PosturaDAO posturaDAO;

    public PosturaService() {
        this.posturaDAO = new PosturaDAO();
    }

    public boolean guardar(Postura postura) {
        // Validar que no exista una postura con el mismo nombre
        if (posturaDAO.findByNombre(postura.getNombre()) != null) {
            return false; // Ya existe una postura con ese nombre
        }
        return posturaDAO.crear(postura);
    }

    public Postura buscarPorId(int id) {
        return posturaDAO.buscarPorId(id);
    }

    public List<Postura> buscarTodas() {
        return posturaDAO.buscarTodas();
    }

    public boolean actualizar(Postura postura) {
        // Verificar que la postura existe
        Postura existente = posturaDAO.buscarPorId(postura.getId());
        if (existente == null) {
            return false;
        }
        
        // Verificar que no haya otra postura con el mismo nombre (excepto la actual)
        Postura conMismoNombre = posturaDAO.findByNombre(postura.getNombre());
        if (conMismoNombre != null && conMismoNombre.getId() != postura.getId()) {
            return false;
        }
        
        return posturaDAO.actualizar(postura);
    }

    public boolean eliminar(int id) {
        Postura postura = posturaDAO.buscarPorId(id);
        if (postura != null) {
            return posturaDAO.eliminar(id);
        }
        return false;
    }

    public List<Postura> buscar(String termino) {
        if (termino == null || termino.trim().isEmpty()) {
            return buscarTodas();
        }
        return posturaDAO.buscarPorNombreParcial(termino.trim());
    }

    public boolean existePosturaConNombre(String nombre) {
        return posturaDAO.findByNombre(nombre) != null;
    }
}