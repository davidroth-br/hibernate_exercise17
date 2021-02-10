package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "COUNTRIES")
public class Countries {

    @Id
    @Column(name = "country_id")
    private String countryId;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "region_id")
    private Integer regionId;

//    @ManyToOne
//    @JoinColumn(name = "region_id")
//    private Regions region;

    @OneToMany(mappedBy = "country")
    private Set<Locations> location;

    public Countries() {
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }


//    public Regions getRegion() {
//        return region;
//    }
//
//    public void setRegion(Regions region) {
//        this.region = region;
//    }

    public Set<Locations> getLocation() {
        return location;
    }

    public void setLocation(Set<Locations> location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                ", regionId=" + regionId +
                '}';
    }
}
