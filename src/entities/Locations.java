package entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "LOCATIONS")
public class Locations {

    @Id
    @Column(name = "location_id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "loc_seq")
//    @SequenceGenerator(name = "loc_seq", sequenceName = "LOCATIONS_SEQ", allocationSize = 100)
    @GenericGenerator(name="loc_seq", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "locations_seq", value = "SEQUENCE")}
    )
    @GeneratedValue(generator = "locations_seq")
    private Integer locationId;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "state_province")
    private String stateProvince;
//    @Column(name = "country_id")
//    private String countryId;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Countries country;

    public Locations() {
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

//    public String getCountryId() {
//        return countryId;
//    }
//
//    public void setCountryId(String countryId) {
//        this.countryId = countryId;
//    }

    public Countries getCountries() {
        return country;
    }

    public void setCountries(Countries countries) {
        this.country = countries;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "locationId=" + locationId +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", countries=" + country +
                '}';
    }
}
