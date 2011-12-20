/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author User
 */
public class JAXBUnmarshallerSample {

    public static void main(String[] args) throws Exception {

        JAXBContext jc = JAXBContext.newInstance(Customer.class, Address.class);
        Unmarshaller u = jc.createUnmarshaller();

        StringBuffer xmlStr = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                                    "<customer>" +
                                        "<address>" +
                                            "<city>Bangkok</city>" +
                                            "<street>Charansanitwong</street>" +
                                        "</address>" +
                                        "<address>" +
                                            "<city>Chiangmai</city>" +
                                            "<street>Nimmanhemin</street>" +
                                        "</address>" +
                                        "<name>Montree</name>" +
                                    "</customer>");
        Customer c = (Customer)u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())));
        System.out.println(c.getName());
        System.out.println(c.getAddresses().get(0).getCity());
    }
}
