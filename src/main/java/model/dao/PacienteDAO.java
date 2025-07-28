package model.dao;

import java.util.List;

import model.entities.Paciente;
import model.entities.Serie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class PacienteDAO extends GenericDAO<Paciente> {

    public PacienteDAO() {
        super(Paciente.class);
    }

    public Paciente findByCorreo(String correo) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery("SELECT p FROM Paciente p WHERE p.correo = :correo", Paciente.class)
                    .setParameter("correo", correo)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.err.println("Error buscando paciente por correo: " + e.getMessage());
            return null;
        }
    }

    /**
     * ✅ CORREGIDO: Método recomendado para obtener pacientes por cédula del
     * instructor
     */
    public List<Paciente> getPacientesByInstructor(String cedulaInstructor) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT p FROM Paciente p WHERE p.instructor.cedula = :cedula", Paciente.class)
                    .setParameter("cedula", cedulaInstructor)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Error al listar pacientes por instructor: " + e.getMessage());
            return List.of(); // Retornar lista vacía si falla
        }
    }

    public Paciente findHistorialById(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT p FROM Paciente p LEFT JOIN FETCH p.historialSesiones WHERE p.id = :id",
                    Paciente.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean create(Paciente entity) {
        return super.create(entity);
    }

    @Override
    public Paciente findById(Object id) {
        // TODO Auto-generated method stub
        return super.findById(id);
    }

    @Override
    public boolean update(Paciente entity) {
        // TODO Auto-generated method stub
        return super.update(entity);
    }

    public boolean tieneSerieAsignada(String pacienteId) {
        try (EntityManager em = getEntityManager()) {
            Paciente paciente = em.find(Paciente.class, pacienteId);
            return paciente != null && paciente.tieneSerieAsignada();
        } catch (Exception e) {
            System.err.println("Error verificando serie asignada: " + e.getMessage());
            return false;
        }
    }

    public boolean guardarSerie(String pacienteId, String serieId) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            Paciente paciente = em.find(Paciente.class, pacienteId);
            Serie serie = em.find(Serie.class, serieId);

            if (paciente != null && serie != null) {
                paciente.setSerieAsignada(serie);
                em.merge(paciente);
                em.getTransaction().commit();
                return true;
            }

            em.getTransaction().rollback();
            return false;
        } catch (Exception e) {
            System.err.println("Error guardando serie en paciente: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        } finally {
            em.close();
        }
    }

    public Paciente getPacienteConSerieYPosturas(String pacienteId) {
        try (EntityManager em = getEntityManager()) {
            return em.createQuery(
                    "SELECT p FROM Paciente p " +
                            "LEFT JOIN FETCH p.serieAsignada s " +
                            "LEFT JOIN FETCH s.posturas " +
                            "WHERE p.id = :id",
                    Paciente.class)
                    .setParameter("id", pacienteId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            System.err.println("Error cargando paciente con serie y posturas: " + e.getMessage());
            return null;
        }
    }

}
