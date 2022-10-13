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
//        response.setContentType("text/html;charset=utf-8");
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                if ("User".equals(cookie.getName())) {
//                    const clas =
//                    response.getWriter().append("Nieprawidłowe dane");
//                }
//            }
//        }
        getServletContext().getRequestDispatcher("/login.html").forward(request, response);
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
//            Cookie cookie = new Cookie("Wrong", "zlehaslo");
//            cookie.setMaxAge(60 * 60 * 24);
//            cookie.setPath("/");
//            response.addCookie(cookie);
            getServletContext().getRequestDispatcher("/login.html").forward(request, response);
        }


    }
}
