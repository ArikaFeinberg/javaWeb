package app.controller.servlet;

import app.controller.command.SortByPriceCommand;
import app.controller.command.SortByStatusCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sortByStatus")
public class SortByStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SortByStatusCommand command = new SortByStatusCommand();
        String path = command.execute(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/showOrders.jsp");
        requestDispatcher.forward(req, resp);
    }
}
