package model.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entities.Instructor;
import model.entities.Paciente;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertarPacientes {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // Obtener instructores
            Instructor instructor1 = em.find(Instructor.class, "123");
            Instructor instructor2 = em.find(Instructor.class, "0605914282");

            if (instructor1 == null || instructor2 == null) {
                System.out.println("❌ Alguno de los instructores no existe.");
                return;
            }

            // Pacientes para instructor 123
            Paciente p1 = new Paciente();
            p1.setId("0101010101");
            p1.setNombre("Juan Pérez");
            p1.setCorreo("juan.perez@example.com");
            p1.setTelefono("0991111111");
            p1.setContraseña("abc123");
            p1.setFechaNacimiento(sdf.parse("1995-05-10"));
            p1.setGenero('M');
            p1.setInstructor(instructor1);
            p1.setSerieAsignada(null);
            p1.setHistorialSesiones(null);
            em.persist(p1);

            Paciente p2 = new Paciente();
            p2.setId("0202020202");
            p2.setNombre("Ana Torres");
            p2.setCorreo("ana.torres@example.com");
            p2.setTelefono("0992222222");
            p2.setContraseña("def456");
            p2.setFechaNacimiento(sdf.parse("1990-08-22"));
            p2.setGenero('F');
            p2.setInstructor(instructor1);
            p2.setSerieAsignada(null);
            p2.setHistorialSesiones(null);
            em.persist(p2);

            // Pacientes para instructor 0605914282
            Paciente p3 = new Paciente();
            p3.setId("0303030303");
            p3.setNombre("Luis Andrade");
            p3.setCorreo("luis.andrade@example.com");
            p3.setTelefono("0993333333");
            p3.setContraseña("ghi789");
            p3.setFechaNacimiento(sdf.parse("1988-03-15"));
            p3.setGenero('M');
            p3.setInstructor(instructor2);
            p3.setSerieAsignada(null);
            p3.setHistorialSesiones(null);
            em.persist(p3);

            Paciente p4 = new Paciente();
            p4.setId("0404040404");
            p4.setNombre("María López");
            p4.setCorreo("maria.lopez@example.com");
            p4.setTelefono("0994444444");
            p4.setContraseña("jkl012");
            p4.setFechaNacimiento(sdf.parse("1993-11-30"));
            p4.setGenero('F');
            p4.setInstructor(instructor2);
            p4.setSerieAsignada(null);
            p4.setHistorialSesiones(null);
            em.persist(p4);

            em.getTransaction().commit();
            System.out.println("✅ Se insertaron los 4 pacientes correctamente.");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
