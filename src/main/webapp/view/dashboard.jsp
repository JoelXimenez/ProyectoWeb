<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<title>Dashboard del Instructor</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body class="dashboard">
	<div class="barra">
		<img src="${pageContext.request.contextPath}/imagenes/logo.png"
			alt="Logo" class="logo" />
		<div class="marca">Equilibrio Vital</div>
		<button class="btn-cerrar-sesion"
			onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar
			sesión</button>
	</div>

	<div class="panel">
		<div class="menu-lateral">
			<button class="btn-menu activo">Dashboard</button>
			<button class="btn-menu"
				onclick="location.href='${pageContext.request.contextPath}/GestionarPacienteController?route=listarPacientes'">
				Gestionar pacientes</button>
			<button class="btn-menu" onclick="location.href='../crearSerie.html'">Crear
				serie terapéutica</button>
			<button class="btn-menu"
				onclick="location.href='${pageContext.request.contextPath}/AsignarSerieController?route=listar'">Asignar
				serie</button>
		</div>

		<div class="contenido-panel">
			<div class="tarjeta">
				<h2>Bienvenido, ${sessionScope.usuario.nombre}</h2>
				<p>
					<strong>Cédula:</strong> ${sessionScope.usuario.cedula}
				</p>
				<p>
					<strong>Correo:</strong> ${sessionScope.usuario.correo}
				</p>
				<p>
					<strong>Teléfono:</strong>
					<c:choose>
						<c:when test="${empty sessionScope.usuario.telefono}">
      No registrado
    </c:when>
						<c:otherwise>
      ${sessionScope.usuario.telefono}
    </c:otherwise>
					</c:choose>
				</p>

				<hr>
				<p>Desde este panel puedes gestionar pacientes, crear y asignar
					series terapéuticas.</p>
			</div>
		</div>
	</div>
</body>
</html>
