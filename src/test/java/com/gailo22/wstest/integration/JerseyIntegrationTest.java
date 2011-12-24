/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest.integration;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.junit.Test;

/**
 *
 * @author User
 */
public class JerseyIntegrationTest {

    @Test
    public void shouldConnectToRestService() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
        // Fluent interfaces
        System.out.println(service.path("rest").path("hello").accept(
                MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());

        // Get plain text
        System.out.println(service.path("rest").path("hello").accept(
                MediaType.TEXT_PLAIN).get(String.class));
        // Get XML
        System.out.println(service.path("rest").path("hello").accept(
                MediaType.TEXT_XML).get(String.class));
        // The HTML
        System.out.println(service.path("rest").path("hello").accept(
                MediaType.TEXT_HTML).get(String.class));

    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri(
                "http://localhost:9999/ws-test").build();
    }
}
