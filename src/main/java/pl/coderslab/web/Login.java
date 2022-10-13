package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        String badLogin = request.getParameter("login");
        if ("false".equals(badLogin)) {
            Cookie cookie = new Cookie("badLogin", "1");
            response.addCookie(cookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (AdminDAO.checkLogin(email, password) == true) {
            request.getSession().setAttribute("email", "logged");
            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login?login=false");
        }
    }
}
