/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest.service;

import com.gailo22.wstest.Customer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class CustomerRepository {

    private static List<Customer> customers = new ArrayList<Customer>();

    public static List<Customer> customers() {
        customers.add(new Customer("1", "Montree 1"));
        customers.add(new Customer("2", "Montree 2"));
        customers.add(new Customer("3", "Montree 3"));
        customers.add(new Customer("4", "Montree 4"));
        customers.add(new Customer("5", "Montree 5"));
        return customers;
    }
    
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
