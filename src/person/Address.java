package person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String street;
    private String flatNo;
    private String houseNo;
    private String postalCode;
    private String city;
    private String country;

    public Address(String street, String flatNo, String houseNo, String postalCode, String city, String country) {
        this.street = street;
        this.flatNo = flatNo;
        this.houseNo = houseNo;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return houseNo + " " + street + " " + flatNo + " " + city + ", " + postalCode + " " + country;
    }
}
