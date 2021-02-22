package app.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

public abstract class AbstractCommand implements Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }

    public void setErrorRequest(HttpServletRequest req, HttpServletResponse resp, String errMessage, String page) throws ServletException, IOException {
        req.setAttribute("error", errMessage);
        req.setAttribute("pagelink", page);
        req.getRequestDispatcher("/jsp/error.jsp").forward(req, resp);
    }
}
