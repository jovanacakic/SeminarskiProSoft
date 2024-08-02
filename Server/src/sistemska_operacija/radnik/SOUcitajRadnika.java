/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.radnik;

import database.DBBroker;
import domen.AbstractDomainObject;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOUcitajRadnika extends OpstaSO{

    private AbstractDomainObject radnik;

    public SOUcitajRadnika(AbstractDomainObject radnik) {
        this.radnik = radnik;
    }

    public AbstractDomainObject getRadnik() {
        return radnik;
    }
    
    @Override
    protected void izvrsiSpecificnuOperaciju() {
        radnik = DBBroker.getInstance().getOpstiDomenskiObjekatPoParametru(radnik);
    }
    
}
