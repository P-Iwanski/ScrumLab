package pl.coderslab.web;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value ="/app/*")
public class ForLogOnly implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //Rzeczy które mają być dostępne dla zalogowanych użytkowników muszą byc w folderze app.
        //Recipes.html który się tam znajduje jest tylko po to by zobaczyć czy zalogowany użytkownik się tam przedostanie.
        //Po testach proponuję usunąć recipe.html. Folder app zostawić.
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String isLog = (String) httpRequest.getSession().getAttribute("email");
        if (isLog == null || isLog.isBlank()) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        chain.doFilter(request, response);
    }
}
