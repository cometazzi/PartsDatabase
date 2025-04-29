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
        urlPatterns = {"/AdminManageParts"}
)

public class AdminManageParts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // First get user from the session.
        HttpSession session = req.getSession();
        String sessionUser = (String) session.getAttribute("userName");


        // If not admin logged in, send them to logIn Servlet.
        // Deflect 'em all, let Cognito sort 'em out
        if ((sessionUser == null) || (!sessionUser.equals("admin"))) {

            resp.sendRedirect("logIn");
            return;
        }

        Logger logger = LogManager.getLogger(AdminManageParts.class);
        // first get part type from the form data
        String partType = req.getParameter("partType");

        // test
        logger.debug("hitting AdminManageParts");
        logger.debug("part type is: " + partType);

        if (partType.equals("transistor")) {

            if (req.getParameter("submit").equals("editTransistor")) {
                /// map variables from the form.
                String selectedPartNum = req.getParameter("partNum");
                String newPkg = req.getParameter("newPkg");
                String newPartNum = req.getParameter("newPartNum");
                String newTech = req.getParameter("newTech");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // build daos and objects for manipulation.
                GenericDao<Transistor> partDao = new GenericDao<>(Transistor.class);
                List<Transistor> transistorList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                Transistor transistor = transistorList.get(0);

                int transistorPkg = Integer.parseInt(newPkg);
                // update object, then write to db
                transistor.setPartNum(newPartNum);
                transistor.setPackageName(transistorPkg);
                transistor.setImageUrl(newPkg);
                transistor.setPartNum(newPartNum);
                transistor.setTechnology(newTech);
                transistor.setDescr(newDesc);
                transistor.setQty(newQty);
                transistor.setCost(newCost);
                partDao.update(transistor);

                req.setAttribute("updatedTransistor", partDao.getByPropertyEqual("partNum", newPartNum));
                // forward to appropriate results page
                RequestDispatcher dispatcher = req.getRequestDispatcher("/transistorUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("deleteTransistor")) {

                // get part number
                String selectedPartNum = req.getParameter("partNum");

                // create dao and object
                GenericDao<Transistor> partDao = new GenericDao<>(Transistor.class);
                List<Transistor> transistorList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                Transistor transistorToDelete = transistorList.get(0);

                // delete part
                partDao.delete(transistorToDelete);

                // forward to appropriate results page
                req.setAttribute("deletedTransistor", selectedPartNum);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/transistorDeleteSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("addNewTransistor")) {

                /// map variables from the form.
                /// map variables from the form.
                String newPkg = req.getParameter("newPkg");
                String newPartNum = req.getParameter("newPartNum");
                String newTech = req.getParameter("newTech");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // create dao and object
                GenericDao<Transistor> partDao = new GenericDao<>(Transistor.class);
                Transistor newTransistor = new Transistor();

                // populate values
                int transistorPkg = Integer.parseInt(newPkg);
                // update object, then write to db
                newTransistor.setPartNum(newPartNum);
                newTransistor.setPackageName(transistorPkg);
                newTransistor.setImageUrl(newPkg);
                newTransistor.setPartNum(newPartNum);
                newTransistor.setTechnology(newTech);
                newTransistor.setDescr(newDesc);
                newTransistor.setQty(newQty);
                newTransistor.setCost(newCost);

                // insert
                partDao.insert(newTransistor);

                // forward to appropriate results page
                req.setAttribute("updatedTransistor", partDao.getByPropertyEqual("partNum", newPartNum));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/transistorUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            }

        } // end transistor


        if (partType.equals("capacitor")) {

            if (req.getParameter("submit").equals("editCapacitor")) {
                /// map variables from the form.
                String selectedPartNum = req.getParameter("partNum");
                String newPartNum = req.getParameter("newPartNum");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // build daos and objects for manipulation.
                GenericDao<Capacitor> partDao = new GenericDao<>(Capacitor.class);
                List<Capacitor> capacitorList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                Capacitor capacitor = capacitorList.get(0);

                // update object, then write to db
                capacitor.setPartNum(newPartNum);
                capacitor.setDescr(newDesc);
                capacitor.setQty(newQty);
                capacitor.setCost(newCost);
                partDao.update(capacitor);

                req.setAttribute("updatedCapacitor", partDao.getByPropertyEqual("partNum", newPartNum));
                // forward to appropriate results page
                RequestDispatcher dispatcher = req.getRequestDispatcher("/capacitorUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("deleteCapacitor")) {

                // get part number
                String selectedPartNum = req.getParameter("partNum");

                // create dao and object
                GenericDao<Capacitor> partDao = new GenericDao<>(Capacitor.class);
                List<Capacitor> capacitorList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                Capacitor capacitorToDelete = capacitorList.get(0);

                // delete part
                partDao.delete(capacitorToDelete);

                // forward to appropriate results page
                req.setAttribute("deletedCapacitor", selectedPartNum);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/capacitorDeleteSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("addNewCapacitor")) {

                /// map variables from the form.
                String newImage = req.getParameter("capacitorType");
                String newPartNum = req.getParameter("newPartNum");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // create dao and object
                GenericDao<Capacitor> partDao = new GenericDao<>(Capacitor.class);
                Capacitor addedCapacitor = new Capacitor();

                // populate values
                addedCapacitor.setImageUrl(newImage);
                addedCapacitor.setPartNum(newPartNum);
                addedCapacitor.setDescr(newDesc);
                addedCapacitor.setQty(newQty);
                addedCapacitor.setCost(newCost);

                // insert
                partDao.insert(addedCapacitor);

                // forward to appropriate results page
                req.setAttribute("updatedCapacitor", partDao.getByPropertyEqual("partNum", newPartNum));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/capacitorUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            }

        } // end capacitor

        if (partType.equals("chipAmp")) {

            if (req.getParameter("submit").equals("editChipAmp")) {
                /// map variables from the form.
                String selectedPartNum = req.getParameter("partNum");
                String newPkg = req.getParameter("newPkg");
                String newPartNum = req.getParameter("newPartNum");
                String newTech = req.getParameter("newTech");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // build daos and objects for manipulation.
                GenericDao<ChipAmp> partDao = new GenericDao<>(ChipAmp.class);
                List<ChipAmp> chipAmpList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                ChipAmp chipAmp = chipAmpList.get(0);

                int chipAmpPkg = Integer.parseInt(newPkg);
                // update object, then write to db
                chipAmp.setPartNum(newPartNum);
                chipAmp.setPackageName(chipAmpPkg);
                chipAmp.setImageUrl(newPkg);
                chipAmp.setPartNum(newPartNum);
                chipAmp.setTechnology(newTech);
                chipAmp.setDescr(newDesc);
                chipAmp.setQty(newQty);
                chipAmp.setCost(newCost);
                partDao.update(chipAmp);

                req.setAttribute("updatedChipAmp", partDao.getByPropertyEqual("partNum", newPartNum));
                // forward to appropriate results page
                RequestDispatcher dispatcher = req.getRequestDispatcher("/chipAmpUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("deleteChipAmp")) {

                // get part number
                String selectedPartNum = req.getParameter("partNum");

                // create dao and object
                GenericDao<ChipAmp> partDao = new GenericDao<>(ChipAmp.class);
                List<ChipAmp> chipAmpList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                ChipAmp chipAmpToDelete = chipAmpList.get(0);

                // delete part
                partDao.delete(chipAmpToDelete);

                // forward to appropriate results page
                req.setAttribute("deletedChipAmp", selectedPartNum);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/chipAmpDeleteSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("addNewChipAmp")) {

                /// map variables from the form.
                /// map variables from the form.
                String newPkg = req.getParameter("newPkg");
                String newPartNum = req.getParameter("newPartNum");
                String newTech = req.getParameter("newTech");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // create dao and object
                GenericDao<ChipAmp> partDao = new GenericDao<>(ChipAmp.class);
                ChipAmp newChipAmp = new ChipAmp();

                // populate values
                int chipAmpPkg = Integer.parseInt(newPkg);
                // update object, then write to db
                newChipAmp.setPartNum(newPartNum);
                newChipAmp.setPackageName(chipAmpPkg);
                newChipAmp.setImageUrl(newPkg);
                newChipAmp.setPartNum(newPartNum);
                newChipAmp.setTechnology(newTech);
                newChipAmp.setDescr(newDesc);
                newChipAmp.setQty(newQty);
                newChipAmp.setCost(newCost);

                // insert
                partDao.insert(newChipAmp);

                // forward to appropriate results page
                req.setAttribute("updatedChipAmp", partDao.getByPropertyEqual("partNum", newPartNum));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/chipAmpUpdateSuccess.jsp");
                dispatcher.forward(req, resp);

            }
        } // end chipAmp

        if (partType.equals("diode")) {

            if (req.getParameter("submit").equals("editDiode")) {
                /// map variables from the form.
                String selectedPartNum = req.getParameter("partNum");
                String newPkg = req.getParameter("newPkg");
                String newPartNum = req.getParameter("newPartNum");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // build daos and objects for manipulation.
                GenericDao<Diode> partDao = new GenericDao<>(Diode.class);
                List<Diode> diodeList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                Diode diode = diodeList.get(0);

                int diodePkg = Integer.parseInt(newPkg);
                // update object, then write to db
                diode.setPartNum(newPartNum);
                diode.setPackageName(diodePkg);
                diode.setImageUrl(newPkg);
                diode.setPartNum(newPartNum);
                diode.setDescr(newDesc);
                diode.setQty(newQty);
                diode.setCost(newCost);
                partDao.update(diode);


                req.setAttribute("updatedDiode", partDao.getByPropertyEqual("partNum", newPartNum));
                // forward to appropriate results page
                RequestDispatcher dispatcher = req.getRequestDispatcher("/diodeUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("deleteDiode")) {

                // get part number
                String selectedPartNum = req.getParameter("partNum");

                // create dao and object
                GenericDao<Diode> partDao = new GenericDao<>(Diode.class);
                List<Diode> diodeList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                Diode diodeToDelete = diodeList.get(0);

                // delete part
                partDao.delete(diodeToDelete);

                // forward to appropriate results page
                req.setAttribute("deletedDiode", selectedPartNum);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/diodeDeleteSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("addNewDiode")) {

                /// map variables from the form.
                /// map variables from the form.
                String newPkg = req.getParameter("newPkg");
                String newPartNum = req.getParameter("newPartNum");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // create dao and object
                GenericDao<Diode> partDao = new GenericDao<>(Diode.class);
                Diode newDiode = new Diode();

                // populate values
                int diodePkg = Integer.parseInt(newPkg);
                // update object, then write to db
                newDiode.setPartNum(newPartNum);
                newDiode.setPackageName(diodePkg);
                newDiode.setImageUrl(newPkg);
                newDiode.setPartNum(newPartNum);
                newDiode.setDescr(newDesc);
                newDiode.setQty(newQty);
                newDiode.setCost(newCost);

                // insert
                partDao.insert(newDiode);

                // forward to appropriate results page
                req.setAttribute("updatedDiode", partDao.getByPropertyEqual("partNum", newPartNum));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/diodeUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            }

        } // end diode

        if (partType.equals("linearIC")) {

            if (req.getParameter("submit").equals("editLinearIC")) {
                /// map variables from the form.
                String selectedPartNum = req.getParameter("partNum");
                String newPkg = req.getParameter("newPkg");
                String newPartNum = req.getParameter("newPartNum");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // build daos and objects for manipulation.
                GenericDao<LinearIC> partDao = new GenericDao<>(LinearIC.class);
                List<LinearIC> linearICList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                LinearIC linearIC = linearICList.get(0);

                int linearICPkg = Integer.parseInt(newPkg);
                // update object, then write to db
                linearIC.setPartNum(newPartNum);
                linearIC.setPackageName(linearICPkg);
                linearIC.setImageUrl(newPkg);
                linearIC.setPartNum(newPartNum);
                linearIC.setDescr(newDesc);
                linearIC.setQty(newQty);
                linearIC.setCost(newCost);
                partDao.update(linearIC);

                req.setAttribute("updatedLinearIC", partDao.getByPropertyEqual("partNum", newPartNum));
                // forward to appropriate results page
                RequestDispatcher dispatcher = req.getRequestDispatcher("/linearICUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("deleteLinearIC")) {

                // get part number
                String selectedPartNum = req.getParameter("partNum");

                // create dao and object
                GenericDao<LinearIC> partDao = new GenericDao<>(LinearIC.class);
                List<LinearIC> linearICList = partDao.getByPropertyEqual("partNum", selectedPartNum);
                LinearIC linearICToDelete = linearICList.get(0);

                // delete part
                partDao.delete(linearICToDelete);

                // forward to appropriate results page
                req.setAttribute("deletedLinearIC", selectedPartNum);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/linearICDeleteSuccess.jsp");
                dispatcher.forward(req, resp);
            } else if (req.getParameter("submit").equals("addNewLinearIC")) {

                /// map variables from the form.
                /// map variables from the form.
                String newPkg = req.getParameter("newPkg");
                String newPartNum = req.getParameter("newPartNum");
                String newDesc = req.getParameter("newDesc");
                int newQty = Integer.parseInt(req.getParameter("newQty"));
                String newCost = req.getParameter("newCost");

                // create dao and object
                GenericDao<LinearIC> partDao = new GenericDao<>(LinearIC.class);
                LinearIC newLinearIC = new LinearIC();

                // populate values
                int linearICPkg = Integer.parseInt(newPkg);
                // update object, then write to db
                newLinearIC.setPartNum(newPartNum);
                newLinearIC.setPackageName(linearICPkg);
                newLinearIC.setImageUrl(newPkg);
                newLinearIC.setPartNum(newPartNum);
                newLinearIC.setDescr(newDesc);
                newLinearIC.setQty(newQty);
                newLinearIC.setCost(newCost);

                // insert
                partDao.insert(newLinearIC);

                // forward to appropriate results page
                req.setAttribute("updatedLinearIC", partDao.getByPropertyEqual("partNum", newPartNum));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/linearICUpdateSuccess.jsp");
                dispatcher.forward(req, resp);
            }

        } // end linearIC

    }
}
