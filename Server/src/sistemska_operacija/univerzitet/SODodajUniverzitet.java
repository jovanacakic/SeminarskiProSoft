/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.univerzitet;

import database.DBBroker;
import domen.AbstractDomainObject;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SODodajUniverzitet extends OpstaSO{

    AbstractDomainObject univerzitet;
    boolean uspeh = false;

    public SODodajUniverzitet(AbstractDomainObject univerzitet) {
        this.univerzitet = univerzitet;
    }
    
    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        DBBroker.getInstance().insert(univerzitet);
        uspeh = true;
    }

    public boolean isUspeh() {
        return uspeh;
    }
    
}
