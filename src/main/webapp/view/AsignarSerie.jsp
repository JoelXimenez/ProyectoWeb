<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asignar Serie Terapéutica</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css" />

</head>
<body class="dashboard">

	<!-- Barra superior -->
	<div class="barra">
		<img src="${pageContext.request.contextPath}/imagenes/logo.png"
			alt="Logo Casa Anahata" class="logo" />
		<div class="marca">Equilibrio Vital</div>
		<button class="btn-cerrar-sesion"
			onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar
			sesión</button>
	</div>

	<!-- Panel lateral y contenido -->
	<div class="panel">
		<div class="menu-lateral">
			<button class="btn-menu" onclick="location.href='view/dashboard.jsp'">Dashboard</button>
			<button class="btn-menu"
				onclick="location.href='${pageContext.request.contextPath}/GestionarPacienteController?route=listarPacientes'">Gestionar
				pacientes</button>
			<button class="btn-menu" onclick="location.href='${pageContext.request.contextPath}/CrearSerieTerapeuticaController?route=crearSerie'">Crear
				serie terapéutica</button>
			<button class="btn-menu activo">Asignar serie</button>
		</div>

		<main class="contenido-panel">
			<div class="tarjeta">
				<h2>Asignar Serie a Paciente</h2>

				<!-- ✅ Mensaje de éxito -->
				<c:if test="${not empty mensaje}">
					<div class="mensaje-exito">${mensaje}</div>
				</c:if>

				<!-- Formulario de asignación -->
				<form class="formulario" method="POST"
    action="${pageContext.request.contextPath}/AsignarSerieController?route=asignar">


					<!-- Paso 1: Selección de paciente -->
					<div class="paso-asignacion">
						<label for="pacienteId">Paso 1: Seleccionar Paciente</label> <select
							id="pacienteId" name="pacienteId" required>
							<option value="">Seleccione un paciente...</option>
							<c:forEach var="p" items="${pacientes}">
								<option value="${p.id}">${p.nombre}</option>
							</c:forEach>
						</select>
					</div>

					<!-- Paso 2: Selección de serie -->
					<div class="paso-asignacion">
						<label for="serieId">Paso 2: Seleccionar Serie Terapéutica</label>
						<select id="serieId" name="serieId" required>
							<option value="">Seleccione una serie...</option>
							<c:forEach var="s" items="${series}">
								<option value="${s.id}">${s.nombre}</option>
							</c:forEach>
						</select>
					</div>

					<!-- Botón enviar -->
					<button class="btn btn-primario" type="submit"
						style="margin-top: 2rem;">Asignar Serie</button>
				</form>
			</div>
		</main>
	</div>
</body>
</html>
