<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Evaluación Final</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>

<body class="dashboard">
  <div class="barra">
    <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo Equilibrio Vital" class="logo">
    <h1 class="marca">Equilibrio Vital</h1>
    <button class="btn-cerrar-sesion"
      onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar sesión</button>
  </div>

  <div class="panel">
    <div class="menu-lateral">
      <button class="btn-menu activo">Mi Sesión Actual</button>
    </div>

    <div class="contenido-panel">
      <div class="tarjeta" style="padding: 2rem;">
        <h2>Evaluación después de la sesión</h2>

        <%-- El formulario ahora envía los datos al servlet vía POST --%>
        <form class="formulario" action="${pageContext.request.contextPath}/EjecutarSesionController?route=registrarEvaluacion" method="POST">
    <%-- Mostramos un mensaje de error si existe --%>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <label for="dolorFinal" style="margin-bottom: 1rem;">Nivel de molestia al final</label>
    <select name="dolorFinal" id="dolorFinal" required style="margin-bottom: 2rem; max-width: 300px;">
        <option value="">Seleccione</option>
        <option value="Sin dolor/molestia">Sin dolor/molestia</option>
        <option value="Leve">Leve</option>
        <option value="Moderado">Moderado</option>
        <option value="Intenso">Intenso</option>
        <option value="Máximo dolor/molestia">Máximo dolor/molestia</option>
    </select>

    <label for="comentario" style="margin-bottom: 1rem;">Comentario sobre la sesión</label>
    <textarea id="comentario" name="comentario" rows="5" required
        style="margin-bottom: 2rem; max-width: 100%;"></textarea>

    <button type="submit" class="btn btn-grande-centro">Finalizar y Guardar Sesión</button>
</form>


      </div>
    </div>
  </div>
</body>
</html>