<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Equilibrio Vital - Registro de Instructor</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body class="fondo sin-scroll">

	<div class="contenedor-izquierdo">
		<h1 class="titulo-logo">Equilibrio Vital</h1>
		<div class="contenedor-formulario">
			<form class="formulario"
				action="${pageContext.request.contextPath}/RegistroInstructorController?route=guardarRegistro"
				method="post" enctype="multipart/form-data">
				<h2>Registro para instructores</h2>

				<input type="text" name="id" placeholder="Cédula" required>
				<input type="text" name="nombre" placeholder="Nombre completo"
					required> <input type="email" name="correo"
					placeholder="Correo electrónico" required> <input
					type="password" name="password" placeholder="Contraseña" required>
				<input type="text" name="telefono" placeholder="Teléfono"> <label
					for="documento" class="labeld" style="color: white">Documento
					de certificación (PDF, JPG)</label> <input type="file" name="documento"
					id="documento" accept=".pdf,.jpg,.jpeg,.png" required>

				<button type="submit" class="btn btn-primario">Registrarme
					como Instructor</button>

				<p class="enlace-login">
					¿Ya tienes cuenta? <a
						href="${pageContext.request.contextPath}/view/inicioSesion.jsp">Inicia
						sesión</a>

				</p>
			</form>
		</div>
	</div>
</body>
</html>
