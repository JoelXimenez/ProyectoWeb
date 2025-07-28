<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>${tituloFormulario} - Equilibrio Vital</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css">
</head>
<body class="dashboard">
<div class="barra">
    <img src="${pageContext.request.contextPath}/imagenes/logo.png" alt="Logo" class="logo" />
    <div class="marca">Equilibrio Vital</div>
    <button class="btn-cerrar-sesion" onclick="location.href='${pageContext.request.contextPath}/LoginController?route=logOut'">Cerrar sesión</button>
</div>
<div class="panel">
    <div class="contenido-panel">
        <div class="tarjeta">
            <!-- Breadcrumb -->
            <div class="breadcrumb">
                <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=listar">Gestión de Posturas</a>
                <span> / </span>
                <span>${tituloFormulario}</span>
            </div>

            <h2>${tituloFormulario}</h2>

            <!-- Mostrar errores si los hay -->
            <c:if test="${not empty error}">
                <div class="mensaje-error">
                    <strong>Error:</strong> ${error}
                </div>
            </c:if>

            <form method="POST" action="${pageContext.request.contextPath}/GestionarPosturasController" class="formulario-postura" novalidate>
                <input type="hidden" name="route" value="${accion}">
                <c:if test="${accion == 'actualizar'}">
                    <input type="hidden" name="id" value="${postura.id}">
                </c:if>

                <div class="fila-doble">
                    <div class="form-group">
                        <label for="nombre">Nombre de la Postura *</label>
                        <input type="text" 
                               id="nombre" 
                               name="nombre" 
                               value="${postura.nombre}" 
                               required 
                               maxlength="100"
                               placeholder="Ej: Postura del guerrero">
                        <div class="error-campo" id="error-nombre"></div>
                    </div>
                    <div class="form-group">
                        <label for="fotoUrl">URL de la Imagen</label>
                        <input type="url" 
                               id="fotoUrl" 
                               name="fotoUrl" 
                               value="${postura.fotoUrl}" 
                               placeholder="Ej: imagenes/posturas/guerrero.jpg">
                        <div class="error-campo" id="error-fotoUrl"></div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="videoUrl">URL del Video</label>
                    <input type="url" 
                           id="videoUrl" 
                           name="videoUrl" 
                           value="${postura.videoUrl}" 
                           placeholder="Ej: https://youtube.com/watch?v=...">
                    <div class="error-campo" id="error-videoUrl"></div>
                </div>

                <div class="form-group">
                    <label for="instrucciones">Instrucciones *</label>
                    <textarea id="instrucciones" 
                              name="instrucciones" 
                              required 
                              rows="6" 
                              maxlength="1000"
                              placeholder="Describe paso a paso cómo realizar esta postura...">${postura.instrucciones}</textarea>
                    <div class="contador-caracteres">
                        <span id="contador-instrucciones">0</span>/1000 caracteres
                    </div>
                    <div class="error-campo" id="error-instrucciones"></div>
                </div>

                <div class="form-group">
                    <label for="beneficios">Beneficios</label>
                    <textarea id="beneficios" 
                              name="beneficios" 
                              rows="4" 
                              maxlength="500"
                              placeholder="Describe los beneficios de esta postura...">${postura.beneficios}</textarea>
                    <div class="contador-caracteres">
                        <span id="contador-beneficios">0</span>/500 caracteres
                    </div>
                    <div class="error-campo" id="error-beneficios"></div>
                </div>

                <!-- Vista previa de imagen -->
                <div class="form-group" id="preview-container" style="display: none;">
                    <label>Vista previa de la imagen:</label>
                    <div class="imagen-preview">
                        <img id="imagen-preview" src="" alt="Vista previa" style="max-width: 200px; max-height: 200px; border-radius: 8px; border: 1px solid #e2e8f0;">
                    </div>
                </div>
<div class="form-group">
    <label for="activa">
        <input type="checkbox" id="activa" name="activa" value="true"
               <c:if test="${postura != null && postura.activa}">checked</c:if>> 
        Postura activa
    </label>
</div>

                <div class="acciones-formulario">
                
                    <a href="${pageContext.request.contextPath}/GestionarPosturasController?route=listar" 
                       class="btn btn-secundario">Cancelar</a>
                    <button type="submit" class="btn btn-primario" id="btn-guardar">
                        <c:choose>
                            <c:when test="${accion == 'actualizar'}">Actualizar Postura</c:when>
                            <c:otherwise>Guardar Postura</c:otherwise>
                        </c:choose>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<style>
/* Estilos específicos para el formulario de postura */
.breadcrumb {
    margin-bottom: 1rem;
    font-size: 0.9rem;
    color: #64748b;
}

.breadcrumb a {
    color: var(--color3);
    text-decoration: none;
}

.breadcrumb a:hover {
    text-decoration: underline;
}

.formulario-postura {
    max-width: 800px;
}

.formulario-postura .form-group {
    margin-bottom: 1.5rem;
}

.formulario-postura label {
    display: block;
    margin-bottom: 0.5rem;
    font-weight: 600;
    color: var(--color1);
}

.formulario-postura input,
.formulario-postura textarea {
    width: 100%;
    padding: 0.75rem;
    border: 1px solid #cbd5e1;
    border-radius: 6px;
    font-size: 0.95rem;
    transition: border-color 0.2s, box-shadow 0.2s;
}

.formulario-postura input:focus,
.formulario-postura textarea:focus {
    outline: none;
    border-color: var(--color3);
    box-shadow: 0 0 0 3px rgba(101, 184, 166, 0.1);
}

.formulario-postura textarea {
    resize: vertical;
    min-height: 100px;
}

.contador-caracteres {
    margin-top: 0.25rem;
    font-size: 0.8rem;
    color: #64748b;
    text-align: right;
}

.error-campo {
    margin-top: 0.25rem;
    font-size: 0.85rem;
    color: #dc2626;
    display: none;
}

.campo-invalido {
    border-color: #dc2626;
}

.campo-invalido:focus {
    box-shadow: 0 0 0 3px rgba(220, 38, 38, 0.1);
}

.acciones-formulario {
    display: flex;
    gap: 1rem;
    margin-top: 2rem;
    justify-content: flex-end;
}

.imagen-preview {
    margin-top: 0.5rem;
}

.mensaje-error {
    background-color: #fef2f2;
    border: 1px solid #dc2626;
    color: #dc2626;
    padding: 0.75rem;
    border-radius: 4px;
    margin-bottom: 1rem;
}

/* Responsive */
@media (max-width: 768px) {
    .fila-doble {
        flex-direction: column;
    }
    
    .acciones-formulario {
        flex-direction: column;
    }
}
</style>

<script>
document.addEventListener('DOMContentLoaded', function() {
    // Elementos del formulario
    const formulario = document.querySelector('.formulario-postura');
    const nombreInput = document.getElementById('nombre');
    const fotoUrlInput = document.getElementById('fotoUrl');
    const videoUrlInput = document.getElementById('videoUrl');
    const instruccionesTextarea = document.getElementById('instrucciones');
    const beneficiosTextarea = document.getElementById('beneficios');
    const imagenPreview = document.getElementById('imagen-preview');
    const previewContainer = document.getElementById('preview-container');
    
    // Contadores de caracteres
    const contadorInstrucciones = document.getElementById('contador-instrucciones');
    const contadorBeneficios = document.getElementById('contador-beneficios');
    
    // Inicializar contadores
    actualizarContador(instruccionesTextarea, contadorInstrucciones);
    actualizarContador(beneficiosTextarea, contadorBeneficios);
    
    // Event listeners para contadores
    instruccionesTextarea.addEventListener('input', function() {
        actualizarContador(this, contadorInstrucciones);
    });
    
    beneficiosTextarea.addEventListener('input', function() {
        actualizarContador(this, contadorBeneficios);
    });
    
    // Vista previa de imagen
    fotoUrlInput.addEventListener('input', function() {
        mostrarVistaPrevia(this.value);
    });
    
    // Mostrar vista previa inicial si hay URL
    if (fotoUrlInput.value) {
        mostrarVistaPrevia(fotoUrlInput.value);
    }
    
    // Validación del formulario
    formulario.addEventListener('submit', function(e) {
        if (!validarFormulario()) {
            e.preventDefault();
        }
    });
    
    function actualizarContador(textarea, contador) {
        const longitud = textarea.value.length;
        contador.textContent = longitud;
        
        // Cambiar color si se acerca al límite
        const maxLength = textarea.getAttribute('maxlength');
        if (longitud > maxLength * 0.9) {
            contador.style.color = '#dc2626';
        } else if (longitud > maxLength * 0.7) {
            contador.style.color = '#f59e0b';
        } else {
            contador.style.color = '#64748b';
        }
    }
    
    function mostrarVistaPrevia(url) {
        if (url && url.trim() !== '') {
            imagenPreview.src = url.startsWith('http') ? url : '${pageContext.request.contextPath}/' + url;
            imagenPreview.onload = function() {
                previewContainer.style.display = 'block';
            };
            imagenPreview.onerror = function() {
                previewContainer.style.display = 'none';
            };
        } else {
            previewContainer.style.display = 'none';
        }
    }
    
    function validarFormulario() {
        let esValido = true;
        
        // Limpiar errores previos
        document.querySelectorAll('.error-campo').forEach(error => {
            error.style.display = 'none';
        });
        document.querySelectorAll('.campo-invalido').forEach(campo => {
            campo.classList.remove('campo-invalido');
        });
        
        // Validar nombre
        if (!nombreInput.value.trim()) {
            mostrarError('nombre', 'El nombre de la postura es obligatorio');
            esValido = false;
        } else if (nombreInput.value.trim().length < 3) {
            mostrarError('nombre', 'El nombre debe tener al menos 3 caracteres');
            esValido = false;
        }
        
        // Validar instrucciones
        if (!instruccionesTextarea.value.trim()) {
            mostrarError('instrucciones', 'Las instrucciones son obligatorias');
            esValido = false;
        } else if (instruccionesTextarea.value.trim().length < 10) {
            mostrarError('instrucciones', 'Las instrucciones deben tener al menos 10 caracteres');
            esValido = false;
        }
        
        // Validar URL de foto (si se proporciona)
        if (fotoUrlInput.value.trim() && !esUrlValida(fotoUrlInput.value.trim())) {
            mostrarError('fotoUrl', 'La URL de la imagen no es válida');
            esValido = false;
        }
        
        // Validar URL de video (si se proporciona)
        if (videoUrlInput.value.trim() && !esUrlValida(videoUrlInput.value.trim())) {
            mostrarError('videoUrl', 'La URL del video no es válida');
            esValido = false;
        }
        
        return esValido;
    }
    
    function mostrarError(campo, mensaje) {
        const input = document.getElementById(campo);
        const error = document.getElementById('error-' + campo);
        
        input.classList.add('campo-invalido');
        error.textContent = mensaje;
        error.style.display = 'block';
    }
    
    function esUrlValida(url) {
        // Permitir URLs relativas (que no empiecen con http)
        if (!url.startsWith('http')) {
            return true;
        }
        
        try {
            new URL(url);
            return true;
        } catch {
            return false;
        }
    }
});
</script>
</body>
</html>