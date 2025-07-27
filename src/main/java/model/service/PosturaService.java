package model.service;

import model.dao.PosturaDAO;
import model.entities.Postura;
import java.util.List;

public class PosturaService {
    private final PosturaDAO posturaDAO;

    public PosturaService() {
        this.posturaDAO = new PosturaDAO();
    }

    public boolean guardar(Postura postura) {
        return posturaDAO.create(postura);
    }

    public Postura buscarPorId(int id) {
        return posturaDAO.findById(id);
    }

    public List<Postura> buscarTodas() {
        return posturaDAO.findAll();
    }

    public boolean actualizar(Postura postura) {
        return posturaDAO.update(postura);
    }

    public boolean desactivar(int id) {
        Postura postura = posturaDAO.findById(id);
        if (postura != null) {
            return posturaDAO.update(postura);
        }
        return false;
    }
}