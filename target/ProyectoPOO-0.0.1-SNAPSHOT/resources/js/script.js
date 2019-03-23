function validarLogin(form) {
    //var email = document.getElementById("txtMail");
    //var password = document.getElementById("txtPass");
    var email = form.txtMail.value;
    var password = form.txtPass.value;

    // Validacion de eMail.
    if (email === "") {
        window.alert("¡Debe ingresar un eMail válido!");
        return false;
    }
    
    // Validacion de Password.
    if (password === "") {
        window.alert("¡Debe ingresar una Contraseña válida!");
        return false;
    }
    
    return true;
}

// Util:
// https://www.formget.com/javascript-login-form/
// https://www.w3schools.com/howto/howto_css_login_form.asp
// http://carlospesquera.com/aplicaciones-web-java-y-directorio-web-inf/
// https://www.youtube.com/watch?v=PiEemGuTogU

// https://stackoverflow.com/questions/24066367/how-to-call-servlet-on-jsp-page-load
// https://tomcat.apache.org/tomcat-5.5-doc/servletapi/javax/servlet/ServletRequest.html#setAttribute(java.lang.String,%20java.lang.Object)
// https://www.arquitecturajava.com/usando-java-session-en-aplicaciones-web/
// https://www.mkyong.com/spring-mvc/spring-mvc-how-to-include-js-or-css-files-in-a-jsp-page/
