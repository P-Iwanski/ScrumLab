package pl.coderslab.web;

import pl.coderslab.dao.DayNameDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/app/recipe/plan/add")
public class AddRecipeToPlan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlanDao planDao = new PlanDao();
        request.setAttribute("plans", planDao.findAll());
        RecipeDao recipeDao = new RecipeDao();
        request.setAttribute("recipes", recipeDao.findAll());
        DayNameDao dayNameDao = new DayNameDao();
        request.setAttribute("days", dayNameDao.findAll());

        getServletContext().getRequestDispatcher("/addRecipeToPlan.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}