package com.servicetp.model;

import org.springframework.stereotype.Component;

@Component
public class People {

    private int _id;
    private String lastname;
    private String firstname;
    private Address address;


    public People(){
        lastname = "default";
        _id = -1;
        firstname = "default";
        address = new Address();
    }

    public People(int _id, String lastname, String firstname, Address address) {
        this._id = _id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }



        public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
