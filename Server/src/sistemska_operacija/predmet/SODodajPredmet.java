/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemska_operacija.predmet;

import database.DBBroker;
import domen.AbstractDomainObject;
import domen.Predmet;
import java.sql.SQLException;
import java.util.List;
import sistemska_operacija.OpstaSO;

/**
 *
 * @author jovana
 */
public class SODodajPredmet extends OpstaSO {

    private final AbstractDomainObject predmet;
    private boolean uspeh = false;

    public SODodajPredmet(AbstractDomainObject predmet) {
        this.predmet = predmet;
    }

    public boolean isUspeh() {
        return uspeh;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws SQLException {
        Predmet noviPredmet = (Predmet) predmet;
        List<AbstractDomainObject> listaStudenata = DBBroker.getInstance().select(predmet);
        for (AbstractDomainObject ado : listaStudenata) {
            Predmet trenutni = (Predmet) ado;

            if (trenutni.equals(noviPredmet)) {
                
                uspeh = false;
                return;
            }
        }
        DBBroker.getInstance().insert(predmet);
        uspeh = true;
    }

}
