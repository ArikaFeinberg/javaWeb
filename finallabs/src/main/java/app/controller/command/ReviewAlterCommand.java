package app.controller.command;

import app.model.entity.UserAccount;
import app.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class ReviewAlterCommand extends AbstractCommand
{
    OrderService service;

    public ReviewAlterCommand(){
        this.service = new OrderService();
    }
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserAccount loginedUser = (UserAccount) session.getAttribute("loginedUser");
        String clientName = loginedUser.getUserName();
        String review = request.getParameter("review");
        String orderName = request.getParameter("orderName");
        try {
            int command = OrderService.checkStatus(clientName, orderName);
            if(command==1){
                OrderService.alterReview(clientName, review, orderName);
            }
            else{
                return "/WEB-INF/views/error.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/WEB-INF/views/homeView.jsp";

}
}
