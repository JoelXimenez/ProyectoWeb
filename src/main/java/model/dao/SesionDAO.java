package model.dao;

import model.entities.Sesion;

public class SesionDAO extends GenericDAO<Sesion> {

	public SesionDAO() {
		super(Sesion.class);
	}

	public void crear(Sesion s) {
		super.create(s);
	}

	public void eliminar(Sesion s) {
		if (s != null) {
			super.remove(s.getId());
		}
	}
}