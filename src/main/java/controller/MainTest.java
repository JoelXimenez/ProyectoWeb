package controller;

import java.time.LocalDate;

import model.entities.Instructor;
import model.entities.Paciente;
import model.service.PacienteService;

public class MainTest {
    public static void main(String[] args) {
        // Simular valores como si vinieran del formulario (req.getParameter)
        int idUsuario = 0;
        String cedula = "0102030405";
        String nombreCompleto = "Juan Pérez";
        String correo = "juanperez@example.com";
        String contrasena = "123456";
        String telefono = "0991234567";
        String genero = "Masculino";
        LocalDate fechaNacimiento = LocalDate.parse("1990-05-15");

        // Simular un instructor ya existente con ID 1
        Instructor instructor = new Instructor();
        instructor.setIdUsuario(1); // solo seteamos el ID porque el DAO lo usará para relacionar

        // Crear paciente
        Paciente paciente = new Paciente(
            idUsuario,
            cedula,
            nombreCompleto,
            correo,
            contrasena,
            telefono,
            genero,
            fechaNacimiento,
            instructor
        );

        // Llamar al servicio
        PacienteService pacienteService = new PacienteService(); // debe tener el EntityManager dentro del DAO
        boolean resultado = pacienteService.guardar(paciente);

        if (resultado) {
            System.out.println("✅ Paciente guardado correctamente.");
        } else {
            System.out.println("❌ Error al guardar el paciente.");
        }
    }
}