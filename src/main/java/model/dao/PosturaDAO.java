package model.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import model.entities.Postura;

public class PosturaDAO extends GenericDAO<Postura> {

	public PosturaDAO() {
		super(Postura.class);
	}

	public boolean crear(Postura p) {
		return super.create(p);
	}

	public boolean actualizar(Postura p) {
		return super.update(p);
	}

	public boolean eliminar(int id) {
		return super.remove(id);
	}

	public Postura buscarPorId(int id) {
		return super.findById(id);
	}

	public List<Postura> buscarTodas() {
		return super.findAll();
	}

	public Postura findByNombre(String nombre) {
		try (EntityManager em = getEntityManager()) {
			return em.createQuery("SELECT p FROM Postura p WHERE p.nombre = :nombre", Postura.class)
					.setParameter("nombre", nombre)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			System.err.println("Error finding postura by nombre: " + e.getMessage());
			return null;
		}
	}

	public List<Postura> buscarPorNombreParcial(String nombreParcial) {
		try (EntityManager em = getEntityManager()) {
			return em.createQuery("SELECT p FROM Postura p WHERE p.nombre LIKE :nombre", Postura.class)
					.setParameter("nombre", "%" + nombreParcial + "%")
					.getResultList();
		} catch (Exception e) {
			System.err.println("Error searching posturas: " + e.getMessage());
			return List.of();
		}
	}
}