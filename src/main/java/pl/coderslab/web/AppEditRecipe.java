package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Plan;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(name = "AppEditRecipe", value = "/app/recipe/edit")
public class AppEditRecipe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Recipe recipe = RecipeDao.read(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("recipe", recipe);
        getServletContext().getRequestDispatcher("/appEditRecipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String email = (String) request.getSession().getAttribute("email");
        int id = AdminDAO.checkId(email);




        Recipe newRecipe = new Recipe();
        newRecipe.setName(request.getParameter("recipeName"));
        newRecipe.setDescription(request.getParameter("recipeDescription"));
        newRecipe.setPreparationTime(Integer.parseInt(request.getParameter("preparationTime")));
        newRecipe.setPreparation(request.getParameter("preparation"));
        newRecipe.setIngredients(request.getParameter("ingredients"));
        newRecipe.setUpdated(String.valueOf(LocalDateTime.now()));
        System.out.println(LocalDateTime.now());
        System.out.println(String.valueOf(LocalDateTime.now()));
        newRecipe.setCreated(request.getParameter("created"));
        newRecipe.setAdminId(id);
        newRecipe.setId(Integer.parseInt(request.getParameter("id")));
        System.out.println(newRecipe);


        RecipeDao.update(newRecipe);
        response.sendRedirect(request.getContextPath() + "/app/recipe/list");
    }
}
