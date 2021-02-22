package app.controller.servlet;

import app.controller.command.ViewAllOrdersCommand;
import app.controller.command.ViewAllUsersCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewAllUsers")
public class ViewUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewAllUsersCommand command = new ViewAllUsersCommand();
        String path = command.execute(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/showUsers.jsp");
        requestDispatcher.forward(req, resp);
    }
}
