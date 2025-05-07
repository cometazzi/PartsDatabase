package org.badmotivator.controller;

import com.mouser.APIPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.Diode;
import org.badmotivator.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/diodeMarketDetails"}
)
public class DiodeMarketDetails extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Diode> diodeDao;
    private MouserInfo mouserInfo;

    @Override
    public void init() throws ServletException {
        super.init();
        diodeDao = new GenericDao<>(Diode.class);
        mouserInfo = new MouserInfo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String partNum = req.getParameter("partNum");
        if (partNum != null && !partNum.isEmpty()) {
            List<Diode> diodes = diodeDao.getByPropertyEqual("partNum", partNum);
            if (diodes != null && !diodes.isEmpty()) {
                Diode diode = diodes.get(0); // Assuming partNum is unique

                APIPart apiPart = null;
                try {
                    apiPart = mouserInfo.getMouserInfo(diode.getPartNum());
                    req.setAttribute("apiPart", apiPart);
                } catch (Exception e) {
                    logger.error("Error fetching Mouser data for part number: " + diode.getPartNum(), e);
                    req.setAttribute("mouserError", "Error retrieving market data from Mouser.");
                }

                req.setAttribute("diode", diode);
                req.getRequestDispatcher("diodeDetails.jsp").forward(req, resp);
                return;
            } else {
                // Handle case where diode is not found in the database
                req.setAttribute("error", "Diode with part number '" + partNum + "' not found.");
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