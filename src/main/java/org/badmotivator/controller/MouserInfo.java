package org.badmotivator.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mouser.APIPart;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.badmotivator.entity.Transistor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

public class MouserInfo {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public APIPart getTransistorMktInfo(String partNumb) throws Exception {

        // create APIPart object
        APIPart mkData = new APIPart();

        // populate APIPart object with mouser data
        mkData = getMouserInfo(partNumb);

        return mkData;


    }


    // Get data from Mouser API
    public APIPart getMouserInfo(String keyword) throws Exception {
        String apiKey = "cb07eb7a-d182-4786-8bfd-ef63d3ec38a8";
        String searchUrl = "https://api.mouser.com/api/v2/search/keyword";
        int recordsPerPage = 1;
        int startingRecord = 1;

        // Construct the JSON request body using String.format
        String requestBody = String.format(
                "{\n" +
                        "  \"SearchByKeywordRequest\": {\n" +
                        "    \"keyword\": \"%s\",\n" +
                        "    \"records\": %d,\n" +
                        "    \"startingRecord\": %d,\n" +
                        "    \"searchOptions\": \"\",\n" +
                        "    \"searchWithYourSignUpLanguage\": \"\"\n" +
                        "  }\n" +
                        "}",
                keyword, recordsPerPage, startingRecord
        );

        // Create a JAX-RS client
        Client client = ClientBuilder.newClient();

        // Create a WebTarget pointing to the API endpoint with the API key as a query parameter
        WebTarget target = client.target(searchUrl)
                .queryParam("apiKey", apiKey);

        // Send the POST request with the JSON body
        Response response = target.request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(requestBody, MediaType.APPLICATION_JSON));

        // Get the response status code
        int statusCode = response.getStatus();
        logger.info("Status Code: " + statusCode);

        // Get the response body as a String
        String responseBody = response.readEntity(String.class);
        logger.info("Response Body:\n" + responseBody);

        // Use Jackson to parse the JSON and map to APIPart
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);

        // Navigate to the parts array
        JsonNode partsNode = rootNode.path("SearchResults").path("Parts");

        if (partsNode.isArray() && partsNode.size() > 0) {
            JsonNode firstPart = partsNode.get(0);
            APIPart apiPart = new APIPart();

            apiPart.setMouserPartNumber(firstPart.path("MouserPartNumber").asText());
            apiPart.setAvailability(firstPart.path("Availability").asText());
            apiPart.setDataSheetUrl(firstPart.path("DataSheetUrl").asText());
            apiPart.setDescription(firstPart.path("Description").asText());

            JsonNode priceBreaksNode = firstPart.path("PriceBreaks");
            if (priceBreaksNode.isArray()) {
                for (JsonNode priceBreak : priceBreaksNode) {
                    int quantity = priceBreak.path("Quantity").asInt();
                    String priceStr = priceBreak.path("Price").asText().replace("$", "");
                    BigDecimal price = new BigDecimal(priceStr);
                    String currency = priceBreak.path("Currency").asText();
                    if (quantity == 1) {
                        apiPart.setPriceFor1(price);
                        apiPart.setCurrency(currency); // Assuming currency is the same for all price breaks
                    } else if (quantity == 10) {
                        apiPart.setPriceFor10(price);
                    } else if (quantity == 100) {
                        apiPart.setPriceFor100(price);
                    }
                }
            }

            logger.info("\nMapped APIPart Object:");
            logger.info(apiPart);

            return apiPart;

        } else {
            logger.info("\nNo parts found in the search results.");
        }

        // Close the client
        client.close();

       return null;
    }

}

