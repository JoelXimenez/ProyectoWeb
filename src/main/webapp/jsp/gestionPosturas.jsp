<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Gestión de Posturas</title>
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
        <a href="${pageContext.request.contextPath}/GestionarPacienteController?route=listarPacientes" class="btn-menu">Gestionar pacientes</a>
        <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=listar" class="btn-menu activo">Gestionar posturas</a>
        <a href="#" class="btn-menu">Crear serie terapéutica</a>
        <a href="#" class="btn-menu">Asignar serie</a>
    </div>
    <div class="contenido-panel">
        <div class="tarjeta">
            <!-- Mensajes de éxito y error -->
            <c:if test="${not empty success}">
                <div class="mensaje-exito">
                    <strong>Éxito:</strong> ${success}
                </div>
            </c:if>
            
            <c:if test="${not empty error}">
                <div class="mensaje-error">
                    <strong>Error:</strong> ${error}
                </div>
            </c:if>

            <!-- Header con búsqueda y botón nuevo -->
            <div class="header-gestion">
                <h2>Gestión de Posturas</h2>
                <div class="acciones-header">
                    <form method="GET" action="${pageContext.request.contextPath}/GestionarPosturasController" class="form-busqueda">
                        <input type="hidden" name="route" value="buscar">
                        <input type="text" name="termino" placeholder="Buscar por nombre..." value="${terminoBusqueda}" class="input-busqueda">
                        <button type="submit" class="btn btn-secundario">Buscar</button>
                        <c:if test="${not empty terminoBusqueda}">
                            <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=listar" class="btn btn-secundario">Limpiar</a>
                        </c:if>
                    </form>
                    <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=nuevo" class="btn btn-primario">Nueva Postura</a>
                </div>
            </div>

            <!-- Tabla de posturas -->
            <c:choose>
                <c:when test="${empty posturas}">
                    <div class="mensaje-vacio">
                        <p>No se encontraron posturas.</p>
                        <c:if test="${not empty terminoBusqueda}">
                            <p>Intenta con otro término de búsqueda o <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=listar">ver todas las posturas</a>.</p>
                        </c:if>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="info-resultados">
                        <c:choose>
                            <c:when test="${not empty terminoBusqueda}">
                                <p>Se encontraron ${posturas.size()} resultado(s) para "${terminoBusqueda}"</p>
                            </c:when>
                            <c:otherwise>
                                <p>Total de posturas: ${posturas.size()}</p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    
                    <table class="tabla-posturas">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Imagen</th>
                            <th>Video</th>
                            <th>Instrucciones</th>
                            <th>Beneficios</th>
                            <th>Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${posturas}" var="postura">
                            <tr>
                                <td>${postura.id}</td>
                                <td class="nombre-postura">${postura.nombre}</td>
                                <td class="celda-imagen">
                                    <c:choose>
                                        <c:when test="${not empty postura.fotoUrl}">
                                            <img src="${pageContext.request.contextPath}/${postura.fotoUrl}" 
                                                 alt="${postura.nombre}" class="imagen-miniatura">
                                        </c:when>
                                        <c:otherwise>
                                            <span class="sin-imagen">Sin imagen</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="celda-video">
                                    <c:choose>
                                        <c:when test="${not empty postura.videoUrl}">
                                            <a href="${postura.videoUrl}" target="_blank" class="enlace-video">Ver video</a>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="sin-video">Sin video</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td class="celda-instrucciones">
                                    <div class="texto-truncado" title="${postura.instrucciones}">
                                        ${postura.instrucciones}
                                    </div>
                                </td>
                                <td class="celda-beneficios">
                                    <div class="texto-truncado" title="${postura.beneficios}">
                                        <c:choose>
                                            <c:when test="${not empty postura.beneficios}">
                                                ${postura.beneficios}
                                            </c:when>
                                            <c:otherwise>
                                                <span class="sin-datos">Sin beneficios</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </td>
                                <td class="acciones-postura">
                                    <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=editar&id=${postura.id}" 
                                       class="btn btn-secundario btn-pequeno">Editar</a>
                                    <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=eliminar&id=${postura.id}" 
                                       class="btn btn-peligro btn-pequeno"
                                       onclick="return confirm('¿Está seguro de que desea eliminar esta postura?')">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>

<style>
/* Estilos específicos para la gestión de posturas */
.header-gestion {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 2rem;
    flex-wrap: wrap;
    gap: 1rem;
}

.acciones-header {
    display: flex;
    align-items: center;
    gap: 1rem;
}

.form-busqueda {
    display: flex;
    align-items: center;
    gap: 0.5rem;
}

.input-busqueda {
    padding: 0.5rem;
    border: 1px solid var(--color3);
    border-radius: 4px;
    min-width: 200px;
}

.tabla-posturas {
    width: 100%;
    border-collapse: collapse;
    margin-top: 1rem;
}

.tabla-posturas th,
.tabla-posturas td {
    padding: 0.75rem;
    text-align: left;
    border-bottom: 1px solid #e2e8f0;
}

.tabla-posturas th {
    background-color: var(--color5);
    font-weight: 600;
    color: var(--color1);
}

.tabla-posturas tr:hover {
    background-color: #f8fafc;
}

.nombre-postura {
    font-weight: 500;
    color: var(--color2);
}

.celda-imagen {
    text-align: center;
}

.imagen-miniatura {
    width: 50px;
    height: 50px;
    object-fit: cover;
    border-radius: 4px;
    border: 1px solid #e2e8f0;
}

.sin-imagen, .sin-video, .sin-datos {
    color: #64748b;
    font-style: italic;
    font-size: 0.9rem;
}

.enlace-video {
    color: var(--color3);
    text-decoration: none;
}

.enlace-video:hover {
    text-decoration: underline;
}

.texto-truncado {
    max-width: 200px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

.acciones-postura {
    white-space: nowrap;
}

.btn-pequeno {
    padding: 0.4rem 0.8rem;
    font-size: 0.85rem;
}

.btn-peligro {
    background-color: #dc2626;
    color: white;
    border-color: #dc2626;
}

.btn-peligro:hover {
    background-color: #b91c1c;
    border-color: #b91c1c;
}

.mensaje-exito {
    background-color: #dcfce7;
    border: 1px solid #16a34a;
    color: #15803d;
    padding: 0.75rem;
    border-radius: 4px;
    margin-bottom: 1rem;
}

.mensaje-error {
    background-color: #fef2f2;
    border: 1px solid #dc2626;
    color: #dc2626;
    padding: 0.75rem;
    border-radius: 4px;
    margin-bottom: 1rem;
}

.mensaje-vacio {
    text-align: center;
    padding: 2rem;
    color: #64748b;
}

.info-resultados {
    margin-bottom: 1rem;
    color: #64748b;
    font-size: 0.9rem;
}
</style>
</body>
</html>
