/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.ekvivalenti;

import database.DBBroker;
import domen.AbstractDomainObject;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SODodajEkvivalente extends OpstaSO{

    private final AbstractDomainObject ekvivalenti;
    private boolean uspeh = false;

    public SODodajEkvivalente(AbstractDomainObject ekvivalenti) {
        this.ekvivalenti = ekvivalenti;
    }

    public boolean isUspeh() {
        return uspeh;
    }
    
    @Override
    protected void izvrsiSpecificnuOperaciju() {
        uspeh = DBBroker.getInstance().saveOpstiDomenskiObjekat(ekvivalenti);
    }
    
}
