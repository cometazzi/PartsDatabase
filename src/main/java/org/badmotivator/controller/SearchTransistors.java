package org.badmotivator.controller;

import org.badmotivator.entity.Transistor;
import org.badmotivator.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A servlet to allow searches on transistors.
 *
 * @author jdoderer
 */

@WebServlet(
        urlPatterns = {"/searchTransistors"}
)

public class SearchTransistors extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // use GenericDAO instead
        GenericDao<Transistor> transistorDao = new GenericDao<>(Transistor.class);

        if (req.getParameter("submit").equals("search")) {

            req.setAttribute("transistors", transistorDao.getByPropertyLike("partNum", req.getParameter("searchTerm")));
        } else if (req.getParameter("submit").equals("viewAll")) {
            req.setAttribute("transistors", transistorDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/transistorResults.jsp");
        dispatcher.forward(req, resp);
    }
}
