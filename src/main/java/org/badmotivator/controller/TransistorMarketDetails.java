package org.badmotivator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.Transistor;
import org.badmotivator.persistence.GenericDao;
import com.mouser.APIPart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/transistorMarketDetails"}
)
public class TransistorMarketDetails extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Transistor> transistorDao;
    private MouserInfo mouserInfo;

    @Override
    public void init() throws ServletException {
        super.init();
        transistorDao = new GenericDao<>(Transistor.class);
        mouserInfo = new MouserInfo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String partNum = req.getParameter("partNum");
        if (partNum != null && !partNum.isEmpty()) {
            List<Transistor> transistors = transistorDao.getByPropertyEqual("partNum", partNum);
            if (transistors != null && !transistors.isEmpty()) {
                Transistor transistor = transistors.get(0); // Assuming partNum is unique

                APIPart apiPart = null;
                try {
                    apiPart = mouserInfo.getMouserInfo(transistor.getPartNum());
                    req.setAttribute("apiPart", apiPart);
                } catch (Exception e) {
                    logger.error("Error fetching Mouser data for part number: " + transistor.getPartNum(), e);
                    req.setAttribute("mouserError", "Error retrieving market data from Mouser.");
                }

                req.setAttribute("transistor", transistor);
                req.getRequestDispatcher("transistorDetails.jsp").forward(req, resp);
                return;
            } else {
                // Handle case where transistor is not found in the database
                req.setAttribute("error", "Transistor with part number '" + partNum + "' not found.");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
        } else {
            // Handle case where partNum parameter is missing
            req.setAttribute("error", "Missing part number parameter.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
}