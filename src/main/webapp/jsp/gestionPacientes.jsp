<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
        <!DOCTYPE html>
        <html lang="es">

        <head>
            <meta charset="UTF-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Gestión de Pacientes</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        </head>

        <body class="dashboard">
            <div class="barra">
                <img src="../assets/img/logo.png" alt="Logo" class="logo" />
                <div class="marca">Equilibrio Vital</div>
                <button class="btn-cerrar-sesion" onclick="location.href='inicioSesion.html'">Cerrar sesión</button>
            </div>
            <div class="panel">
                <div class="menu-lateral">
                    <button class="btn-menu" onclick="location.href='dashboard.html'">Dashboard</button>
                    <button class="btn-menu activo">Gestionar pacientes</button>
                    <button class="btn-menu" onclick="location.href='crearSerie.html'">Crear serie terapéutica</button>
                    <button class="btn-menu" onclick="location.href='asignarSerie.html'">Asignar serie</button>
                </div>
                <div class="contenido-panel">
                    <div class="tarjeta">
                        <div class="header-gestion">
                            <h2>Gestión de Pacientes</h2>
                            <a href="${pageContext.request.contextPath}/GestionarPacienteController?route=registrarPacienteFormulario"
                                class="btn btn-primario">Registrar Nuevo Paciente</a>
                        </div>

                        <input type="text" placeholder="Buscar por nombre o correo..."
                            style="width:100%; max-width:400px; margin-bottom: 1rem;">

                        <table class="tabla-pacientes">
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Correo Electrónico</th>
                                    <th>Contraseña</th>
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
                                        <td>${paciente.contrasena}</td>
                                        <td>${paciente.telefono}</td>
                                        <td class="acciones-paciente">
                                            <a href="${pageContext.request.contextPath}/GestionarPacienteController?route=editarPaciente&id=${paciente.idUsuario}"
                                                class="btn btn-secundario">Editar</a>
                                            <a href="${pageContext.request.contextPath}/GestionarPacienteController?route=detalleSesion&id=${paciente.idUsuario}"
                                                class="btn btn-secundario">Historial</a>
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