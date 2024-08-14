/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.razmena;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Razmena;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SOObrisiRazmenu extends OpstaSO {

    AbstractDomainObject razmena;
    boolean uspeh = false;

    public SOObrisiRazmenu(Razmena razmena) {
        this.razmena = razmena;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        uspeh = DBBroker.getInstance().delete(razmena);
    }

    public boolean isUspeh() {
        return uspeh;
    }

}
