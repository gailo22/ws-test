/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest.service;

import com.gailo22.wstest.Customer;
import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
@Path("/customer")
public class CustomerService {

    @POST
    @Produces(MediaType.TEXT_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCustomer(Customer customer) {
        try {
            long customerId = persist(customer);
            System.out.println(customer.getName());
            return Response.created(URI.create("/" + customerId)).build();
        } catch (Exception e) {
            throw new WebApplicationException(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Customer getCustomer(@PathParam("id") String customerId) {
        for (Customer customer : CustomerRepository.customers()) {
            if (customer.getId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    private long persist(Customer customer) {
        CustomerRepository.addCustomer(customer);
        Customer newCustomer = getCustomer(customer.getId());
        return Long.valueOf(newCustomer.getId());
    }
}
