package fit5042.tutex.repository.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Eddie
 */
@Entity
@Table(name = "PROPERTY")
@NamedQueries({
    @NamedQuery(name = "Property.getAll", query = "SELECT u FROM Property u"),
    @NamedQuery(name = "Property.getPropertyById",query = "SELECT u FROM Property u WHERE u.propertyId = :Propertyid")
    })
public class Property implements Serializable {

    /**
     *
     */
    public static final String GET_ALL_QUERY_NAME = "Property.getAll";

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROPERTYID")
    private int propertyId;
  
    @Basic(optional = false)
    @NotNull
    @Column(name = "SIZE")
    private double size;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_of_bedrooms")
    private int numberOfBedrooms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;

    @Embedded
    @Column(name = "ADDRESS")
    private Address address;
    
    
    private Set<String> tags;

    public Property() {
        this.tags = new HashSet<>();
    }

    public Property(int propertyId, Address address, int numberOfBedrooms, double size, double price, Set<String> tags) {
        this.propertyId = propertyId;
        this.address = address;
        this.size = size;
        this.numberOfBedrooms = numberOfBedrooms;
        this.price = price;
        this.tags = tags;
    }

    
  
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @CollectionTable(name = "tag")
    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Property{" + "propertyId=" + propertyId + ", size=" + size + ", numberOfBedrooms=" + numberOfBedrooms + ", price=" + price + ", address=" + address  + ", tags=" + tags + '}';
    }
}
