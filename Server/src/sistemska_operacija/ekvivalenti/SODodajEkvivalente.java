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
public class SODodajEkvivalente extends OpstaSO {

    private final AbstractDomainObject ekvivalenti;
    private boolean uspeh = false;

    public SODodajEkvivalente(AbstractDomainObject ekvivalenti) {
        this.ekvivalenti = ekvivalenti;
    }

    public boolean isUspeh() {
        return uspeh;
    }

    @Override
    protected void izvrsiSpecificnuOperaciju() throws Exception {
        List<AbstractDomainObject> sviEkvivalenti = DBBroker.getInstance().select(ekvivalenti);
        Ekvivalenti ekvivalenti2 = (Ekvivalenti) ekvivalenti;
        boolean postoji = false;
        for (AbstractDomainObject obj : sviEkvivalenti) {
            Ekvivalenti e = (Ekvivalenti) obj;

            if (e.getPredmetFon().getPredmetID() == ekvivalenti2.getPredmetFon().getPredmetID()
                    && e.getPredmetDrugiFakultet().getPredmetID() == ekvivalenti2.getPredmetDrugiFakultet().getPredmetID()) {
                postoji = true;
                break;
            }
        }

        if (!postoji) {
            DBBroker.getInstance().insert(ekvivalenti);
            uspeh = true;
        } else {
            uspeh = false;
            System.out.println("Ekvivalent sa istim nazivom predmeta, univerzitetom i semestrom već postoji.");
        }
    }
}
