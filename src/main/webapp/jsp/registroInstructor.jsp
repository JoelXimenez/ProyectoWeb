<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <!DOCTYPE html>
  <html lang="es">

  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Equilibrio Vital - Inicio de Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  </head>

  <body class="fondo">
    <div class="contenedor-izquierdo">
      <h1 class="titulo-logo">Equilibrio Vital</h1>
      <div class="contenedor-formulario">
        <form class="formulario" method="POST" action="${pageContext.request.contextPath}/LoginController?route=login">
          <h2 style="margin-bottom: 1.5rem;">Iniciar Sesión</h2>
          <input type="email" name="correo" placeholder="Correo electrónico" required>
          <input type="password" name="contrasena" placeholder="Contraseña" required>

          <div class="grupo-botones-rol">
            <div class="fila-doble-rol">
              <button type="submit" name="rol" value="paciente" class="btn btn-primario btn-rol">
                Entrar como Paciente
              </button>
              <button type="submit" name="rol" value="instructor" class="btn btn-primario btn-rol">
                Entrar como Instructor
              </button>
            </div>
            <button type="submit" name="rol" value="administrador" class="btn btn-secundario btn-rol">
              Entrar como Administrador
            </button>
          </div>

          <p class="enlace-registro">¿Eres instructor y no tienes cuenta? <a
              href="${pageContext.request.contextPath}/RegistroInstructorController?route=registrarInstructor">Regístrate
              aquí</a>
          </p>

          <p class="enlace-registro" style="margin-top: 0.5rem;">
            ¿Eres un paciente nuevo?
            <a href="activarCuenta.html">Activa tu cuenta aquí</a>
          </p>
        </form>

      </div>
    </div>
    <!-- Modal para mensajes informativos y de error -->
    <div class="modal fade" id="infoModal" tabindex="-1" aria-labelledby="infoModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content border-0">
          <div class="modal-body bg-info text-white text-center rounded">
            <i class="fas fa-info-circle fa-2x me-2"></i>
            <span class="fs-5">${message}</span>
          </div>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <script>
      window.onload = function () {
        // Mostrar modal informativo si hay mensaje
        const message = "${message}";
        if (message !== "") {
          const infoModalElement = document.getElementById("infoModal");
          if (infoModalElement) {
            const infoModal = new bootstrap.Modal(infoModalElement, {
              backdrop: false, // Sin fondo oscuro
              keyboard: false  // Desactiva cerrar con teclado
            });
            infoModal.show();

            // Cerrar automáticamente después de 5 segundos
            setTimeout(() => {
              infoModal.hide();
            }, 5000);
          }
        }
      };
    </script>

  </body>

  </html>