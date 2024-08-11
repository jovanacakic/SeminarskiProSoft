/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.razmena;

import database.DBBroker;
import domen.AbstractDomainObject;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SODodajRazmenu extends OpstaSO {

    private final AbstractDomainObject razmena;
    private boolean uspeh = false;

    public SODodajRazmenu(AbstractDomainObject razmena) {
        this.razmena = razmena;
    }

    public boolean isUspeh() {
        return uspeh;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() {
        uspeh = DBBroker.getInstance().saveOpstiDomenskiObjekat(razmena);
    }

}
