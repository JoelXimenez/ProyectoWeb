<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Serie Guardada</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .mensaje-confirmacion {
            background-color: #e6f7ec;
            border: 2px solid #27ae60;
            padding: 30px 50px;
            border-radius: 10px;
            text-align: center;
            color: #2e7d32;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        .mensaje-confirmacion h2 {
            margin: 0 0 10px 0;
        }

        .mensaje-confirmacion a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #2e7d32;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="mensaje-confirmacion">
        <h2>✅ Serie guardada con éxito</h2>
        <p>La serie terapéutica ha sido registrada correctamente.</p>
        <a href="CrearSerieTerapeutica?route=crearSerie">Crear otra serie</a>
    </div>
</body>
</html>
