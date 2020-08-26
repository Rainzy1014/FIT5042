/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.calculator;


import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateful
public class ComparePropertySessionBean implements ComparePropertySessionBeanRemote{

    @PersistenceContext
    private EntityManager entityManager;
    private ArrayList<Integer> roomList;
    @Override
    public void addPropertyID(int propertyId) {
        roomList.add(propertyId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePropertyID(int propertyId) {
        roomList.remove(propertyId); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int bestPerRoom() {
        int bestPropertyId = 0;
        Property property;
        double price;
        int numberOfRooms;
        double bestUnitRoomPrice = 9999999999.99;
        for(Integer propertyId:roomList){
        property = entityManager.find(Property.class, propertyId);
        numberOfRooms = property.getNumberOfBedrooms();
        price = property.getPrice();
        double tmpRate = price/numberOfRooms;
        if(tmpRate<bestUnitRoomPrice){
        bestUnitRoomPrice = tmpRate;
        bestPropertyId = property.getPropertyId();
                }
    }
        return bestPropertyId; //To change body of generated methods, choose Tools | Templates.
    }
      public void init(){
        roomList = new ArrayList();
    }
}
