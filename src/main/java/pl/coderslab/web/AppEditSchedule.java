package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

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
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String email = (String) request.getSession().getAttribute("email");
        int id = AdminDAO.checkId(email);
        LocalDateTime localDateTime = LocalDateTime.now();


        Plan newPlan = new Plan();
        newPlan.setName(request.getParameter("planName"));
        newPlan.setDescription(request.getParameter("planDescription"));
        newPlan.setCreated(String.valueOf(localDateTime));
        newPlan.setAdminId(id);
        newPlan.setId(Integer.parseInt(request.getParameter("id")));

        PlanDao.update(newPlan);
        response.sendRedirect(request.getContextPath() + "/app/plan/list");

    }
}
