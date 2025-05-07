package org.badmotivator.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.util.PropertiesLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/logOut"}
)

/**
 * Logs the user out of the application and initiates the logout from AWS Cognito.
 */
public class LogOut extends HttpServlet implements PropertiesLoader {
    private Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());
    private String clientId;
    private String logoutURL;
    private String logoutRedirectURL; // New property for the post-Cognito logout redirect

    @Override
    public void init() throws ServletException {
        super.init();
        loadProperties();
    }

    private void loadProperties() {
        try {
            properties = loadProperties("/cognito.properties");
            clientId = properties.getProperty("client.id");
            logoutURL = properties.getProperty("logoutURL");
            logoutRedirectURL = properties.getProperty("logoutRedirectURL"); // Load the new property
            if (logoutRedirectURL == null || logoutRedirectURL.trim().isEmpty()) {
                logger.error("logoutRedirectURL is not set in cognito.properties. Cognito logout redirect might not work as expected.");
            }
        } catch (IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties: " + e.getMessage(), e);
        }
    }

    /**
     * Handles the GET request to log the user out.
     *
     * @param req  servlet request
     * @param resp servlet response
     * @throws ServletException if an exception occurs during servlet execution
     * @throws IOException      if an I/O exception occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the application session
            logger.info("Application session invalidated for user (if any).");
        }

        // Construct the Cognito logout URL with the new logout redirect URL
        String cognitoLogoutUrl = logoutURL + "?client_id=" + clientId + "&logout_uri=" + logoutRedirectURL;
        logger.info("Redirecting to Cognito logout URL: {}", cognitoLogoutUrl);
        resp.sendRedirect(cognitoLogoutUrl);
    }
}