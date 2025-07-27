<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Mi Panel de Terapia</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body class="dashboard">
<div class="barra">
  <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo" class="logo">
  <h1 class="marca">Equilibrio Vital</h1>
  <button class="btn-cerrar-sesion" onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar sesión</button>
</div>
<div class="panel">
  <div class="menu-lateral">
    <button class="btn-menu activo">Mi Sesión Actual</button>
  </div>
  <main class="contenido-panel">
    <div class="tarjeta" style="text-align: center;">
      <h2>Bienvenido, ${sessionScope.paciente.nombre}</h2>
      <p style="margin-bottom: 1rem; color: #555;">Tu serie terapéutica asignada está lista para ti.</p>

      <!-- ✅ NO USAR ['serieAsignada'] ya que el método booleano fue eliminado -->
      <c:set var="serie" value="${sessionScope.paciente.serieAsignada}" />

      <c:if test="${not empty serie}">
        <div class="tarjeta" style="background-color: #f8f9fa; margin-top: 2rem;">
          <h3 style="margin-top:0;">${serie.nombre}</h3>
          <p><strong>Sesiones recomendadas:</strong> ${serie.numeroSesionesRecomendadas}</p>
        </div>
        <a href="${pageContext.request.contextPath}/EjecutarSesionController?route=iniciar" class="btn btn-grande-centro">Comenzar Sesión</a>
      </c:if>

      <c:if test="${empty serie}">
        <p>Aún no tienes una serie terapéutica asignada.</p>
      </c:if>
    </div>
  </main>
</div>
</body>
</html>
