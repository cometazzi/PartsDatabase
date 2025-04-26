package org.badmotivator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.*;
import org.badmotivator.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * A servlet to allow searches on transistors.
 *
 * @author jdoderer
 */

@WebServlet(
        urlPatterns = {"/searchParts"}
)

public class SearchParts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger logger = LogManager.getLogger(SearchParts.class);
        // first get part type from the form data
        String partType = req.getParameter("partType");

        // test
        logger.debug("hitting SearchParts");
        logger.debug("part type is: " + partType);

        if (partType.equals("transistor")) {

            // Create dao
            GenericDao<Transistor> partDao = new GenericDao<>(Transistor.class);

            // one or all
            if (req.getParameter("submit").equals("search")) {  // retrieve one
                // set values
                req.setAttribute("transistors", partDao.getByPropertyLike("partNum", req.getParameter("searchTerm")));

            } else if (req.getParameter("submit").equals("viewAll")) { // retrieve all
                // set values
                req.setAttribute("transistors", partDao.getAll());
            }

            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/transistorResults.jsp");
            dispatcher.forward(req, resp);
        } // end transistor

        if (partType.equals("capacitor")) {

            // Create dao
            GenericDao<Capacitor> partDao = new GenericDao<>(Capacitor.class);

            // one or all
            if (req.getParameter("submit").equals("search")) {  // retrieve one
                // set values
                req.setAttribute("capacitors", partDao.getByPropertyLike("partNum", req.getParameter("searchTerm")));

            } else if (req.getParameter("submit").equals("viewAll")) { // retrieve all
                // set values
                req.setAttribute("capacitors", partDao.getAll());
            }

            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/capacitorResults.jsp");
            dispatcher.forward(req, resp);
        } // end capacitor

        if (partType.equals("chipAmp")) {

            // Create dao
            GenericDao<ChipAmp> partDao = new GenericDao<>(ChipAmp.class);

            // one or all
            if (req.getParameter("submit").equals("search")) {  // retrieve one
                // set values
                req.setAttribute("chipAmps", partDao.getByPropertyLike("partNum", req.getParameter("searchTerm")));

            } else if (req.getParameter("submit").equals("viewAll")) { // retrieve all
                // set values
                req.setAttribute("chipAmps", partDao.getAll());
            }

            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/chipAmpResults.jsp");
            dispatcher.forward(req, resp);
        } // end chipAmp

        if (partType.equals("diode")) {

            // Create dao
            GenericDao<Diode> partDao = new GenericDao<>(Diode.class);

            // one or all
            if (req.getParameter("submit").equals("search")) {  // retrieve one
                // set values
                req.setAttribute("diodes", partDao.getByPropertyLike("partNum", req.getParameter("searchTerm")));

            } else if (req.getParameter("submit").equals("viewAll")) { // retrieve all
                // set values
                req.setAttribute("diodes", partDao.getAll());
            }

            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/diodeResults.jsp");
            dispatcher.forward(req, resp);
        } // end diode

        if (partType.equals("linearIC")) {

            // Create dao
            GenericDao<LinearIC> partDao = new GenericDao<>(LinearIC.class);

            // one or all
            if (req.getParameter("submit").equals("search")) {  // retrieve one
                // set values
                req.setAttribute("linearICs", partDao.getByPropertyLike("partNum", req.getParameter("searchTerm")));

            } else if (req.getParameter("submit").equals("viewAll")) { // retrieve all
                // set values
                req.setAttribute("linearICs", partDao.getAll());
            }

            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/linearICResults.jsp");
            dispatcher.forward(req, resp);
        } // end linearIC
    }
}
