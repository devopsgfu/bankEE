package address.entity;

public class Address {
    private String strasse;
    private String hNumber;
    private String postcode;
    private String city;

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
