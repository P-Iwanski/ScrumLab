package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.RecipePlanDays;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Dashboard", value = "/app/dashboard")
public class Dashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("email");
        int id = AdminDAO.checkId(email);
        List<RecipePlanDays> arrayOfLastPlan = PlanDao.lastAddedPlan(id);
        System.out.println(arrayOfLastPlan);
        String name = AdminDAO.getName(email);
        int numberOfPlans = PlanDao.numberOfPlans(id);
        int numberOfRecipes = RecipeDao.numberOfRecipe(id);
        String nameOfLastPlan = PlanDao.nameLastAddedPlan(id);

        request.setAttribute("arrayOfLastPlan", arrayOfLastPlan);
        request.setAttribute("name", name);
        request.setAttribute("numberOfPlans", numberOfPlans);
        request.setAttribute("numberOfRecipes", numberOfRecipes);
        request.setAttribute("nameOfLastPlan", nameOfLastPlan);
        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
