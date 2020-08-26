/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.calculator;

import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface ComparePropertySessionBeanRemote {
    public void addPropertyID(int propertyId);
    public void removePropertyID(int propertyId);
    public int bestPerRoom();
    
}
