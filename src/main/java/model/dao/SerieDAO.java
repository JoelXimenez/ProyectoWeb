package model.dao;

import model.entities.Postura;
import model.entities.Serie;
import java.util.Collections;
import java.util.List;

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
}