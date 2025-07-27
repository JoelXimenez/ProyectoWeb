<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Detalles de Postura</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body class="dashboard">
<div class="barra">
    <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo" class="logo">
    <h1 class="marca">Equilibrio Vital</h1>
</div>
<main class="contenido-panel">
    <div class="tarjeta">
        <h2>Instrucciones de la postura</h2>
        <c:if test="${not empty posturaDetallada}">
            <p><strong>Nombre:</strong> <span>${posturaDetallada.nombre}</span></p>
            <p><strong>Beneficios:</strong> <span>${posturaDetallada.beneficios}</span></p>
            <p><strong>Instrucciones:</strong> <span>${posturaDetallada.instrucciones}</span></p>


            <c:if test="${not empty posturaDetallada.videoUrl}">
                <div class="video-container">
                    <iframe src="${posturaDetallada.videoUrl}" title="Reproductor de video" frameborder="0" allowfullscreen></iframe>
                </div>
            </c:if>
        </c:if>
        <c:if test="${empty posturaDetallada}">
            <p>No se encontraron los detalles de la postura.</p>
        </c:if>
        <div style="margin-top: 2rem;">
            <a id="regresar-btn" href="${pageContext.request.contextPath}/EjecutarSesionController?route=volverAEjecucion" class="btn btn-primario">Regresar a la Sesión</a>
        </div>
    </div>
</main>
</body>
</html>