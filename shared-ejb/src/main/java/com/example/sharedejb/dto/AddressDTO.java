package com.example.sharedejb.dto;

import java.util.Random;

public class AddressDTO {
    private Long id;

    private String strasse;
    private String hNumber;
    private String postcode;
    private String city;

    public AddressDTO(String strasse, String postcode, String hNumber, String city) {
        this.strasse = strasse;
        this.postcode = postcode;
        this.hNumber = hNumber;
        this.city = city;
        this.id= new Random().nextLong();
    }

    public Long getId() {
        return id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String gethNumber() {
        return hNumber;
    }

    public void sethNumber(String hNumber) {
        this.hNumber = hNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
