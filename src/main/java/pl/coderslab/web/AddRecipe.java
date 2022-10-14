package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.dao.RecipeDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Recipe;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;


@WebServlet("/app/recipe/add")
public class AddRecipe extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        request.getServletContext().getRequestDispatcher("/addRecipe.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String email = (String) request.getSession().getAttribute("email");
        int id = AdminDAO.checkId(email);

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int preparationTime = Integer.parseInt(request.getParameter("preparationTime"));
        String preparation = request.getParameter("preparation");
        String ingredients = request.getParameter("ingredients") ;

        Recipe newRecipe = new Recipe();
        newRecipe.setName(name);
        newRecipe.setDescription(description);
        newRecipe.setPreparationTime(preparationTime);
        newRecipe.setPreparation(preparation);
        newRecipe.setIngredients(ingredients);
        newRecipe.setCreated(String.valueOf(LocalDateTime.now()));
        newRecipe.setAdminId(id);

        RecipeDao recipeDao = new RecipeDao();
        recipeDao.create(newRecipe);

        response.sendRedirect("/app/recipe/list");
    }
}