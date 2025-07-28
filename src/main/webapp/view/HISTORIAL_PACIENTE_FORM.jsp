<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

			<!DOCTYPE html>
			<html lang="es">

			<head>
				<meta charset="UTF-8" />
				<title>Historial del Paciente</title>
				<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
			</head>

			<body class="dashboard">
				<div class="barra">
					<img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo" class="logo" />
					<div class="marca">Equilibrio Vital</div>
					<button class="btn-cerrar-sesion"
						onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar
						sesión</button>
				</div>

				<div class="panel">
					<div class="menu-lateral">
						<button class="btn-menu" onclick="location.href='dashboard.jsp'">Dashboard</button>
						<button class="btn-menu"
							onclick="location.href='${pageContext.request.contextPath}/GestionarPacienteController?route=listar'">Gestionar
							pacientes</button>
						<button class="btn-menu" onclick="location.href='../crearSerie.html'">Crear serie
							terapéutica</button>
						<button class="btn-menu"
							onclick="location.href='${pageContext.request.contextPath}/AsignarSerieController?route=listar'">Asignar
							serie</button>
					</div>

					<div class="contenido-panel">
						<div class="tarjeta">
							<h2>Historial del Paciente</h2>

							<!-- Información del paciente -->
							<div class="info-paciente">
								<p><strong>Cédula:</strong> ${paciente.id}</p>
								<p><strong>Nombre:</strong> ${paciente.nombre}</p>
								<p><strong>Correo:</strong> ${paciente.correo}</p>
								<p><strong>Teléfono:</strong> ${paciente.telefono}</p>

							</div>

							<!-- Tabla de sesiones -->
							<h3>Sesiones Realizadas</h3>
							<table class="tabla-pacientes">
								<thead>
									<tr>
										<th>Fecha</th>
										<th>Serie</th>
										<th>Dolor Inicial</th>
										<th>Dolor Final</th>
										<th>Comentario</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="sesion" items="${paciente.historialSesiones}">
										<tr>
											<td>
												<fmt:formatDate value="${sesion.fecha}" pattern="yyyy-MM-dd HH:mm" />
											</td>
											<td>
												<c:choose>
													<c:when test="${not empty sesion.serie}">
														${sesion.serie.nombre}
													</c:when>
													<c:otherwise>
														No asignada
													</c:otherwise>
												</c:choose>
											</td>
											<td>
												<c:choose>
													<c:when test="${sesion.dolorInicial == '0'}">Sin dolor/molestia
													</c:when>
													<c:when test="${sesion.dolorInicial == '1'}">Leve</c:when>
													<c:when test="${sesion.dolorInicial == '2'}">Moderado</c:when>
													<c:when test="${sesion.dolorInicial == '3'}">Intenso</c:when>
													<c:when test="${sesion.dolorInicial == '4'}">Máximo dolor/molestia
													</c:when>
													<c:otherwise>Desconocido</c:otherwise>
												</c:choose>
											</td>

											<td>
												<c:choose>
													<c:when test="${sesion.dolorFinal == '0'}">Sin dolor/molestia
													</c:when>
													<c:when test="${sesion.dolorFinal == '1'}">Leve</c:when>
													<c:when test="${sesion.dolorFinal == '2'}">Moderado</c:when>
													<c:when test="${sesion.dolorFinal == '3'}">Intenso</c:when>
													<c:when test="${sesion.dolorFinal == '4'}">Máximo dolor/molestia
													</c:when>
													<c:otherwise>Desconocido</c:otherwise>
												</c:choose>
											</td>

											<td>${sesion.comentario}</td>
										</tr>
									</c:forEach>

									<c:if test="${empty paciente.historialSesiones}">
										<tr>
											<td colspan="5" style="text-align:center;">Este paciente aún no tiene
												sesiones registradas.</td>
										</tr>
									</c:if>
								</tbody>

							</table>

							<br>
						<a
							href="${pageContext.request.contextPath}/GestionarPacienteController?route=listarPacientes"
							class="btn btn-secundario">Volver</a>
						</div>
					</div>
				</div>
			</body>

			</html>