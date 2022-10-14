package pl.coderslab.web;

import pl.coderslab.dao.AdminDAO;
import pl.coderslab.dao.PlanDao;
import pl.coderslab.model.Admin;
import pl.coderslab.model.Plan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/app/plan/add")
public class AddPlan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        getServletContext().getRequestDispatcher("/addPlan.jsp").forward(request, response);
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

        PlanDao planDao = new PlanDao();
        planDao.create(newPlan);

        response.sendRedirect(request.getContextPath() + "/app/plan/list");

    }
}
