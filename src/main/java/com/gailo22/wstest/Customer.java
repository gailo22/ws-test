/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gailo22.wstest;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement
public class Customer {

    private String id;
    private String name;
    private List<Address> addresses;
    
    public Customer() {
        
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @XmlElement(name = "address")
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
