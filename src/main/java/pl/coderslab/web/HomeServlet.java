package pl.coderslab.web;

import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Do not change servlet address !!!
 */
@WebServlet("")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("" + RecipeDao.numberOfRecipe(1));
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    }
}