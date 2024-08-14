/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.predmet;

import database.DBBroker;
import domen.AbstractDomainObject;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOAzurirajPredmet extends OpstaSO {

    AbstractDomainObject predmet;
    boolean uspeh = false;

    public SOAzurirajPredmet(AbstractDomainObject predmet) {
        this.predmet = predmet;
    }
    
    
    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        uspeh = DBBroker.getInstance().update(predmet);
    }

    public boolean isUspeh() {
        return uspeh;
    }

}
