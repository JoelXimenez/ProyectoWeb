<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Gestión de Pacientes</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="dashboard">
<div class="barra">
    <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo" class="logo" />
    <div class="marca">Equilibrio Vital</div>
    <button class="btn-cerrar-sesion" onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar sesión</button>
</div>
<div class="panel">
    <div class="menu-lateral">
        <a href="${pageContext.request.contextPath}/jsp/dashboard.jsp" class="btn-menu">Dashboard</a>
        <a href="${pageContext.request.contextPath}/GestionarPacienteController?route=listarPacientes" class="btn-menu activo">Gestionar pacientes</a>
        <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=listar" class="btn-menu">Gestionar posturas</a>
        <a href="#" class="btn-menu">Crear serie terapéutica</a>
        <a href="#" class="btn-menu">Asignar serie</a>
    </div>
    <div class="contenido-panel">
        <div class="tarjeta">
            <div class="header-gestion">
                <h2>Gestión de Pacientes</h2>
                <a href="${pageContext.request.contextPath}/GestionarPacienteController?route=registrarPacienteFormulario" class="btn btn-primario">Registrar Nuevo Paciente</a>
            </div>
            <table class="tabla-pacientes">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pacientes}" var="paciente">
                    <tr>
                        <td>${paciente.idUsuario}</td>
                        <td>${paciente.nombreCompleto}</td>
                        <td>${paciente.correo}</td>
                        <td>${paciente.telefono}</td>
                        <td class="acciones-paciente">
                            <a href="${pageContext.request.contextPath}/GestionarPacienteController?route=editarPaciente&id=${paciente.idUsuario}" class="btn btn-secundario">Editar</a>
                            <a href="#" class="btn btn-secundario">Historial</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>