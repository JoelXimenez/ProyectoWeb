<%@ page contentType="text/html; charset=UTF-8" language="java" %>
	<!DOCTYPE html>
	<html lang="es">

	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Registrar Paciente</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
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
				<button class="btn-menu activo">Gestionar pacientes</button>
				<button class="btn-menu" onclick="location.href='../crearSerie.html'">Crear
					serie terapéutica</button>
				<button class="btn-menu"
					onclick="location.href='${pageContext.request.contextPath}/AsignarSerieController?route=listar'">Asignar
					serie</button>
			</div>

			<div class="contenido-panel">
				<div class="tarjeta">
					<h2>Editar Paciente</h2>

					<form class="formulario" method="POST"
						action="${pageContext.request.contextPath}/GestionarPacienteController?route=guardarPacienteExistente">

						<div class="fila-doble">
							<input type="text" name="nombre" value="${paciente.nombre}" placeholder="Nombre completo"
								required /> <input type="text" name="cedula" value="${paciente.id}"
								placeholder="Cédula del paciente" required />
						</div>

						<div class="fila-doble">
							<input type="email" name="correo" value="${paciente.correo}"
								placeholder="Correo electrónico" required /> <input type="text" name="telefono"
								value="${paciente.telefono}" placeholder="Teléfono" class="campo-formulario" required />

						</div>
						<input type="password" name="contrasena" value="${paciente.contraseña}" placeholder="Contraseña"
							required />

						<div style="display: flex; flex-direction: column; width: 100%;">
							<label for="genero">Género</label>
							<select name="genero" id="genero" required style="padding: 0.5rem;">
								<option value="" disabled ${empty paciente.genero ? 'selected' : '' }>Selecciona tu
									género</option>
								<option value="m" ${'m'.equals(paciente.genero) ? 'selected' : '' }>Masculino</option>
								<option value="f" ${'f'.equals(paciente.genero) ? 'selected' : '' }>Femenino</option>
								<option value="o" ${'o'.equals(paciente.genero) ? 'selected' : '' }>Otro</option>
							</select>

						</div>

						<label for="fechaNacimiento" style="margin-top: 1rem; color: #555;">Fecha
							de nacimiento</label> <input type="date" name="fechaNacimiento" value="${fechaNacimientoFormateada}" required />


						<div class="controles-sesion" style="justify-content: flex-start;">
							<button type="submit" class="btn btn-primario">Editar Paciente</button>
							<a href="${pageContext.request.contextPath}/GestionarPacienteController?route=listarPacientes"
								class="btn btn-secundario">Cancelar</a>
						</div>
					</form>

				</div>
			</div>
		</div>
	</body>

	</html>