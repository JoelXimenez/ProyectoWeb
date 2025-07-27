package model.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entities.Instructor;
import model.entities.Postura;
import model.entities.Serie;

import java.util.ArrayList;
import java.util.List;

public class SeedSeries {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // ✅ Obtener el instructor con ID 0605914282
            Instructor instructor = em.find(Instructor.class, "0605914209");
            if (instructor == null) {
                System.out.println("❌ Instructor con ID  0605914209 no existe.");
                return;
            }

            // ✅ Obtener al menos 6 posturas
            List<Postura> todasPosturas = em.createQuery("SELECT p FROM Postura p", Postura.class).getResultList();
            if (todasPosturas.size() < 6) {
                System.out.println("❌ Debes tener al menos 6 posturas registradas.");
                return;
            }

            // ✅ Asignar 3 posturas a cada serie
            List<Postura> posturasSerie1 = new ArrayList<>(todasPosturas.subList(0, 3));
            List<Postura> posturasSerie2 = new ArrayList<>(todasPosturas.subList(3, 6));

            // ✅ Crear Serie Energizante
            Serie serie1 = new Serie();
            serie1.setId("SERIE01");
            serie1.setNombre("Serie Energizante");
            serie1.setNumeroSesionesRecomendadas(3);
            serie1.setSesionesCompletadas(0);
            serie1.setSesionesTotales(3);
            serie1.setInstructor(instructor);
            serie1.setPosturas(posturasSerie1);
            serie1.setSesiones(null);
            em.persist(serie1);

            // ✅ Crear Serie Restaurativa
            Serie serie2 = new Serie();
            serie2.setId("SERIE02");
            serie2.setNombre("Serie Restaurativa");
            serie2.setNumeroSesionesRecomendadas(5);
            serie2.setSesionesCompletadas(0);
            serie2.setSesionesTotales(5);
            serie2.setInstructor(instructor);
            serie2.setPosturas(posturasSerie2);
            serie2.setSesiones(null);
            em.persist(serie2);

            em.getTransaction().commit();
            System.out.println("✅ Se insertaron correctamente las 2 series con 3 posturas cada una.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
