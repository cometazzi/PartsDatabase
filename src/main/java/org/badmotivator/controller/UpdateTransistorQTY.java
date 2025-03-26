package org.badmotivator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.Transistor;
import org.badmotivator.entity.User;
import org.badmotivator.persistence.TransistorDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * A servlet to allow searches on transistors.
 * @author jdoderer
 *
 */

@WebServlet(
        urlPatterns = {"/UpdateTransistorQTY"}
)

public class UpdateTransistorQTY extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // First get user from the session.
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("userName");

        // If no user is logged in, send them to logIn Servlet.
        if (sessionUser == null) {


            resp.sendRedirect("logIn");
            return;
        }

        // map variables from the form.
        String selectedPartNum = req.getParameter("partNum");
        int qty = Integer.parseInt(req.getParameter("newQty"));

        // build daos and objects for manipulation.
        TransistorDao transistorDao = new TransistorDao();
        List<Transistor> transistorList = transistorDao.getByPropertyEqual("partNum", selectedPartNum);
        Transistor transistor = transistorList.get(0);

        // update object, then write to db
        transistor.setQty(qty);
        transistorDao.update(transistor);


            req.setAttribute( "updatedTransistor", transistorDao.getByPropertyEqual("partNum", selectedPartNum));


        RequestDispatcher dispatcher = req.getRequestDispatcher("/updateTransistorSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}
