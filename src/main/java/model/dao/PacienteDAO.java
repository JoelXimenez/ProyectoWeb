package model.dao;

import java.util.List;

import model.entities.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class PacienteDAO extends GenericDAO<Paciente> {
    public PacienteDAO() {
        super(Paciente.class);
    }

    public Paciente findByCorreo(String correo) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery("SELECT p FROM Paciente p WHERE p.correo = :correo", Paciente.class)
                    .setParameter("correo", correo)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null; // No paciente found with the given email
        } catch (Exception e) {
            System.err.println("Error finding paciente by email: " + e.getMessage());
            return null; // Handle other exceptions as needed
        }
    }

    public List<Paciente> findByInstructor(int idInstructor) {
        try (EntityManager em = getEntityManager()) {
            String jpql = "SELECT p FROM Paciente p WHERE p.instructor.idUsuario = :idInstructor";
            return em.createQuery(jpql, Paciente.class)
                    .setParameter("idInstructor", idInstructor)
                    .getResultList();
        } catch (Exception e) {
            return List.of(); 
        }
    }

    @Override
    public boolean create(Paciente entity) {

        return super.create(entity);
    }

}

