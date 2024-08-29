/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.ekvivalenti;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Ekvivalenti;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOUcitajListuEkvivalenata extends OpstaSO {

    List<AbstractDomainObject> ekvivalenti;
    
    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        ekvivalenti = DBBroker.getInstance().select(new Ekvivalenti());
    }

    public List<AbstractDomainObject> getEkvivalenti() {
        return ekvivalenti;
    }

}
