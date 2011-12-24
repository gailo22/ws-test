/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest.service;

import com.gailo22.wstest.Customer;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("/customer/{name}")
public class CustomerService {
    
    @POST
    @Produces(MediaType.TEXT_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Customer creatCustomer(@PathParam("name") String name) {
        Customer customer = new Customer();
        customer.setName(name);
        return customer;
    }
    
}
