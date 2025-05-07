package org.badmotivator.controller;

import com.mouser.APIPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.ChipAmp;
import org.badmotivator.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/chipAmpMarketDetails"}
)
public class ChipAmpMarketDetails extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao<ChipAmp> chipAmpDao;
    private MouserInfo mouserInfo;

    @Override
    public void init() throws ServletException {
        super.init();
        chipAmpDao = new GenericDao<>(ChipAmp.class);
        mouserInfo = new MouserInfo();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String partNum = req.getParameter("partNum");
        if (partNum != null && !partNum.isEmpty()) {
            List<ChipAmp> chipAmps = chipAmpDao.getByPropertyEqual("partNum", partNum);
            if (chipAmps != null && !chipAmps.isEmpty()) {
                ChipAmp chipAmp = chipAmps.get(0); // Assuming partNum is unique

                APIPart apiPart = null;
                try {
                    apiPart = mouserInfo.getMouserInfo(chipAmp.getPartNum());
                    req.setAttribute("apiPart", apiPart);
                } catch (Exception e) {
                    logger.error("Error fetching Mouser data for part number: " + chipAmp.getPartNum(), e);
                    req.setAttribute("mouserError", "Error retrieving market data from Mouser.");
                }

                req.setAttribute("chipAmp", chipAmp);
                req.getRequestDispatcher("chipAmpDetails.jsp").forward(req, resp);
                return;
            } else {
                // Handle case where chipAmp is not found in the database
                req.setAttribute("error", "ChipAmp with part number '" + partNum + "' not found.");
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