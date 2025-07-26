package model.dao;

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
}