/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest.integration;

import com.gailo22.wstest.Customer;
import com.gailo22.wstest.service.ObjectFactory;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBElement;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author User
 */
public class CustomerServiceIntegrationTest {

    private WebResource webResource;

    @Before
    public void setup() {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        webResource = client.resource(getBaseURI());
    }

    @Test
    public void shouldInvokePostOnCustomerService() {
        ClientResponse response = webResource.path("rest").path("customer").path("Montree").accept(
                MediaType.TEXT_XML).post(ClientResponse.class);
        Customer customer = response.getEntity(Customer.class);
        System.out.println(customer.getName());
    }

    @Test
    public void shouldInvokePostToCreateCustomerOnCustomerService() {
        ObjectFactory factory = new ObjectFactory();
        Customer cust = new Customer();
        cust.setId("123");
        cust.setName("Montree123");
        JAXBElement<Customer> customer = factory.createCustomer(cust);

        ClientResponse response = webResource.type("application/xml").post(ClientResponse.class, customer);
        
        Customer customerResponse = response.getEntity(Customer.class);
        System.out.println(customerResponse.getName());

        System.out.println("POST status: {0}" + response.getStatus());
        if (response.getStatus() == 201) {
            System.out.println("POST succeeded");
        } else {
            System.out.println("POST failed");
        }

    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri(
                "http://localhost:9999/ws-test").build();
    }
}
