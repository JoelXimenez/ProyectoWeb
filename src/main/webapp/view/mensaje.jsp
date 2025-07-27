<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Resultado de Asignación</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body class="dashboard">

  <!-- Barra superior -->
  <div class="barra">
    <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo Casa Anahata" class="logo" />
    <div class="marca">Equilibrio Vital</div>
    <button class="btn-cerrar-sesion" onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar sesión</button>
  </div>

  <!-- Panel de contenido -->
  <div class="panel">
    <main class="contenido-panel">
      <div class="tarjeta">
        <c:choose>
          <c:when test="${messageType eq 'success'}">
            <h2 style="color: green;"> ${message}</h2>
          </c:when>
          <c:otherwise>
            <h2 style="color: darkred;"> ${message}</h2>
          </c:otherwise>
        </c:choose>

        <div style="margin-top: 2rem; text-align: center;">
          <a class="btn btn-primario" href="${pageContext.request.contextPath}/AsignarSerieController?route=listar">OK</a>
        </div>
      </div>
    </main>
  </div>
</body>
</html>
