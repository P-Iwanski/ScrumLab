package pl.coderslab.web;

import pl.coderslab.dao.PlanDao;
import pl.coderslab.dao.RecipePlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/app/plan/details")
public class AppPlanDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        PlanDao planDao = new PlanDao();
        Plan read = planDao.read(Integer.parseInt(id));
        request.setAttribute("plan", read);

        RecipePlanDao recipePlanDao = new RecipePlanDao();
        request.setAttribute("recipePlan", recipePlanDao.findById(Integer.parseInt(id)));
        getServletContext().getRequestDispatcher("/appPlanDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}