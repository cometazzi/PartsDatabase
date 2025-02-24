package org.badmotivator.controller;

import org.badmotivator.persistence.TransistorDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A servlet to allow searches on transistors.
 * @author jdoderer
 *
 */

@WebServlet(
        urlPatterns = {"/searchTransistors"}
)

public class SearchTransistors extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TransistorDao userDao = new TransistorDao();

        if (req.getParameter("submit").equals("search")) {

            req.setAttribute( "users", userDao.getByPropertyEqual("lastName", req.getParameter("searchTerm")));
        } else if (req.getParameter("submit").equals("viewAll")) {
            req.setAttribute("users", userDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/transistorResults.jsp");
        dispatcher.forward(req, resp);
    }
}
