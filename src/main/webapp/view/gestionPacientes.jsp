<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
		<!DOCTYPE html>
		<html lang="es">

		<head>
			<meta charset="UTF-8" />
			<title>Gestión de Pacientes</title>
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
					<button class="btn-menu" onclick="location.href='view/dashboard.jsp'">Dashboard</button>
					<button class="btn-menu activo">Gestionar pacientes</button>
					<button class="btn-menu" onclick="location.href='../crearSerie.html'">Crear
						serie terapéutica</button>
					<button class="btn-menu"
						onclick="location.href='${pageContext.request.contextPath}/AsignarSerieController?route=listar'">Asignar
						serie</button>
				</div>
				<div class="contenido-panel">
					<div class="tarjeta">
						<div class="header-gestion">
							<h2>Gestión de Pacientes</h2>
							<a href="${pageContext.request.contextPath}/GestionarPacienteController?route=registrarPacienteFormulario"
								class="btn btn-primario">Registrar Nuevo Paciente</a>
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
										<td>${paciente.id}</td>
										<td>${paciente.nombre}</td>
										<td>${paciente.correo}</td>
										<td>${paciente.telefono}</td>
										<td class="acciones-paciente">
											<!-- Botón para editar -->
											<a href="${pageContext.request.contextPath}/GestionarPacienteController?route=editarPaciente&id=${paciente.id}"
												class="btn btn-secundario">Editar</a>

											<!-- Botón para ver historial -->
											<a href="${pageContext.request.contextPath}/GestionarPacienteController?route=verHistorial&id=${paciente.id}"
												class="btn btn-secundario">Historial</a>
										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- Modal para mensajes informativos y de error -->
			<div class="modal fade" id="infoModal" tabindex="-1" aria-labelledby="infoModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered">
					<div class="modal-content border-0">
						<div class="modal-body bg-info text-white text-center rounded">
							<i class="fas fa-info-circle fa-2x me-2"></i>
							<!-- Mostrar el mensaje en HTML -->
							<span class="fs-5">
								${message}
							</span>

						</div>
					</div>
				</div>
			</div>

			<script>
				window.onload = function () {
					const message = "${message}";
					if (message !== "") {
						const infoModalElement = document.getElementById("infoModal");
						if (infoModalElement) {
							const modalInstance = new bootstrap.Modal(infoModalElement);
							modalInstance.show();

							// Cerrar automáticamente después de 2 segundos (2000 milisegundos)
							setTimeout(() => {
								modalInstance.hide();
							}, 2000);
						}
					}
				};
			</script>



		</body>

		</html>