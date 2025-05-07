package org.badmotivator.controller;

import com.mouser.APIPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.LinearIC;
import org.badmotivator.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/linearICMarketDetails"}
)
public class LinearICMarketDetails extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<LinearIC> linearICDao;
    private MouserInfo mouserInfo;

    @Override
    public void init() throws ServletException {
        super.init();
        linearICDao = new GenericDao<>(LinearIC.class);
        mouserInfo = new MouserInfo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String partNum = req.getParameter("partNum");
        if (partNum != null && !partNum.isEmpty()) {
            List<LinearIC> linearICs = linearICDao.getByPropertyEqual("partNum", partNum);
            if (linearICs != null && !linearICs.isEmpty()) {
                LinearIC linearIC = linearICs.get(0); // Assuming partNum is unique

                APIPart apiPart = null;
                try {
                    apiPart = mouserInfo.getMouserInfo(linearIC.getPartNum());
                    req.setAttribute("apiPart", apiPart);
                } catch (Exception e) {
                    logger.error("Error fetching Mouser data for part number: " + linearIC.getPartNum(), e);
                    req.setAttribute("mouserError", "Error retrieving market data from Mouser.");
                }

                req.setAttribute("linearIC", linearIC);
                req.getRequestDispatcher("linearICDetails.jsp").forward(req, resp);
                return;
            } else {
                // Handle case where linearIC is not found in the database
                req.setAttribute("error", "LinearIC with part number '" + partNum + "' not found.");
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