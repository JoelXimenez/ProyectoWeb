package model.service;

import model.dao.InstructorDAO;
import model.entities.Instructor;

public class InstructorService {

    public Instructor authenticate(String correo, String contrasena) {
        InstructorDAO dao = new InstructorDAO();
        Instructor instructor = dao.findByCorreo(correo);

        if (instructor != null && instructor.getPassword().equals(contrasena)) {
            return instructor;
        }

        return null;
    }
}
