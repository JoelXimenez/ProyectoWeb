<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Dashboard del Instructor</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body class="dashboard">
<div class="barra">
  <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo" class="logo" />
  <div class="marca">Equilibrio Vital</div>
  <button class="btn-cerrar-sesion" onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar sesión</button>
</div>
<div class="panel">
  <div class="menu-lateral">
    <a href="${pageContext.request.contextPath}/jsp/dashboard.jsp" class="btn-menu activo">Dashboard</a>
    <a href="${pageContext.request.contextPath}/GestionarPacienteController?route=listarPacientes" class="btn-menu">Gestionar pacientes</a>
    <a href="${pageContext.request.contextPath}/CrearSerieTerapeuticaController?route=crearSerie" class="btn-menu">Crear serie terapéutica</a>
    <a href="#" class="btn-menu">Asignar serie</a>
  </div>
  <div class="contenido-panel">
    <div class="tarjeta">
      <h2>Bienvenido, ${sessionScope.usuario.nombreCompleto}</h2>
      <p>Desde este panel puedes gestionar pacientes, crear y asignar series terapéuticas.</p>
    </div>
  </div>
</div>
</body>
</html>