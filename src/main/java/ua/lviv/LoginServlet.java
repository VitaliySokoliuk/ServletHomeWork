package ua.lviv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");

        Users_DAO users_dao = new Users_DAO();

        List<Users> user = users_dao.get(password);

        if (user.isEmpty()){
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        if (user.get(0).getPassword().equals(password)){
            req.setAttribute("userEmail", user.get(0).getEmail());
            req.setAttribute("user_f_name", user.get(0).getFirst_name());
            req.setAttribute("user_s_name", user.get(0).getSecond_name());
            req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }



}
