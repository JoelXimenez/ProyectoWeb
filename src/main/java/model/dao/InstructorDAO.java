package model.dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import model.entities.Instructor;

public class InstructorDAO extends GenericDAO<Instructor> {
    public InstructorDAO() {
        super(Instructor.class);
    }

    public Instructor findByCorreo(String correo) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery("SELECT i FROM Instructor i WHERE i.correo = :correo", Instructor.class)
                    .setParameter("correo", correo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; 
        } catch (Exception e) {
            System.err.println("Error finding instructor by email: " + e.getMessage());
            return null; 
        }
    }
    
    @Override
    public boolean create(Instructor entity) {
        return super.create(entity);
    }

}