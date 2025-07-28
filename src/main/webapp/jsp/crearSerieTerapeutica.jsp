<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Serie Terapéutica</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body class="dashboard">
	<div class="barra">
		<img src="../assets/img/logo.png" alt="Logo" class="logo" />
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
				<h2>Crear Nueva Serie Terapéutica</h2>

				<form class="formulario" action="${pageContext.request.contextPath}/CrearSerieTerapeuticaController" method="POST">
    				<input type="hidden" name="route" value="guardar" />


					<div class="paso-creacion">
						<h3>Paso 1: Datos Generales</h3>
						<label for="nombreSerie">Nombre de la serie</label> 
						<input type="text" id="nombreSerie" name="nombreSerie" placeholder="Ej. Serie matutina para dolor de espalda" required />
						<label for="tipoTerapia" style="margin-top: 1rem;">Tipo de terapia</label> 
						<select id="tipoTerapia" name="tipoTerapia" required>
							<option value="">Selecciona una terapia para ver las posturas...</option>
							<option value="ansiedad">Ansiedad</option>
              				<option value="artritis">Artritis</option>
              				<option value="dolorEspalda">Dolor de espalda</option>
              				<option value="dolorCabeza">Dolor de cabeza</option>
              				<option value="insomnio">Insomnio</option>
              				<option value="malaPostura">Mala Postura</option>
						</select>
					</div>

					<div class="paso-creacion">
						<h3>Paso 2: Construir la Secuencia</h3>
						<p style="color: #555;">Añade posturas desde el catálogo a tu secuencia en el orden que desees.</p>
						<div class="constructor-secuencia">
							<div class="catalogo-posturas">
								<h4>Posturas para ${tipoTerapia}</h4>
								
								<c:forEach var="postura" items="${posturas}">
									<div class="postura-disponible">
										<span>${postura.nombre}</span>
										<input type="checkbox" name="posturas" value="${postura.nombre}" />
									</div>
								</c:forEach>

							</div>
							<div class="secuencia-actual">
								<h4>Secuencia de la Serie (en orden)</h4>
								<div class="postura-en-serie">
									<span>1. Postura del Gato-Vaca</span> <input type="number" name="duracion[]" placeholder="min." required />
								</div>
							</div>
						</div>
					</div>

					<div class="paso-creacion">
						<h3>Paso 3: Detalles Finales</h3>
						<label for="numSesiones">Número de sesiones recomendadas</label> 
						<input type="number" id="numSesiones" name="numSesiones" min="1" max="100" required style="max-width: 200px;" />
					</div>

					<button type="submit" class="btn btn-primario" style="font-size: 1.1rem;">Guardar Serie Terapéutica</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>