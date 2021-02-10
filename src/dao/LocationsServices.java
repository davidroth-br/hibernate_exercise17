package dao;

import entities.Locations;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import java.util.List;

public class LocationsServices implements LocationsDAO {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public List<Locations> getLocationsByRegion(Integer region) {
        Criteria crit = session.createCriteria(Locations.class);
        Criteria countryCrit = crit.createCriteria("country");
        countryCrit.add(Restrictions.eq("regionId", region));
        return crit.list();
    }

    @Override
    public List<Object[]> getLocationsByCountryFirstLetter(Character char1, Character char2, Character char3) {
        Criteria crit = session.createCriteria(Locations.class);
        Criteria countryCrit = crit.createCriteria("country");
        countryCrit.add(Restrictions.or(Restrictions.like("countryName", char1 + "%"),
                                        Restrictions.like("countryName", char2 + "%"),
                                        Restrictions.like("countryName", char2 + "%")));

        return null;
    }
}
