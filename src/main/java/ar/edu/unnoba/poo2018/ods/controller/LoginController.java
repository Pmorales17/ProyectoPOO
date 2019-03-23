package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Seteo parametros.
        String nombre = req.getParameter("txtMail");
        String email = req.getParameter("txtMail");
        String password = req.getParameter("txtPass");
        
                
        // Validacion eMail y Password.
        if (("poo2018@unnoba.edu.ar".equals(email)) && ("unnoba2018!".equals(password))) {
            
            // Instancio Objeto Usuario.
            Usuario user = new Usuario(nombre, email, password, false);
            
            // Seteo atributos de Sesion.
            HttpSession session = req.getSession();
            session.setAttribute("usuario", user);
            
            // Llamo a pagina de principal.
            RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
            rd.forward(req, resp);
        } else {
            // Error.
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            
            // Llamo a pagina de error.
            //resp.sendRedirect("error.jsp");
            
            // Otra forma.
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
// Mail: "​poo2018@unnoba.edu.ar​"
// Pass: "unnoba2018!" 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Si alguien entra por doGet, fuerzo a ejecutar el doPost.
        doPost(req, resp);
    }  
}
