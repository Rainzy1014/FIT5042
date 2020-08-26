package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Address;
import fit5042.tutex.repository.entities.Property;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Eddie Leung
 * @Guan
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    @PersistenceContext(unitName = "W2ExeSolution-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addProperty(Property property) throws Exception {
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        Property property = entityManager.find(Property.class, id);
//int propertyId, Address address, int numberOfBedrooms, double size, double price, Set<String> tags
//        Address ad = new Address("1","1","1","1","1");
//        Property property = new Property(2,ad,12,12,21,new HashSet<>());
//        Query query = entityManager.createNamedQuery("Property.getPropertyById");
//        query.setParameter("Propertyid", id);
//        property.getTags().size();
//        property = (Property) query.getResultList();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
         return entityManager.createNamedQuery("Property.getAll").getResultList();
//        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
//          return entityManager.createQuery("SELECT u FROM Property u").getResultList();

    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
        Property property = this.searchPropertyById(propertyId);

        if (property != null) {
            entityManager.remove(property);
        }
    }

    @Override
    public void editProperty(Property property) throws Exception {
        entityManager.merge(property);
    }

    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {
       return null;
    }
}
