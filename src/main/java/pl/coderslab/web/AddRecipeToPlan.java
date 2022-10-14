package pl.coderslab.web;

import pl.coderslab.dao.DayNameDao;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;
import pl.coderslab.model.RecipePlan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/app/recipe/plan/add")
public class AddRecipeToPlan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
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
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        RecipePlanDao recipePlanDao = new RecipePlanDao();
        RecipePlan recipePlan = new RecipePlan();

        recipePlan.setPlanId(recipePlanDao.readPlanId(request.getParameter("choosePlan")));
        recipePlan.setMealName(request.getParameter("mealName"));
        recipePlan.setDisplayOrder(Integer.parseInt(request.getParameter("displayNumber")));
        recipePlan.setRecipeId(recipePlanDao.readRecipeId(request.getParameter("recipeName")));
        recipePlan.setDayNameId(recipePlanDao.readDayId(request.getParameter("dayName")));

        System.out.println(request.getParameter("choosePlan"));
        System.out.println(request.getParameter("mealName"));
        System.out.println(request.getParameter("displayNumber"));
        System.out.println(request.getParameter("recipeName"));
        System.out.println(request.getParameter("dayName"));

        System.out.println(recipePlanDao.readPlanId(request.getParameter("choosePlan")));
        System.out.println(recipePlanDao.readRecipeId(request.getParameter("recipeName")));
        System.out.println(recipePlanDao.readDayId(request.getParameter("dayName")));

        recipePlanDao.create(recipePlan);
        response.sendRedirect(request.getContextPath() + "/app/recipe/plan/add");
    }
}