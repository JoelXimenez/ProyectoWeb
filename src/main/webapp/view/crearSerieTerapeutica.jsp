<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Serie Terapéutica</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body class="dashboard">
	<div class="barra">
		<img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo" class="logo" />
		<div class="marca">Equilibrio Vital</div>
		<button class="btn-cerrar-sesion" onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar sesión</button>
	</div>

	<div class="panel">
		<div class="menu-lateral">
			<button class="btn-menu" onclick="location.href='view/dashboard.jsp'">Dashboard</button>
			<button class="btn-menu"
				onclick="location.href='${pageContext.request.contextPath}/GestionarPacienteController?route=listarPacientes'">
				Gestionar pacientes</button>
			<button class="btn-menu activo">Crear serie terapéutica</button>
			<button class="btn-menu"
				onclick="location.href='${pageContext.request.contextPath}/AsignarSerieController?route=listar'">Asignar
				serie</button>
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
					</div>

					<div class="paso-creacion">
						<h3>Paso 2: Construir la Secuencia</h3>
						<p style="color: #555;">Añade posturas desde el catálogo a tu secuencia en el orden que desees.</p>
						<div class="constructor-secuencia">
							<div class="catalogo-posturas">
								<h4>Posturas disponibles</h4>
								
								<c:forEach var="postura" items="${posturas}">
									<div class="postura-disponible">
										<span>${postura.nombre}</span>
										<input type="checkbox" name="posturas" value="${postura.nombre}" />
									</div>
								</c:forEach>

							</div>
							<!-- Omitido "secuencia actual" porque parece estática -->
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
