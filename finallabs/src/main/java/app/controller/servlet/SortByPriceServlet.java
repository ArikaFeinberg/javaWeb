package app.controller.servlet;

import app.controller.command.SortByDateCommand;
import app.controller.command.SortByPriceCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sortByPrice")
public class SortByPriceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SortByPriceCommand command = new SortByPriceCommand();
        String path = command.execute(req, resp);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/showOrders.jsp");
        requestDispatcher.forward(req, resp);
    }
}
