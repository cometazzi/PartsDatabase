package org.badmotivator.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.logging.log4j.*;
import org.badmotivator.util.PropertiesLoader;

import java.io.IOException;
import java.util.Properties;

@WebServlet("/logOut")

public class LogOut extends HttpServlet  {

    private static final Logger logger = LogManager.getLogger(LogOut.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // First get user from the session.
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("userName");

        logger.info("User " + sessionUser + " logged out");
        // Invalidate session
        req.getSession().invalidate();


        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}