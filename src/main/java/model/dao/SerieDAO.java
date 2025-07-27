package model.dao;

import model.entities.Postura;
import model.entities.Serie;
import java.util.Collections;
import java.util.List;
import jakarta.persistence.EntityManager;

public class SerieDAO extends GenericDAO<Serie> {

	public SerieDAO() {
		super(Serie.class);
	}

	public void crear(Serie s) {
		super.create(s);
	}

	public List<Serie> getSeries() {
		return super.findAll();
	}

	public Postura getSiguientePostura() {
		return null;
	}
	public List<Serie> getSeriesByInstructor(String cedulaInstructor) {
	    try (EntityManager em = getEntityManager()) {
	        return em.createQuery(
	                "SELECT s FROM Serie s WHERE s.instructor.cedula = :cedula", Serie.class)
	                .setParameter("cedula", cedulaInstructor)
	                .getResultList();
	    } catch (Exception e) {
	        System.err.println("Error al obtener series del instructor: " + e.getMessage());
	        return Collections.emptyList();
	    }
	}
	
}