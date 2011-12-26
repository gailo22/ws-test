package com.gailo22.wstest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Hello world!
 *
 */
public class JAXBMarshallerSample {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Customer.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        Customer customer = new Customer();
        customer.setName("Montree");
        List<Address> addresses = new ArrayList<Address>();
        Address address = new Address();
        address.setCity("Bangkok");
        address.setStreet("Charansanitwong");
        addresses.add(address);

        address = new Address();
        address.setCity("Chiangmai");
        address.setStreet("Nimmanhemin");
        addresses.add(address);

        customer.setAddresses(addresses);

        m.marshal(customer, System.out);

    }
}
