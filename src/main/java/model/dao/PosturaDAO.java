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

	public void crear(Postura p) {
		super.create(p);
	}

	public void actualizar(Postura p) {
		super.update(p);
	}

	public void desactivar(int id) {
		Postura postura = findById(id);
		if (postura != null) {
			super.update(postura);
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