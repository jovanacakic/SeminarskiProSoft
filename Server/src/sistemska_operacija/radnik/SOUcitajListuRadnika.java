/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.radnik;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Radnik;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOUcitajListuRadnika extends OpstaSO{

    private List<AbstractDomainObject> radnici;

    public List<AbstractDomainObject> getRadnici() {
        return radnici;
    }
    
    @Override
    protected void izvrsiSpecificnuOperaciju() {
        radnici = DBBroker.getInstance().getAllOpstiDomenskiObjekats(new Radnik());
    }
    
}
