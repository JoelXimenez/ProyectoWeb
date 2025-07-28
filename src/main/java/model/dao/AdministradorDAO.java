package model.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import model.entities.Administrador;

public class AdministradorDAO {
    private EntityManager em;

    public AdministradorDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        this.em = emf.createEntityManager();
    }

    public Administrador findByCorreoYContrasena(String correo, String contrasena) {
        try {
            return em.createQuery(
                "SELECT a FROM Administrador a WHERE a.correo = :correo AND a.contrasena = :contrasena",
                Administrador.class
            )
            .setParameter("correo", correo)
            .setParameter("contrasena", contrasena)
            .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
