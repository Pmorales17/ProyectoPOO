<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
        <title>ODS - Login</title>
        <!-- Incluir archivo CSS aqui -->
        <link rel="stylesheet" href="resources/css/style.css" type="text/css">
        <!-- Incluir archivo JS aqui -->
        <script lang="Javascript" type="text/javascript" src="resources/js/script.js"></script>
        <!-- Incluir Servlet aqui -->
    </head>
    <body>
        <div>
            <h1>Ingreso de Datos:</h1>
            <form method="post" action="login" name="loginForm">
                Email: <input type="text" name="txtMail" placeholder="Correo Electronico"> <br/>
                Contraseña: <input type="password" name="txtPass" placeholder="Password"> <br/>
                <!--<p><input type="submit" value="Log in"></p>-->
                <p><input onclick=validarLogin(loginForm) type="submit" value="Ingresar"></p>
            </form>
        </div>
    </body>
</html>
