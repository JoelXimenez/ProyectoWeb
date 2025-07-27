<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Mi Panel de Terapia</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>

<body class="dashboard">
  <!-- Barra superior -->
  <div class="barra">
    <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo Casa Anahata" class="logo" />
    <h1 class="marca">Equilibrio Vital</h1>
    <button class="btn-cerrar-sesion"
      onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar sesión</button>
  </div>

  <!-- Panel principal -->
  <div class="panel">
    <div class="menu-lateral">
      <button class="btn-menu activo">Mi Sesión Actual</button>
    </div>

    <div class="contenido-panel">
      <div class="tarjeta">
        <div class="postura-container">
          
          <!-- Progreso y título -->
          <div class="progreso-serie">Postura ${numeroPosturaActual} de ${totalPosturas}</div>
          <h2 id="postura-titulo">${posturaActual.nombre}</h2>

          <!-- Imagen de la postura -->
          <img id="postura-imagen" src="${pageContext.request.contextPath}/imagenes/${posturaActual.fotoUrl}"
     alt="Imagen de la postura" class="imagen-postura-grande">


          <!-- Temporizador (placeholder, puedes controlarlo con JS si deseas) -->
          <div id="timer-display" style="font-size: 4rem; font-weight: bold; margin: 1rem 0; color: #1ABC83;">02:00</div>

          <!-- Controles -->
          <div class="controles-sesion">
            <button id="start-pause-btn" class="btn btn-primario" type="button">Pausar</button>

            <!-- Ver instrucciones de la postura actual -->
            <a id="detalles-btn" href="${pageContext.request.contextPath}/EjecutarSesionController?route=verInstrucciones"
               class="btn btn-secundario">Ver Instrucciones</a>

            <!-- Avanzar a la siguiente postura -->
            <a href="${pageContext.request.contextPath}/EjecutarSesionController?route=siguientePostura"
               class="btn btn-secundario">Avanzar</a>
          </div>

        </div>
      </div>
    </div>
  </div>
</body>

</html>
