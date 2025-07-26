<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Equilibrio Vital - Inicio de Sesión</title>
  <link rel="stylesheet" href="../css/style.css" />
</head>

<body class="fondo">
  <div class="contenedor-izquierdo">
    <h1 class="titulo-logo">Equilibrio Vital</h1>
    <div class="contenedor-formulario">
      <form class="formulario" method="POST">
        <h2 style="margin-bottom: 1.5rem;">Iniciar Sesión</h2>
        <input type="email" name="correo" placeholder="Correo electrónico" required>
        <input type="password" name="password" placeholder="Contraseña" required>

        <div class="grupo-botones-rol">
          <div class="fila-doble-rol">
            <button type="submit" formaction="dashboardPaciente.html" class="btn btn-primario btn-rol">Entrar como
              Paciente</button>
            <button type="submit" formaction="dashboard.html" class="btn btn-primario btn-rol">Entrar como
              Instructor</button>
          </div>
          <button type="submit" formaction="gestionPosturas.html" class="btn btn-secundario btn-rol">Entrar como
            Administrador</button>
        </div>
        <p class="enlace-registro">
          ¿Eres instructor y no tienes cuenta?
          <a href="registro.html">Regístrate aquí</a>
        </p>

        <p class="enlace-registro" style="margin-top: 0.5rem;">
          ¿Eres un paciente nuevo?
          <a href="activarCuenta.html">Activa tu cuenta aquí</a>
        </p>

      </form>
    </div>
  </div>
</body>

</html>