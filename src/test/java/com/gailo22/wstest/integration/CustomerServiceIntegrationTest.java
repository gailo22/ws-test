/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest.integration;

import com.gailo22.wstest.Customer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author User
 */
public class CustomerServiceIntegrationTest {

    private WebResource service;

    @Before
    public void setup() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        service = client.resource(getBaseURI());
    }

    @Test
    public void shouldInvokePostOnCustomerService() {
        ClientResponse response = service.path("rest").path("customer").path("Montree").accept(
                MediaType.TEXT_XML).post(ClientResponse.class);
        Customer customer = response.getEntity(Customer.class);
        System.out.println(customer.getName());
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri(
                "http://localhost:9999/ws-test").build();
    }
}
