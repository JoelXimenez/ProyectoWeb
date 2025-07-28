package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.conexion.ConexionBD;
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
	
	public List<Postura> obtenerPosturasPorTerapia(String tipoTerapia) {
	    List<Postura> posturas = new ArrayList<>();

	    String sql = "SELECT nombre FROM posturas WHERE tipo_terapia = ?";
	    try (Connection conn = ConexionBD.getConexion();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, tipoTerapia);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	String nombre = rs.getString("nombre");
	        	Postura postura = new Postura();
	        	postura.setNombre(nombre);
	        	posturas.add(postura);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return posturas;
	}

}