package app.controller.servlet;

import app.model.dao.UserDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/managerTask")
public class ManagerTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO userDAO = new UserDAO();

    public ManagerTaskServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       /* try {
            request.setAttribute("list", UserDAO.getAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        */
        request.getRequestDispatcher("/WEB-INF/views/managerTaskView.jsp").forward(request, response);




        //  dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //request.getRequestDispatcher("managerTaskView.jsp").forward(request, response);
        doGet(request, response);
    }

}
