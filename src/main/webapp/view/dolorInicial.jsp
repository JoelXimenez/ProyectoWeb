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

    <main class="contenido-panel">
      <div class="tarjeta" style="text-align: center;">
        <h2 class="titulo-seccion">Iniciar sesión terapéutica</h2>
        <p style="margin-bottom: 2rem; font-style: italic; color: #555;">
          “Empieza a sanar”
        </p>

        <form class="formulario" method="post"
          action="${pageContext.request.contextPath}/EjecutarSesionController?route=registrarDolor"
          style="align-items: center;">
          <label for="dolorInicio" style="margin-bottom: 1rem;">Antes de comenzar. Selecciona tu nivel de molestia al
            inicio</label>
          <select name="dolorInicio" id="dolorInicio" required style="margin-bottom: 2rem; max-width: 300px;">
            <option value="">Seleccione</option>
            <option value="0">Sin dolor/molestia</option>
            <option value="1">Leve</option>
            <option value="2">Moderado</option>
            <option value="3">Intenso</option>
            <option value="4">Máximo dolor/molestia</option>
          </select>
          <button type="submit" class="btn btn-grande-centro">Registrar dolor</button>
        </form>
      </div>
    </main>
  </div>
</body>

</html>
