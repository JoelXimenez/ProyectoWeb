<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Equilibrio Vital - Inicio de Sesión</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body class="fondo">
<div class="contenedor-izquierdo">
  <h1 class="titulo-logo">Equilibrio Vital</h1>
  <div class="contenedor-formulario">
    <form class="formulario" method="POST" action="${pageContext.request.contextPath}/LoginController?route=login">
      <h2>Iniciar Sesión</h2>
      <input type="email" name="correo" placeholder="Correo electrónico" required>
      <input type="password" name="contrasena" placeholder="Contraseña" required>
      <div class="grupo-botones-rol">
        <div class="fila-doble-rol">
          <button type="submit" name="rol" value="paciente" class="btn btn-primario btn-rol">Entrar como Paciente</button>
          <button type="submit" name="rol" value="instructor" class="btn btn-primario btn-rol">Entrar como Instructor</button>
        </div>
        <button type="submit" name="rol" value="administrador" class="btn btn-secundario btn-rol">Entrar como Administrador</button>
      </div>
      <p class="enlace-registro">¿Eres instructor y no tienes cuenta? <a href="${pageContext.request.contextPath}/RegistroInstructorController?route=registrarInstructor">Regístrate aquí</a></p>
      <p class="enlace-registro">¿Eres un paciente nuevo? <a href="#">Activa tu cuenta aquí</a></p>
    </form>
  </div>
</div>
</body>
</html>