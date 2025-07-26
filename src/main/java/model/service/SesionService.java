package model.service;

import model.dao.SesionDAO;
import model.entities.Sesion;

public class SesionService {
    private final SesionDAO sesionDAO;

    public SesionService() {
        this.sesionDAO = new SesionDAO();
    }

    public boolean guardar(Sesion sesion) {
        return sesionDAO.create(sesion);
    }
}