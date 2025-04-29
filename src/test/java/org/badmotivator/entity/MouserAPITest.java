package org.badmotivator.entity;

import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MouserAPITest {

    @Test
    public void testMouserJSON() throws Exception {

        /**  Commenting out to test other things
         *
         Client client = ClientBuilder.newClient();
         WebTarget target =
         client.target("https://api.mouser.com/api/v4/search/mouserPartNumber=637-2N3904?apiKey=cb07eb7a-d182-4786-8bfd-ef63d3ec38a8&");

         String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

         assertEquals("???", response);
         */
    }
}