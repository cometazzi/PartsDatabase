package org.badmotivator.entity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mouser.APITransistor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MouserAPITest {

    private final Logger logger = LogManager.getLogger(this.getClass());
    @Test
    public void testMouserJSON() throws Exception {
        String apiKey = "redacted again";
        String searchUrl = "https://api.mouser.com/api/v2/search/keyword";
        String keyword = "2n3904";
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

        // Use Jackson to parse the JSON and map to APITransistor
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);

        // Navigate to the parts array
        JsonNode partsNode = rootNode.path("SearchResults").path("Parts");

        if (partsNode.isArray() && partsNode.size() > 0) {
            JsonNode firstPart = partsNode.get(0);
            String mouserPartNumber = firstPart.path("MouserPartNumber").asText();
            JsonNode priceBreaksNode = firstPart.path("PriceBreaks");

            BigDecimal unitPrice = null;
            String currency = null;

            if (priceBreaksNode.isArray()) {
                for (JsonNode priceBreak : priceBreaksNode) {
                    int quantity = priceBreak.path("Quantity").asInt();
                    if (quantity == 1) {
                        String priceStr = priceBreak.path("Price").asText().replace("$", "");
                        unitPrice = new BigDecimal(priceStr);
                        currency = priceBreak.path("Currency").asText();
                        break; // Found the price for quantity 1, so we can stop
                    }
                }
            }

            // Create and populate the APITransistor object
            if (mouserPartNumber != null && unitPrice != null && currency != null) {
                APITransistor transistor = new APITransistor();
                transistor.setMouserPartNumber(mouserPartNumber);
                transistor.setUnitPrice(unitPrice);
                transistor.setCurrency(currency);

                logger.info("\nMapped APITransistor Object:");
                logger.info(transistor);
            } else {
                logger.info("\nCould not find MouserPartNumber or Unit Price (Quantity 1) in the response.");
            }

        } else {
            logger.info("\nNo parts found in the search results.");
        }

        // Close the client
        client.close();
    }


}