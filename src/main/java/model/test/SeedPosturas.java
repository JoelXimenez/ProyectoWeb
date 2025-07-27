package model.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entities.Postura;

public class SeedPosturas {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("persistence");
            em = emf.createEntityManager();

            em.getTransaction().begin();

            em.persist(create(
                    "Tadasana (Postura de la Montaña)",
                    "https://miapp.com/img/tadasana.jpg",
                    "https://miapp.com/video/tadasana.mp4",
                    "Párate con los pies juntos, activa las piernas, alarga la columna y relaja los hombros. Respira profundo.",
                    "Mejora la postura, fortalece piernas y aumenta la consciencia corporal."
            ));

            em.persist(create(
                    "Adho Mukha Svanasana (Perro mirando hacia abajo)",
                    "https://miapp.com/img/adho_mukha.jpg",
                    "https://miapp.com/video/adho_mukha.mp4",
                    "Desde tabla, empuja caderas hacia arriba formando una V invertida, talones al suelo y manos firmes.",
                    "Estira isquiotibiales, hombros y espalda; energiza el cuerpo."
            ));

            em.persist(create(
                    "Bhujangasana (Cobra)",
                    "https://miapp.com/img/bhujangasana.jpg",
                    "https://miapp.com/video/bhujangasana.mp4",
                    "Acuéstate boca abajo, manos bajo hombros, eleva el pecho manteniendo pubis en el suelo.",
                    "Fortalece la espalda baja, abre el pecho y mejora la flexibilidad de la columna."
            ));

            em.persist(create(
                    "Balasana (Postura del Niño)",
                    "https://miapp.com/img/balasana.jpg",
                    "https://miapp.com/video/balasana.mp4",
                    "Desde rodillas, lleva glúteos a talones, frente al suelo y brazos hacia adelante o a los lados.",
                    "Relaja la espalda, reduce el estrés y calma el sistema nervioso."
            ));

            em.persist(create(
                    "Virabhadrasana I (Guerrero I)",
                    "https://miapp.com/img/virabhadrasana1.jpg",
                    "https://miapp.com/video/virabhadrasana1.mp4",
                    "Pierna delantera flexionada, trasera extendida, caderas al frente, brazos arriba.",
                    "Fortalece piernas, mejora el equilibrio y la estabilidad."
            ));

            em.persist(create(
                    "Virabhadrasana II (Guerrero II)",
                    "https://miapp.com/img/virabhadrasana2.jpg",
                    "https://miapp.com/video/virabhadrasana2.mp4",
                    "Pierna delantera flexionada, brazos extendidos en línea, mirada a la mano delantera.",
                    "Aumenta fuerza en piernas y enfoque mental."
            ));

            em.persist(create(
                    "Trikonasana (Triángulo)",
                    "https://miapp.com/img/trikonasana.jpg",
                    "https://miapp.com/video/trikonasana.mp4",
                    "Con piernas separadas, lleva la mano al tobillo delantero y el otro brazo al cielo.",
                    "Estira la cadena lateral del cuerpo y abre caderas."
            ));

            em.persist(create(
                    "Setu Bandhasana (Puente)",
                    "https://miapp.com/img/puente.jpg",
                    "https://miapp.com/video/puente.mp4",
                    "Acostado boca arriba, flexiona rodillas y eleva la pelvis, hombros apoyados.",
                    "Fortalece glúteos y espalda, abre el pecho."
            ));

            em.persist(create(
                    "Paschimottanasana (Pinza Sentada)",
                    "https://miapp.com/img/paschimottanasana.jpg",
                    "https://miapp.com/video/paschimottanasana.mp4",
                    "Desde sentado, alarga columna y flexiona el tronco hacia las piernas, manos hacia pies.",
                    "Estira la espalda y isquiotibiales, calma la mente."
            ));

            em.persist(create(
                    "Savasana (Postura del Cadáver)",
                    "https://miapp.com/img/savasana.jpg",
                    "https://miapp.com/video/savasana.mp4",
                    "Acuéstate boca arriba, relaja todo el cuerpo y respira de forma natural.",
                    "Profunda relajación, integración de la práctica y reducción del estrés."
            ));

            em.getTransaction().commit();
            System.out.println("✅ 10 posturas insertadas correctamente.");
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }
    }

    private static Postura create(String nombre, String fotoUrl, String videoUrl, String instrucciones, String beneficios) {
        Postura p = new Postura();
        p.setNombre(nombre);
        p.setFotoUrl(fotoUrl);
        p.setVideoUrl(videoUrl);
        p.setInstrucciones(instrucciones);
        p.setBeneficios(beneficios);
        return p;
    }
}
