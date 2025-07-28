<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entities.Postura" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Gestión de Posturas</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" />
</head>
<body class="dashboard">
  <div class="barra">
    <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo" class="logo" />
    <div class="marca">Equilibrio Vital - Panel de Administrador</div>
    		<button class="btn-cerrar-sesion"
			onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar
			sesión</button>
  </div>

  <div class="panel">
    <div class="menu-lateral">
        <button class="btn-menu activo">Gestionar Posturas</button>
    </div>

    <div class="contenido-panel">
      <div class="tarjeta">
        <div class="header-gestion">
          <h2>Catálogo de Posturas</h2>
          <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=nuevo" class="btn btn-primario">Registrar Nueva Postura</a>
        </div>

        <form action="${pageContext.request.contextPath}/GestionarPosturasController" method="get" style="margin-bottom: 1rem;">
          <input type="hidden" name="route" value="buscar" />
          <input type="text" name="termino" placeholder="Buscar por nombre de postura..." style="width:100%; max-width:400px;">
        </form>

        <c:if test="${not empty error}">
          <div class="mensaje error">${error}</div>
        </c:if>
        <c:if test="${not empty success}">
          <div class="mensaje success">${success}</div>
        </c:if>

        <table class="tabla-posturas">
          <thead>
            <tr>
              <th>Nombre de la Postura</th>
              <th>Estado</th>
              <th>Acciones</th>
            </tr>
          </thead>
          <tbody>
            <%
              List<Postura> posturas = (List<Postura>) request.getAttribute("posturas");
              if (posturas != null && !posturas.isEmpty()) {
                for (Postura p : posturas) {
            %>
              <tr>
                <td><%= p.getNombre() %></td>
                <td><%= p.isActiva() ? "Activa" : "Inactiva" %></td>
                <td class="acciones-postura">
                  <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=editar&id=<%= p.getId() %>" class="btn btn-secundario">Editar</a>
                  <form action="${pageContext.request.contextPath}/GestionarPosturasController" method="post" style="display:inline;">
                    <input type="hidden" name="route" value="eliminar" />
                    <input type="hidden" name="id" value="<%= p.getId() %>" />
                    <button type="submit" class="btn btn-secundario" style="color: #c0392b;" onclick="return confirm('¿Estás seguro de eliminar esta postura?')">Eliminar</button>
                  </form>
                </td>
              </tr>
            <%
                }
              } else {
            %>
              <tr>
                <td colspan="3">No se encontraron posturas registradas.</td>
              </tr>
            <%
              }
            %>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>
