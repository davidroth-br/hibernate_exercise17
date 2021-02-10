package dao;

import entities.Locations;

import java.util.List;

public interface LocationsDAO {

    List<Locations> getLocationsByRegion(Integer region);
    List<Object[]> getLocationsByCountryFirstLetter(Character char1, Character char2, Character char3);
}
