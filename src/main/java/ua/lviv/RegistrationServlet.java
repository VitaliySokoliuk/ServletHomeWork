package ua.lviv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String second_name = req.getParameter("second_name");
        int age = Integer.parseInt(req.getParameter("age"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Users_DAO users_dao = new Users_DAO();
        int userId = users_dao.insert(first_name, second_name, age, email, password);
        if (userId == 0){
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            throw new RuntimeException("Can`t insert new user");
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }
}
