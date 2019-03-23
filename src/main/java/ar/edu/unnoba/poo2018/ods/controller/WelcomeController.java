package ar.edu.unnoba.poo2018.ods.controller;

import ar.edu.unnoba.poo2018.model.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/welcome")
public class WelcomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtengo sesion.
        HttpSession session = req.getSession();

        // Casteo al usuario que esta en sesion.
        Usuario user = (Usuario) session.getAttribute("usuario");

        if (user == null) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("logeado.jsp").forward(req, resp);
        }
    }
}
