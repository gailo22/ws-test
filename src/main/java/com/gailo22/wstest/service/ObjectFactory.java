/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest.service;

import com.gailo22.wstest.Customer;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 *
 * @author User
 */
public class ObjectFactory {

    public JAXBElement<Customer> createCustomer(Customer customer) {
        return new JAXBElement(new QName("http://www.gailo22.com","gailo"),
                Customer.class, customer);
    }
    
}
