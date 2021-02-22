package app.controller.servlet;

import app.controller.command.AbstractCommand;
import app.controller.command.CountAlterCommand;
import app.controller.command.ReviewAlterCommand;
import app.model.entity.UserAccount;
import app.model.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/review.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
        String clientName = loginedUser.getUserName();
        String review = req.getParameter("review");
        String orderName = req.getParameter("orderName");
        try {
            int command = OrderService.checkStatus(clientName, orderName);
            if(command==1){
                OrderService.alterReview(clientName, review, orderName);

            }
            else{
                req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/views/homeView.jsp").forward(req, resp);
    }
    }
