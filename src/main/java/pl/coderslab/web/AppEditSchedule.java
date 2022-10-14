package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AppEditSchedule", value = "/app/edit/schedule")
public class AppEditSchedule extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = (String) request.getSession().getAttribute("email");
        Plan plan = PlanDao.read(Integer.valueOf(request.getParameter("id")));
        request.setAttribute("plan", plan);
        getServletContext().getRequestDispatcher("/appEditSchedules.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
