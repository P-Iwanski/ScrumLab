package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String firstName = request.getParameter("name");
        String lastName = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("repassword");

        if (password.equals(password2)) {
            Admin admin = new Admin(firstName, lastName, email, password, 0,1);
            AdminDAO.create(admin);
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
