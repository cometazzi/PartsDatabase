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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * A servlet to allow searches on transistors.
 *
 * @author jdoderer
 */

@WebServlet(
        urlPatterns = {"/ManageParts"}
)

public class ManageParts extends HttpServlet {
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

        Logger logger = LogManager.getLogger(ManageParts.class);
        // first get part type from the form data
        String partType = req.getParameter("partType");

        // test
        logger.debug("hitting ManageParts");
        logger.debug("part type is: " + partType);

        if (partType.equals("transistor")) {

            /// map variables from the form.
            String selectedPartNum = req.getParameter("partNum");
            int qty = Integer.parseInt(req.getParameter("newQty"));

            // build daos and objects for manipulation.
            GenericDao<Transistor> partDao = new GenericDao<>(Transistor.class);
            List<Transistor> transistorList = partDao.getByPropertyEqual("partNum", selectedPartNum);
            Transistor transistor = transistorList.get(0);

            // update object, then write to db
            transistor.setQty(qty);
            partDao.update(transistor);


            req.setAttribute("updatedTransistor", partDao.getByPropertyEqual("partNum", selectedPartNum));


            RequestDispatcher dispatcher = req.getRequestDispatcher("/transistorUpdateSuccess.jsp");
            dispatcher.forward(req, resp);

        } // end transistor


        if (partType.equals("capacitor")) {

            /// map variables from the form.
            String selectedPartNum = req.getParameter("partNum");
            int qty = Integer.parseInt(req.getParameter("newQty"));

            // build daos and objects for manipulation.
            GenericDao<Capacitor> partDao = new GenericDao<>(Capacitor.class);
            List<Capacitor> capacitorList = partDao.getByPropertyEqual("partNum", selectedPartNum);
            Capacitor capacitor = capacitorList.get(0);

            // update object, then write to db
            capacitor.setQty(qty);
            partDao.update(capacitor);


            req.setAttribute("updatedCapacitor", partDao.getByPropertyEqual("partNum", selectedPartNum));


            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/capacitorUpdateSuccess.jsp");
            dispatcher.forward(req, resp);
        } // end capacitor

        if (partType.equals("chipAmp")) {

            /// map variables from the form.
            String selectedPartNum = req.getParameter("partNum");
            int qty = Integer.parseInt(req.getParameter("newQty"));

            // build daos and objects for manipulation.
            GenericDao<ChipAmp> partDao = new GenericDao<>(ChipAmp.class);
            List<ChipAmp> chipAmpList = partDao.getByPropertyEqual("partNum", selectedPartNum);
            ChipAmp chipAmp = chipAmpList.get(0);

            // update object, then write to db
            chipAmp.setQty(qty);
            partDao.update(chipAmp);


            req.setAttribute("updatedChipAmp", partDao.getByPropertyEqual("partNum", selectedPartNum));


            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/chipAmpUpdateSuccess.jsp");
            dispatcher.forward(req, resp);
        } // end chipAmp

        if (partType.equals("diode")) {

            /// map variables from the form.
            String selectedPartNum = req.getParameter("partNum");
            int qty = Integer.parseInt(req.getParameter("newQty"));

            // build daos and objects for manipulation.
            GenericDao<Diode> partDao = new GenericDao<>(Diode.class);
            List<Diode> diodeList = partDao.getByPropertyEqual("partNum", selectedPartNum);
            Diode diode = diodeList.get(0);

            // update object, then write to db
            diode.setQty(qty);
            partDao.update(diode);


            req.setAttribute("updatedDiode", partDao.getByPropertyEqual("partNum", selectedPartNum));


            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/diodeUpdateSuccess.jsp");
            dispatcher.forward(req, resp);
        } // end diode

        if (partType.equals("linearIC")) {

            /// map variables from the form.
            String selectedPartNum = req.getParameter("partNum");
            int qty = Integer.parseInt(req.getParameter("newQty"));

            // build daos and objects for manipulation.
            GenericDao<LinearIC> partDao = new GenericDao<>(LinearIC.class);
            List<LinearIC> linearICList = partDao.getByPropertyEqual("partNum", selectedPartNum);
            LinearIC linearIC = linearICList.get(0);

            // update object, then write to db
            linearIC.setQty(qty);
            partDao.update(linearIC);


            req.setAttribute("updatedLinearIC", partDao.getByPropertyEqual("partNum", selectedPartNum));


            // forward to appropriate results page
            RequestDispatcher dispatcher = req.getRequestDispatcher("/linearICUpdateSuccess.jsp");
            dispatcher.forward(req, resp);
        } // end linearIC

    }
}
