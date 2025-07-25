package model.dao;

import model.entities.Postura;

public interface PosturaDAO {
	
	public void crear (Postura p);
	public void actualizar (Postura p);
	public void desactivar (int id);
}
