package model.service;

import model.dao.AdministradorDAO;
import model.entities.Administrador;

public class AdministradorService {
    private final AdministradorDAO administradorDAO;

    public AdministradorService() {
        this.administradorDAO = new AdministradorDAO();
    }

    public Administrador authenticate(String correo, String contrasena) {
        return administradorDAO.findByCorreoYContrasena(correo, contrasena);
    }
}
