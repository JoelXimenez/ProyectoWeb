<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Nivel de Dolor Inicial</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body class="dashboard">
<div class="barra">
  <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="Logo" class="logo">
  <h1 class="marca">Equilibrio Vital</h1>
</div>
<main class="contenido-panel">
  <div class="tarjeta" style="text-align: center;">
    <h2>Iniciar sesión terapéutica</h2>
    <p style="margin-bottom: 2rem;">“Empieza a sanar”</p>
    <form class="formulario" action="${pageContext.request.contextPath}/EjecutarSesionController" method="POST">
      <input type="hidden" name="route" value="registrarDolor">
      <label for="dolorInicio">Selecciona tu nivel de molestia al inicio</label>
      <select name="dolorInicio" id="dolorInicio" required>
        <option value="">Seleccione</option>
        <option value="Sin dolor/molestia">Sin dolor/molestia</option>
        <option value="Leve">Leve</option>
        <option value="Moderado">Moderado</option>
        <option value="Intenso">Intenso</option>
        <option value="Máximo dolor/molestia">Máximo dolor/molestia</option>
      </select>
      <button type="submit" class="btn btn-grande-centro">Registrar dolor</button>
    </form>
  </div>
</main>
</body>
</html>