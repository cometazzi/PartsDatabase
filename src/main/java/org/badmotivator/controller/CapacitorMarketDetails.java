package org.badmotivator.controller;

import com.mouser.APIPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.Capacitor;
import org.badmotivator.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/capacitorMarketDetails"}
)
public class CapacitorMarketDetails extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<Capacitor> capacitorDao;
    private MouserInfo mouserInfo;

    @Override
    public void init() throws ServletException {
        super.init();
        capacitorDao = new GenericDao<>(Capacitor.class);
        mouserInfo = new MouserInfo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String partNum = req.getParameter("partNum");
        if (partNum != null && !partNum.isEmpty()) {
            List<Capacitor> capacitors = capacitorDao.getByPropertyEqual("partNum", partNum);
            if (capacitors != null && !capacitors.isEmpty()) {
                Capacitor capacitor = capacitors.get(0); // Assuming partNum is unique

                APIPart apiPart = null;
                try {
                    apiPart = mouserInfo.getMouserInfo(capacitor.getPartNum());
                    req.setAttribute("apiPart", apiPart);
                } catch (Exception e) {
                    logger.error("Error fetching Mouser data for part number: " + capacitor.getPartNum(), e);
                    req.setAttribute("mouserError", "Error retrieving market data from Mouser.");
                }

                req.setAttribute("capacitor", capacitor);
                req.getRequestDispatcher("capacitorDetails.jsp").forward(req, resp);
                return;
            } else {
                // Handle case where capacitor is not found in the database
                req.setAttribute("error", "Capacitor with part number '" + partNum + "' not found.");
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