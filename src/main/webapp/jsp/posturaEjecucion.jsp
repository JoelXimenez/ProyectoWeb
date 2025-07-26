<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Ejecutando Terapia</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
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
    <div class="contenido-panel">
        <div class="tarjeta">
            <div class="postura-container">
                <div class="progreso-serie">Postura ${numeroPosturaActual} de ${totalPosturas}</div>

                <c:if test="${not empty posturaActual}">
                    <h2 id="postura-titulo">${posturaActual.nombre}</h2>
                    <img id="postura-imagen" src="${pageContext.request.contextPath}/${posturaActual.fotoUrl}" alt="Postura" class="imagen-postura-grande">
                </c:if>

                <div id="timer-display" style="font-size: 4rem; font-weight: bold; margin: 1rem 0; color: #1ABC83;">00:10</div>

                <div class="controles-sesion">
                    <button id="start-pause-btn" class="btn btn-primario">Pausar</button>
                    <a id="detalles-btn" href="${pageContext.request.contextPath}/EjecutarSesionController?route=verInstrucciones" class="btn btn-secundario">Ver Instrucciones</a>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    let tiempoRestante = 10; // Duración en segundos (debería venir de la postura: ${posturaActual.duracionSegundos})

    const timerDisplay = document.getElementById('timer-display');
    const startPauseBtn = document.getElementById('start-pause-btn');
    let temporizador;
    let estaPausado = false;

    function actualizarDisplay() {
        let minutos = Math.floor(tiempoRestante / 60);
        let segundos = tiempoRestante % 60;
        minutos = minutos < 10 ? '0' + minutos : minutos;
        segundos = segundos < 10 ? '0' + segundos : segundos;
        timerDisplay.textContent = `${minutos}:${segundos}`;
    }

    function iniciarTemporizador() {
        estaPausado = false;
        startPauseBtn.textContent = 'Pausar';
        temporizador = setInterval(() => {
            if (tiempoRestante > 0) {
                tiempoRestante--;
                actualizarDisplay();
            } else {
                clearInterval(temporizador);
                window.location.href = '${pageContext.request.contextPath}/EjecutarSesionController?route=siguientePostura';
            }
        }, 1000);
    }

    function pausarTemporizador() {
        estaPausado = true;
        startPauseBtn.textContent = 'Reanudar';
        clearInterval(temporizador);
    }

    startPauseBtn.addEventListener('click', () => {
        if (estaPausado) {
            iniciarTemporizador();
        } else {
            pausarTemporizador();
        }
    });

    document.addEventListener('DOMContentLoaded', () => {
        actualizarDisplay();
        iniciarTemporizador();
    });
</script>
</body>
</html>